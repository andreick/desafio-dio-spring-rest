package com.andreick.gof.dto.cliente;

import com.andreick.gof.dto.endereco.EnderecoDetailsDto;
import com.andreick.gof.model.Cliente;
import lombok.Value;

@Value
public class ClienteDetailsDto {

    Long id;
    String nome;
    EnderecoDetailsDto endereco;

    public ClienteDetailsDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = new EnderecoDetailsDto(cliente.getEndereco());
    }
}
