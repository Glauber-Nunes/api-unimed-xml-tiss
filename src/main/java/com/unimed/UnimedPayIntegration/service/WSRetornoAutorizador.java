package com.unimed.UnimedPayIntegration.service;

import com.unimed.UnimedPayIntegration.model.GuiaMedicaTiss;
import okhttp3.Response;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public interface WSRetornoAutorizador {

     String generateGuiaTissXml(List<Long> guiaMedicaIds)throws JAXBException;

     List<GuiaMedicaTiss> buscarGuiasMedicasPorCriterios()throws JAXBException;

     Response encaminharParaUnimedPay(List<GuiaMedicaTiss> guiasMedicas)throws JAXBException, IOException;
}
