package com.unimed.UnimedPayIntegration.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GuiaMedicaTiss implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "sequencialTransacao")
    @Column(name = "SEQUENCIALTRANSACAO")
    private Long sequencialTransacao;

    @XmlElement(name = "dataRegistroTransacao")
    @Column(name = "DATAREGISTROTRANSACAO")
    private LocalDate dataRegistroTransacao ;

    @XmlElement(name = "horaRegistroTransacao")
    @Column(name = "HORAREGISTROTRANSACAO")
    private LocalTime horaRegistroTransacao;

    @XmlElement(name = "registroAns")
    @Column(name = "REGISTROANS")
    private String registroAns;

    @XmlElement(name = "versaoPadrao")
    @Column(name = "VERSAOPADRAO")
    private String versaoPadrao;

    @XmlElement(name = "numeroGuiaPrestador")
    @Column(name = "NUMEROGUIAPRESTADOR")
    private String numeroGuiaPrestador;

    @XmlElement(name = "numeroGuiaOperadora")
    @Column(name = "NUMEROGUIAOPERADORA")
    private String numeroGuiaOperadora;

    @XmlElement(name = "numeroCarteira")
    @Column(name = "NUMEROCARTEIRA")
    private String numeroCarteira;

    @XmlElement(name = "atendimentoRN")
    @Column(name = "ATENDIMENTORN")
    private String atendimentoRN;

    @XmlElement(name = "codigoPrestadorNaOperadora")
    @Column(name = "CODIGOPRESTADORNAOPERADORA")
    private String codigoPrestadorNaOperadora;

    @XmlElement(name = "cpfContratado")
    @Column(name = "CPFCONTRATADO")
    private String cpfContratado;

    @XmlElement(name = "cnpjContratado")
    @Column(name = "CNPJCONTRATADO")
    private String cnpjContratado;

    @XmlElement(name = "codigoTabela")
    @Column(name = "CODIGOTABELA")
    private String codigoTabela;

    @XmlElement(name = "codigoProcedimento")
    @Column(name = "CODIGOPROCEDIMENTO")
    private String codigoProcedimento;

    @XmlElement(name = "descricaoProcedimento")
    @Column(name = "DESCRICAOPROCEDIMENTO")
    private String descricaoProcedimento;

    @XmlElement(name = "quantidadeSolicitada")
    @Column(name = "QUANTIDADESOLICITADA")
    private Integer quantidadeSolicitada;

    @XmlElement(name = "quantidadeAutorizada")
    @Column(name = "QUANTIDADEAUTORIZADA")
    private Integer quantidadeAutorizada;

    @XmlElement(name = "valorAutorizado")
    @Column(name = "VALORAUTORIZADO")
    private Double valorAutorizado;

    @XmlElement(name = "dataAutorizacao")
    @Column(name = "DATAAUTORIZACAO")
    private LocalDate dataAutorizacao ;

    @XmlElement(name = "senha")
    @Column(name = "SENHA")
    private String senha;

    @XmlElement(name = "dataValidadeSenha")
    @Column(name = "DATAVALIDADESENHA")
    private LocalDate dataValidadeSenha ;

    @XmlElement(name = "nomeBeneficiario")
    @Column(name = "NOMEBENEFICIARIO")
    private String nomeBeneficiario;

    @XmlElement(name = "numeroCNS")
    @Column(name = "NUMEROCNS")
    private String numeroCNS;

    @XmlElement(name = "statusSolicitacao")
    @Column(name = "STATUSSOLICITACAO")
    private Integer statusSolicitacao;

    @XmlElement(name = "tipoEtapaAutorizacao")
    @Column(name = "TIPOETAPAAUTORIZACAO")
    private Integer tipoEtapaAutorizacao;
}
