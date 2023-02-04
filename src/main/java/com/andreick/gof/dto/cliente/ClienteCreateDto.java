package com.andreick.gof.dto.cliente;

import com.andreick.gof.validation.constraints.Cep;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
public class ClienteCreateDto {

    @NotBlank
    String nome;

    @NotNull
    @Cep
    String cep;
}
