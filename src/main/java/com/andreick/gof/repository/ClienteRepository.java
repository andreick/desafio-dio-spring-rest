package com.andreick.gof.repository;

import com.andreick.gof.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findAllByAtivoTrue(Pageable pageable);
}
