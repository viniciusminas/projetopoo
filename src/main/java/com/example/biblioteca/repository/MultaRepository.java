package com.example.biblioteca.repository;

import com.example.biblioteca.model.Multa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MultaRepository extends JpaRepository<Multa, Long> {
    List<Multa> findByPessoaId(Long pessoaId); //buscar todas as multas de uma pessoa específica
}
