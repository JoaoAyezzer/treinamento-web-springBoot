package br.com.sgsistemas.treinamentobackend.dto;

import br.com.sgsistemas.treinamentobackend.models.Contador;
import br.com.sgsistemas.treinamentobackend.service.MercadoService;

import java.io.Serializable;
import java.util.List;

public class ContadorReadDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cpf;
    private String nome;
    private String contabilidade;
    private String email;
    private List<MercadoDTO> mercados;

    public ContadorReadDTO() {

    }

    public ContadorReadDTO(Contador contador) {
        this.id = contador.getId();
        this.cpf = contador.getCpf();
        this.nome = contador.getNome();
        this.contabilidade = contador.getContabilidade();
        this.email = contador.getEmail();
        this.mercados = MercadoService.fromDTO(contador.getMercados());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MercadoDTO> getMercados() {
        return mercados;
    }

    public void setMercados(List<MercadoDTO> mercados) {
        this.mercados = mercados;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContabilidade() {
        return contabilidade;
    }

    public void setContabilidade(String contabilidade) {
        this.contabilidade = contabilidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
