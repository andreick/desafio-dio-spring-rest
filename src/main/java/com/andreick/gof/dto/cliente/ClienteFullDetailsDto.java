package com.andreick.gof.dto.cliente;

import com.andreick.gof.dto.endereco.EnderecoDetailsDto;
import com.andreick.gof.model.Cliente;
import lombok.Value;

@Value
public class ClienteFullDetailsDto {

    Long id;
    String nome;
    EnderecoDetailsDto endereco;
    boolean ativo;

    public ClienteFullDetailsDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        endereco = new EnderecoDetailsDto(cliente.getEndereco());
        ativo = cliente.isAtivo();
    }
}
