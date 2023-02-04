package com.andreick.gof.dto.cliente;

import com.andreick.gof.model.Cliente;
import com.andreick.gof.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toCliente(ClienteCreateDto dto) {
        var endereco = new Endereco(dto.getCep());
        return Cliente.builder()
                .nome(dto.getNome())
                .endereco(endereco)
                .build();
    }

    public Cliente toCliente(ClienteUpdateDto dto) {
        var endereco = new Endereco(dto.getCep());
        return Cliente.builder().endereco(endereco).build();
    }
}
