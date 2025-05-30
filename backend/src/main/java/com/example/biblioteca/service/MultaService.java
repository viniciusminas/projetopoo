package com.example.biblioteca.service;

import com.example.biblioteca.dto.MultaDTO;
import com.example.biblioteca.model.Multa;
import com.example.biblioteca.model.Pessoa;
import com.example.biblioteca.repository.MultaRepository;
import com.example.biblioteca.repository.PessoaRepository;
import com.example.biblioteca.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/* bkp
@Autowired
private ReservaRepository reservaRepository;*/


@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public Multa criarMulta(MultaDTO dto) {
        try {
            Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                    .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + dto.getPessoaId()));

            Multa multa = new Multa();
            multa.setValor(dto.getValor());
            multa.setDescricao(dto.getDescricao());
            multa.setDataMulta(dto.getDataMulta());
            multa.setPago(dto.isPago());
            multa.setPessoa(pessoa);

            if (dto.getReservaId() != null) {
                reservaRepository.findById(dto.getReservaId()).ifPresentOrElse(
                        multa::setReserva,
                        () -> {
                            throw new IllegalArgumentException("Reserva não encontrada com ID: " + dto.getReservaId());
                        }
                );
            }

            return multaRepository.save(multa);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar multa: " + e.getMessage(), e);
        }
    }

    public Multa atualizarMulta(Long id, MultaDTO dto) {
        Multa multa = multaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Multa com ID " + id + " não encontrada."));

        multa.setValor(dto.getValor());
        multa.setDescricao(dto.getDescricao());
        multa.setDataMulta(dto.getDataMulta());
        multa.setPago(dto.isPago());

        if (dto.getPessoaId() != null) {
            Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                    .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com ID: " + dto.getPessoaId()));
            multa.setPessoa(pessoa);
        }

        if (dto.getReservaId() != null) {
            reservaRepository.findById(dto.getReservaId()).ifPresentOrElse(
                    multa::setReserva,
                    () -> {
                        throw new IllegalArgumentException("Reserva não encontrada com ID: " + dto.getReservaId());
                    }
            );
        } else {
            multa.setReserva(null); // permite remover a associação com reserva, se enviado null
        }

        return multaRepository.save(multa);
    }


    public void removerMulta(Long id) {
        try {
            if (!multaRepository.existsById(id)) {
                throw new IllegalArgumentException("Multa com ID " + id + " não encontrada.");
            }
            multaRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao remover multa: " + e.getMessage(), e);
        }
    }

    public List<Multa> listarMultas() {
        return multaRepository.findAll();
    }

    public Optional<Multa> buscarMulta(Long id) {
        return multaRepository.findById(id);
    }
}