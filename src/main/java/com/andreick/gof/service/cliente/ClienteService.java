package com.andreick.gof.service.cliente;

import com.andreick.gof.model.Cliente;
import com.andreick.gof.repository.ClienteRepository;
import com.andreick.gof.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional
    public Cliente save(Cliente newCliente) {
        var endereco = enderecoService.getEndereco(newCliente.getCep());
        var cliente = newCliente.toBuilder()
                .endereco(endereco)
                .ativo(true)
                .build();
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAllAtivo() {
        return clienteRepository.findAllByAtivoTrue();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente com id " + id + " não encontrado"));
    }

    @Transactional
    public Cliente update(Long id, Cliente updatedCliente) {
        var cliente = findById(id);
        if (!cliente.isAtivo()) throw new RuntimeException("Cliente inativo");
        if (!cliente.getCep().equals(updatedCliente.getCep())) {
            var endereco = enderecoService.getEndereco(updatedCliente.getCep());
            updatedCliente = updatedCliente.toBuilder().endereco(endereco).build();
        }
        cliente.update(updatedCliente);
        return cliente;
    }

    @Transactional
    public void delete(Long id) {
        var cliente = findById(id);
        cliente.delete();
    }
}
