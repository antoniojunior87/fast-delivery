package br.com.fastdelivery.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Junior
 */
@Entity(name = "PESSOA")
@SequenceGenerator(schema = "public", name = "SQ_ID_PESSOA", sequenceName = "SQ_ID_PESSOA", allocationSize = 1, initialValue = 1)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(generator = "SQ_ID_PESSOA", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "PESSOA")
    private String nome;
    @Column(name = "CPF")
    private String cpf;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}