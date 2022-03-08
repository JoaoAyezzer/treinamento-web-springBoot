package br.com.sgsistemas.treinamentobackend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "MERCADOS")
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "cnpj" }) })
public class Mercado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cnpj;
    @Column
    private String nomeFantasia;
    @Column
    private String razaoSocial;
    @Column
    private String responsavel;
    @ManyToOne
    @JoinColumn(name = "CONTADOR_ID")
    private Contador contador;

    public Mercado() {
    }

    public Mercado(String nomeFantasia, String cnpj, String razaoSocial, String responsavel, Contador contador) {
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.responsavel = responsavel;
        this.contador = ( contador == null ) ? null : contador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mercado)) return false;
        Mercado mercado = (Mercado) o;
        return Objects.equals(getId(), mercado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Mercado{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", contadores=" + contador +
                '}';
    }
}
