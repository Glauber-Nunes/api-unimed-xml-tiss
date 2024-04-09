package com.unimed.UnimedPayIntegration.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ansTISS",namespace = "http://www.ans.gov.br/padroes/tiss/schemas")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuiaTissXml implements Serializable {

    @XmlElement(name = "cabecalho")
    private List<Cabecalho> cabecalhos = new ArrayList<>();

    @XmlElement(name = "guiaMedica", namespace = "http://www.ans.gov.br/padroes/tiss/schemas")
    private List<GuiaMedicaTiss> guiasMedicas = new ArrayList<>();


}
