package com.unimed.UnimedPayIntegration.service.impl;

import com.unimed.UnimedPayIntegration.model.Cabecalho;
import com.unimed.UnimedPayIntegration.model.GuiaMedicaTiss;
import com.unimed.UnimedPayIntegration.model.GuiaTissXml;
import com.unimed.UnimedPayIntegration.repository.ApiRepository;
import com.unimed.UnimedPayIntegration.service.WSRetornoAutorizador;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WSRetornoAutorizadorServiceImpl implements WSRetornoAutorizador {

    private final ApiRepository apiRepository;
    private String xml;

    @Override
    public String generateGuiaTissXml(List<Long> guiaMedicaIds) throws JAXBException {

        List<GuiaMedicaTiss> guiaMedicaTiss = apiRepository.findAllById(guiaMedicaIds);

        // Verificar se a lista de guias médicas está vazia
        if (guiaMedicaTiss == null || guiaMedicaTiss.isEmpty()) {
            throw new IllegalArgumentException("A lista de guias médicas está vazia ou nula.");
        }

        JAXBContext jaxbContext = JAXBContext.newInstance(GuiaTissXml.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter stringWriter = new StringWriter();

        for (GuiaMedicaTiss guia : guiaMedicaTiss) {
            GuiaTissXml guiaTissXml = new GuiaTissXml();
            Cabecalho cabecalho = new Cabecalho();

            cabecalho.setRegistroANS(guia.getRegistroAns());
            cabecalho.setNumeroGuiaPrestador(guia.getNumeroGuiaPrestador());
            cabecalho.setNumeroGuiaOperadora(guia.getNumeroGuiaOperadora());
            cabecalho.setNumeroCarteira(guia.getNumeroCarteira());
            cabecalho.setDataRegistroTransacao(guia.getDataRegistroTransacao());
            cabecalho.setHoraRegistroTransacao(guia.getHoraRegistroTransacao());

            guiaTissXml.getCabecalhos().add(cabecalho);
            guiaTissXml.getGuiasMedicas().add(guia);

            marshaller.marshal(guiaTissXml, stringWriter);
        }



        return stringWriter.toString();
    }
    @Override
    public List<GuiaMedicaTiss> buscarGuiasMedicasPorCriterios() {
        return apiRepository.findAll();
    }
    @Override
    public Response encaminharParaUnimedPay(List<GuiaMedicaTiss> guiasMedicas) throws JAXBException, IOException {

        if (guiasMedicas.isEmpty() || guiasMedicas == null){
            throw new IllegalArgumentException("Informe As Guias");
        }

        List<Long> listId = new ArrayList<>();
        for (GuiaMedicaTiss g: guiasMedicas) {
            listId.add(g.getSequencialTransacao());

            // Gerar XML das guias médicas
             xml = this.generateGuiaTissXml(listId);
        }

        System.out.println("XML gerado: " + xml);

        // Enviar XML para a API UnimedPay , vou substituir "UNIMEDPAY" pela url original
        String unimedPayUrl = "https://jsonplaceholder.typicode.com/posts"; //url fake para teste

        OkHttpClient client = new OkHttpClient();

        // Define como XML
        MediaType mediaType = MediaType.parse("application/xml; charset=utf-8");

        // Cria o corpo da solicitação
        RequestBody requestBody = RequestBody.create(mediaType, xml);

        // Criando a solicitação POST
        Request request = new Request.Builder()
                .url(unimedPayUrl)
                .post(requestBody)
                .build();

        // Envia a solicitação e captura a resposta
        try (Response response = client.newCall(request).execute()) {
            // Verifica se a resposta foi bem-sucedida
            if (!response.isSuccessful()) {
                throw new IOException("Erro ao enviar a solicitação: " + response);
            }

            // Retorna o corpo da resposta
            return response;
        }
    }
}
