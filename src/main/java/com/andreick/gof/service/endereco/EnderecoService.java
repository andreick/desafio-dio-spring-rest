package com.andreick.gof.service.endereco;

import com.andreick.gof.dto.endereco.EnderecoMapper;
import com.andreick.gof.model.Endereco;
import com.andreick.gof.service.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private ViaCepService viaCepService;

    @Autowired
    private EnderecoMapper mapper;

    public Endereco getEndereco(String cep) {
        var viaCepDto = viaCepService.consultCep(cep);
        if (viaCepDto.isErro()) {
            throw new RuntimeException("CEP " + cep + " não encontrado");
        }
        return mapper.toEndereco(viaCepDto);
    }
}
