package com.example.biblioteca.service;

import com.example.biblioteca.model.Pessoa;
import com.example.biblioteca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa salvarPessoa(Pessoa pessoa) {
        try {
            return pessoaRepository.save(pessoa);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Email ou telefone já está em uso.");
        }
    }

    public List<Pessoa> listarTodas() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id) {
        return pessoaRepository.findById(id);
    }

    public void removerPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }
}
