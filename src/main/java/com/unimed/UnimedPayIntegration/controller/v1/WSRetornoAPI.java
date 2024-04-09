package com.unimed.UnimedPayIntegration.controller.v1;

import com.unimed.UnimedPayIntegration.model.GuiaMedicaTiss;
import okhttp3.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RequestMapping("/ws/retorno-autorizador")
public interface WSRetornoAPI {

   String generateGuiaTissXml(@PathVariable List<Long> guiaMedicaIds)throws JAXBException, IOException;

   List<GuiaMedicaTiss> buscarGuiasMedicasPorCriterios()throws JAXBException, IOException;

  Response encaminharParaUnimedPay(@RequestBody List<GuiaMedicaTiss> guiaMedicaIds) throws JAXBException, IOException;
}
