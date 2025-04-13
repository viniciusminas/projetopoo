package com.example.biblioteca.service;

import com.example.biblioteca.dto.ReservaDTO;
import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.Pessoa;
import com.example.biblioteca.model.Reserva;
import com.example.biblioteca.repository.LivroRepository;
import com.example.biblioteca.repository.PessoaRepository;
import com.example.biblioteca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    // Create
    @Transactional
    public Reserva criarReserva(ReservaDTO reservaDTO) {
        Optional<Livro> livroOptional = livroRepository.findById(reservaDTO.getLivroId());
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(reservaDTO.getPessoaId());

        if (livroOptional.isEmpty()) {
            throw new RuntimeException("Livro não encontrado com ID: " + reservaDTO.getLivroId());
        }
        if (pessoaOptional.isEmpty()) {
            throw new RuntimeException("Pessoa não encontrada com ID: " + reservaDTO.getPessoaId());
        }

        Livro livro = livroOptional.get();
        Pessoa pessoa = pessoaOptional.get();

        if (livro.isReservado()) {
            throw new RuntimeException("Livro já está reservado");
        }

        Reserva reserva = new Reserva();
        reserva.setLivro(livro);
        reserva.setPessoa(pessoa);
        reserva.setDataIni(LocalDateTime.now());
        // dataFim será calculada automaticamente pelo @PrePersist

        livro.setReservado(true);
        livro.setReserva(reserva);

        return reservaRepository.save(reserva);
    }

    // Read (métodos existentes permanecem iguais)
    public List<Reserva> listarTodasReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> buscarReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    public Reserva buscarReservaPorLivroId(Long livroId) {
        return reservaRepository.findByLivroId(livroId);
    }

    // Update
    @Transactional
    public Reserva atualizarReserva(Long id, ReservaDTO reservaDTO) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isEmpty()) {
            throw new RuntimeException("Reserva não encontrada com ID: " + id);
        }

        Reserva reserva = reservaOptional.get();

        // Atualiza apenas os campos permitidos
        if (reservaDTO.getLivroId() != null) {
            Optional<Livro> livroOptional = livroRepository.findById(reservaDTO.getLivroId());
            if (livroOptional.isPresent()) {
                reserva.setLivro(livroOptional.get());
            }
        }

        if (reservaDTO.getPessoaId() != null) {
            Optional<Pessoa> pessoaOptional = pessoaRepository.findById(reservaDTO.getPessoaId());
            if (pessoaOptional.isPresent()) {
                reserva.setPessoa(pessoaOptional.get());
            }
        }

        return reservaRepository.save(reserva);
    }

    // Delete (método existente permanece igual)
    @Transactional
    public void cancelarReserva(Long id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isEmpty()) {
            throw new RuntimeException("Reserva não encontrada com ID: " + id);
        }

        Reserva reserva = reservaOptional.get();
        Livro livro = reserva.getLivro();

        livro.setReservado(false);
        livro.setReserva(null);
        livroRepository.save(livro);

        reservaRepository.delete(reserva);
    }
}