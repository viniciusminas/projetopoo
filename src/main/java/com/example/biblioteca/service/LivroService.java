package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public void removerLivro(Long id) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro com ID " + id + " não encontrado."));

        boolean possuiReservas = reservaRepository.existsByLivro(livro);

        if (possuiReservas) {
            throw new IllegalStateException("Não é possível remover o livro pois existem reservas associadas.");
        }

        livroRepository.deleteById(id);
    }
}
