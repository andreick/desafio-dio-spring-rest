package com.andreick.gof.model;

import lombok.*;

import javax.persistence.*;

@Builder
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

    @Builder.Default
    private boolean ativo = true;

    public String getCep() {
        return endereco != null ? endereco.getCep() : null;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco != null && endereco.isFilled()) {
            this.endereco = endereco;
        }
    }

    public void delete() {
        ativo = false;
    }
}
