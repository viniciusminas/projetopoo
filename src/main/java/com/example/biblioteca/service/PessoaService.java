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

    public Pessoa atualizarPessoa(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));

        Optional<Pessoa> pessoaPorEmail = pessoaRepository.findByEmail(pessoaAtualizada.getEmail());
        if (pessoaPorEmail.isPresent() && !pessoaPorEmail.get().getId().equals(id)) {
            throw new IllegalArgumentException("Email já está em uso.");
        }

        Optional<Pessoa> pessoaPorTelefone = pessoaRepository.findByTel(pessoaAtualizada.getTel());
        if (pessoaPorTelefone.isPresent() && !pessoaPorTelefone.get().getId().equals(id)) {
            throw new IllegalArgumentException("Telefone já está em uso.");
        }

        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setEmail(pessoaAtualizada.getEmail());
        pessoaExistente.setTel(pessoaAtualizada.getTel());

        return pessoaRepository.save(pessoaExistente);
    }


    public Pessoa salvarPessoa(Pessoa pessoa) {
        pessoaRepository.findByEmail(pessoa.getEmail()).ifPresent(existing -> {
            if (!existing.getId().equals(pessoa.getId())) {
                throw new IllegalArgumentException("Email ou telefone já está em uso.");
            }
        });

        pessoaRepository.findByTel(pessoa.getTel()).ifPresent(existing -> {
            if (!existing.getId().equals(pessoa.getId())) {
                throw new IllegalArgumentException("Email ou telefone já está em uso.");
            }
        });

        if (pessoa.getEndereco() == null) {
            throw new IllegalArgumentException("O campo 'endereco' da pessoa não pode ser nulo.");
        }

        return pessoaRepository.save(pessoa);

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
