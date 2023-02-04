package com.andreick.gof.service.viacep;

import com.andreick.gof.dto.viacep.ViaCepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json")
    ViaCepDto consultCep(@PathVariable String cep);
}
