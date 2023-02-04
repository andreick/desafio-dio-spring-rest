package com.andreick.gof.dto.cliente;

import com.andreick.gof.model.Cliente;
import com.andreick.gof.model.Endereco;
import lombok.Value;

@Value
public class ClienteFullDetailsDto {

    Long id;
    String nome;
    Endereco endereco;
    boolean ativo;

    public ClienteFullDetailsDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = cliente.getEndereco();
        ativo = cliente.isAtivo();
    }
}
