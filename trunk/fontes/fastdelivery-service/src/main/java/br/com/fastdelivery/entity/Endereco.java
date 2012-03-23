package br.com.fastdelivery.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author Junior
 */
@Entity(name = "ENDERECO")
@SequenceGenerator(schema = "public", name = "SQ_ID_ENDERECO", sequenceName = "SQ_ID_ENDERECO", allocationSize = 1, initialValue = 1)
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(generator = "SQ_ID_ENDERECO", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "RUA")
    private String rua;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}