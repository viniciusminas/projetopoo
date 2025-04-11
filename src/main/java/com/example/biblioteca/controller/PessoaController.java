package com.example.biblioteca.controller;

import com.example.biblioteca.model.Pessoa;
import com.example.biblioteca.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public Pessoa adicionarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa buscarPessoa(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String removerPessoa(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
        return "Pessoa removida com sucesso!";
    }
}
