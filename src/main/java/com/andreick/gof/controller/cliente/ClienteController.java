package com.andreick.gof.controller.cliente;

import com.andreick.gof.model.cliente.ClienteCreateDto;
import com.andreick.gof.model.cliente.ClienteDetailsDto;
import com.andreick.gof.service.cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDetailsDto> create(@RequestBody ClienteCreateDto dto, UriComponentsBuilder uriBuilder) {
        var cliente = clienteService.save(dto);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDetailsDto(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetailsDto> get(@PathVariable Long id) {
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(new ClienteDetailsDto(cliente));
    }
}
