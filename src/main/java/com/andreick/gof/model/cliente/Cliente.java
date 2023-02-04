package com.andreick.gof.model.cliente;

import com.andreick.gof.model.endereco.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity(name = "Cliente")
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Embedded
    private Endereco endereco;

    public Cliente(ClienteCreateDto dto, Endereco endereco) {
        nome = dto.getNome();
        this.endereco = endereco;
    }
}
