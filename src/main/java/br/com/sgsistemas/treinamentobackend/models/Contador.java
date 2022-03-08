package br.com.sgsistemas.treinamentobackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity(name = "CONTADORES")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cpf","email" }) })
public class Contador implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String nome;
    @Column
    private String contabilidade;
    @Column(unique=true)
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "contador")
    private List<Mercado> mercados;

    public Contador() {
    }

    public Contador(String cpf, String nome, String contabilidade, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.contabilidade = contabilidade;
        this.email = email;
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

    public List<Mercado> getMercados() {
        return mercados;
    }

    public void setMercados(List<Mercado> mercados) {
        this.mercados = mercados;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contador)) return false;
        Contador contador = (Contador) o;
        return getId().equals(contador.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Contador{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", contabilidade='" + contabilidade + '\'' +
                ", email='" + email + '\'' +
                ", mercados=" + mercados +
                '}';
    }
}
