package com.andreick.gof.service.cliente;

import com.andreick.gof.model.Cliente;
import com.andreick.gof.repository.ClienteRepository;
import com.andreick.gof.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional
    public void save(Cliente newCliente) {
        var endereco = enderecoService.getEndereco(newCliente.getCep());
        newCliente.setEndereco(endereco);
        clienteRepository.save(newCliente);
    }

    public Page<Cliente> findAllAtivo(Pageable pageable) {
        return clienteRepository.findAllByAtivoTrue(pageable);
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente com id " + id + " não encontrado"));
    }

    @Transactional
    public Cliente update(Long id, Cliente updatedCliente) {
        var cliente = findById(id);
        if (!cliente.isAtivo()) throw new RuntimeException("Cliente inativo");
        boolean shouldGetEndereco = updatedCliente.getCep() != null && !updatedCliente.getCep().equals(cliente.getCep());
        if (shouldGetEndereco) {
            var endereco = enderecoService.getEndereco(updatedCliente.getCep());
            cliente.setEndereco(endereco);
        }
        return cliente;
    }

    @Transactional
    public void delete(Long id) {
        var cliente = findById(id);
        cliente.delete();
    }
}
