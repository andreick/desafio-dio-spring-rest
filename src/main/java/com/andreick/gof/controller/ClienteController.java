package com.andreick.gof.controller;

import com.andreick.gof.dto.cliente.*;
import com.andreick.gof.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteDetailsDto> create(@RequestBody ClienteCreateDto dto, UriComponentsBuilder uriBuilder) {
        var cliente = mapper.toCliente(dto);
        cliente = clienteService.save(cliente);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDetailsDto(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDetailsDto>> getAll() {
        var clientes = clienteService.findAllAtivo();
        return ResponseEntity.ok(mapper.toClienteDetailsDtos(clientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFullDetailsDto> get(@PathVariable Long id) {
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(new ClienteFullDetailsDto(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDetailsDto> update(@PathVariable Long id, @RequestBody ClienteUpdateDto dto) {
        var cliente = mapper.toCliente(dto);
        cliente = clienteService.update(id, cliente);
        return ResponseEntity.ok(new ClienteDetailsDto(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
