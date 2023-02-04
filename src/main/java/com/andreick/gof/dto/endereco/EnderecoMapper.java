package com.andreick.gof.dto.endereco;

import com.andreick.gof.dto.viacep.ViaCepDto;
import com.andreick.gof.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public Endereco toEndereco(ViaCepDto dto) {
        return new Endereco(dto.getCep(), dto.getLogradouro(), dto.getComplemento(), dto.getBairro(), dto.getLocalidade(), dto.getUf());
    }
}
