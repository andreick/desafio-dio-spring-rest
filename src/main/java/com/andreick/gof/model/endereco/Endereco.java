package com.andreick.gof.model.endereco;

import com.andreick.gof.model.viacep.ViaCepDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@Getter
@Embeddable
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco(ViaCepDto dto) {
        cep = dto.getCep();
        logradouro = dto.getLogradouro();
        complemento = dto.getComplemento();
        bairro = dto.getBairro();
        localidade = dto.getLocalidade();
        uf = dto.getUf();
    }
}
