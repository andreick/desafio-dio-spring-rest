package com.andreick.gof.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Embeddable
public class Endereco {

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(nullable = false, length = 40)
    private String logradouro;

    @Column(nullable = false, length = 40)
    private String complemento;

    @Column(nullable = false, length = 40)
    private String bairro;

    @Column(nullable = false, length = 40)
    private String localidade;

    @Column(nullable = false, length = 2)
    private String uf;

    public Endereco(String cep) {
        this.cep = cep;
    }
}
