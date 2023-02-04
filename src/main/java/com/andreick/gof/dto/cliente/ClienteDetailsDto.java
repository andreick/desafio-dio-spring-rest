package com.andreick.gof.dto.cliente;

import com.andreick.gof.model.Cliente;
import com.andreick.gof.model.Endereco;
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
