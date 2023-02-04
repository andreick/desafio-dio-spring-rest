package com.andreick.gof.dto.cliente;

import com.andreick.gof.model.Cliente;
import com.andreick.gof.model.Endereco;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ClienteDetailsDto> toClienteDetailsDtos(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDetailsDto::new).collect(Collectors.toUnmodifiableList());
    }
}
