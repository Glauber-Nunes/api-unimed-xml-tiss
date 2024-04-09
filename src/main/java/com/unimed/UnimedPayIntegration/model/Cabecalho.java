package com.unimed.UnimedPayIntegration.model;

import lombok.Getter;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Cabecalho implements Serializable {

    @XmlElement(name = "registroANS")
    private String registroANS;

    @XmlElement(name = "numeroGuiaPrestador")
    private String numeroGuiaPrestador;

    @XmlElement(name = "numeroGuiaOperadora")
    private String numeroGuiaOperadora;

    @XmlElement(name = "numeroCarteira")
    private String numeroCarteira;

    @XmlElement(name = "dataRegistroTransacao")
    private LocalDate dataRegistroTransacao ;

    @XmlElement(name = "horaRegistroTransacao")
    private LocalTime horaRegistroTransacao ;
}