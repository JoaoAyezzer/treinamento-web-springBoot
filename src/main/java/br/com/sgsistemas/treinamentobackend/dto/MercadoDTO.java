package br.com.sgsistemas.treinamentobackend.dto;

import br.com.sgsistemas.treinamentobackend.models.Mercado;

import java.io.Serializable;

public class MercadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;
    private String responsavel;
    private Long contadorID;

    public MercadoDTO() {
    }

    public MercadoDTO(Mercado mercado) {
        this.id = mercado.getId();
        this.cnpj = mercado.getCnpj();
        this.nomeFantasia = mercado.getNomeFantasia();
        this.razaoSocial = mercado.getRazaoSocial();
        this.responsavel = mercado.getResponsavel();
        this.contadorID =  ( mercado.getContador() == null ) ?  null  :  mercado.getContador().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Long getContadorID() {
        return contadorID;
    }

    public void setContadorID(Long contadorID) {
        this.contadorID = contadorID;
    }
}
