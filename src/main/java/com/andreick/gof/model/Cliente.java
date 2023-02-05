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

    @Column(nullable = false)
    private String nome;

    @Embedded
    @Column(nullable = false)
    private Endereco endereco;

    private boolean ativo;

    public String getCep() {
        return endereco != null ? endereco.getCep() : null;
    }

    public boolean isEnderecoFilled() {
        return endereco != null && endereco.isFilled();
    }

    public void update(Cliente cliente) {
        if (cliente.isEnderecoFilled()) endereco = cliente.getEndereco();
    }

    public void delete() {
        ativo = false;
    }
}
