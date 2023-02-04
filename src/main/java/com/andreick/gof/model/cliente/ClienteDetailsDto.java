package com.andreick.gof.model.cliente;

import com.andreick.gof.model.endereco.Endereco;
import lombok.Value;

@Value
public class ClienteDetailsDto {

    Long id;
    String nome;
    Endereco endereco;

    public ClienteDetailsDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
    }
}
