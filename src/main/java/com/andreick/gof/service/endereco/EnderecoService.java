package com.andreick.gof.service.endereco;

import com.andreick.gof.model.endereco.Endereco;
import com.andreick.gof.service.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private ViaCepService viaCepService;

    public Endereco getEndereco(String cep) {
        var viaCepDto = viaCepService.consultCep(cep);
        if (viaCepDto.isErro()) {
            throw new RuntimeException("CEP " + cep + " não encontrado");
        }
        return new Endereco(viaCepDto);
    }
}
