package com.andreick.gof.dto.endereco;

import com.andreick.gof.model.Endereco;
import lombok.Value;

@Value
public class EnderecoDetailsDto {

    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;

    public EnderecoDetailsDto(Endereco endereco) {
        cep = endereco.getCep();
        logradouro = endereco.getLogradouro();
        complemento = endereco.getComplemento();
        bairro = endereco.getBairro();
        localidade = endereco.getLocalidade();
        uf = endereco.getUf();
    }
}
