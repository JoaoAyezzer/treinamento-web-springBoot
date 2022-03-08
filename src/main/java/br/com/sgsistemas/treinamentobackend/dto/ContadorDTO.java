package br.com.sgsistemas.treinamentobackend.dto;

import br.com.sgsistemas.treinamentobackend.models.Contador;
import java.io.Serializable;

public class ContadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cpf;
    private String nome;
    private String contabilidade;
    private String email;


    public ContadorDTO() {

    }

    public ContadorDTO(Contador contador) {
        this.id = contador.getId();
        this.cpf = contador.getCpf();
        this.nome = contador.getNome();
        this.contabilidade = contador.getContabilidade();
        this.email = contador.getEmail();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
