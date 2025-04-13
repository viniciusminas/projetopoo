package com.example.biblioteca.repository;

import com.example.biblioteca.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Métodos personalizados podem ser adicionados aqui
    Reserva findByLivroId(Long livroId);
}