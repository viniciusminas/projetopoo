package com.example.biblioteca.service;

import com.example.biblioteca.dto.MultaDTO;
import com.example.biblioteca.model.Multa;
import com.example.biblioteca.model.Pessoa;
import com.example.biblioteca.repository.MultaRepository;
import com.example.biblioteca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Multa criarMulta(MultaDTO dto) {
        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

        Multa multa = new Multa();
        multa.setValor(dto.getValor());
        multa.setDescricao(dto.getDescricao());
        multa.setDataMulta(dto.getDataMulta());
        multa.setPago(dto.isPago());
        multa.setPessoa(pessoa);

        return multaRepository.save(multa);
    }

    public List<Multa> listarMultas() {
        return multaRepository.findAll();
    }

    public Optional<Multa> buscarMulta(Long id) {
        return multaRepository.findById(id);
    }

    public void removerMulta(Long id) {
        multaRepository.deleteById(id);
    }
}
