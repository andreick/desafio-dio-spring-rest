package com.andreick.gof.model;

import lombok.*;

import javax.persistence.*;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public String getCep() {
        return endereco != null ? endereco.getCep() : null;
    }

    public void update(Cliente cliente) {
        if (cliente.getEndereco() != null) endereco = cliente.getEndereco();
    }

    public void delete() {
        ativo = false;
    }
}
