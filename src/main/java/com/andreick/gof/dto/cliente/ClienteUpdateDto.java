package com.andreick.gof.dto.cliente;

import com.andreick.gof.validation.constraints.Cep;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClienteUpdateDto {

    @NotNull
    @Cep
    private String cep;
}
