package com.andreick.gof.controller;

import com.andreick.gof.dto.cliente.*;
import com.andreick.gof.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteDetailsDto> create(@RequestBody @Valid ClienteCreateDto dto, UriComponentsBuilder uriBuilder) {
        var cliente = mapper.toCliente(dto);
        clienteService.save(cliente);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDetailsDto(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<ClienteDetailsDto>> getAll(@PageableDefault(size = 5, sort = {"nome", "id"}) Pageable pageable) {
        var clientes = clienteService.findAllAtivo(pageable);
        return ResponseEntity.ok(clientes.map(ClienteDetailsDto::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteFullDetailsDto> get(@PathVariable Long id) {
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(new ClienteFullDetailsDto(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDetailsDto> update(@PathVariable Long id, @RequestBody @Valid ClienteUpdateDto dto) {
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
