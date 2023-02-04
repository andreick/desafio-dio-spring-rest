package com.andreick.gof.dto.viacep;

import lombok.Value;

@Value
public class ViaCepDto {

    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    boolean erro;
}
