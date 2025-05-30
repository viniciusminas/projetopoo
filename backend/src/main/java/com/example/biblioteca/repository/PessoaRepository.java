package com.example.biblioteca.repository;

import com.example.biblioteca.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByEmail(String email);

    Optional<Pessoa> findByTel(String tel);
}
