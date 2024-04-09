package com.unimed.UnimedPayIntegration.controller.v1;

import com.unimed.UnimedPayIntegration.model.GuiaMedicaTiss;
import com.unimed.UnimedPayIntegration.service.impl.WSRetornoAutorizadorServiceImpl;
import lombok.RequiredArgsConstructor;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WSRetornoAutorizadorController implements WSRetornoAPI {
    @Autowired
    private final WSRetornoAutorizadorServiceImpl wsRetornoAutorizadorServiceImpl;

    @Override
    @PostMapping("/{guiaMedicaIds}/xml")
    public String generateGuiaTissXml(@PathVariable List<Long> guiaMedicaIds) throws JAXBException {
        return wsRetornoAutorizadorServiceImpl.generateGuiaTissXml(guiaMedicaIds);
    }

    @Override
    @GetMapping("/guias-medicas")
    public List<GuiaMedicaTiss> buscarGuiasMedicasPorCriterios(){
        return wsRetornoAutorizadorServiceImpl.buscarGuiasMedicasPorCriterios();
    }

    @Override
    @PostMapping("/encaminhar-unimed-pay")
    public Response encaminharParaUnimedPay(@RequestBody List<GuiaMedicaTiss> guiasMedicas) throws JAXBException, IOException {
        return wsRetornoAutorizadorServiceImpl.encaminharParaUnimedPay(guiasMedicas);
    }
}
