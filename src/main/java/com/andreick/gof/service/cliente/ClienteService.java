package com.andreick.gof.service.cliente;

import com.andreick.gof.model.cliente.Cliente;
import com.andreick.gof.model.cliente.ClienteCreateDto;
import com.andreick.gof.model.cliente.ClienteRepository;
import com.andreick.gof.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    public Cliente save(ClienteCreateDto dto) {
        var endereco = enderecoService.getEndereco(dto.getCep());
        var cliente = new Cliente(dto, endereco);
        return clienteRepository.save(cliente);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente com id " + id + " não encontrado"));
    }
}
