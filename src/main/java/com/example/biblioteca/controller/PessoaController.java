package com.example.biblioteca.controller;

import com.example.biblioteca.model.Pessoa;
import com.example.biblioteca.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        return ResponseEntity.ok(pessoaService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<?> adicionarPessoa(@RequestBody Pessoa pessoa) {
        try {
            Pessoa salva = pessoaService.salvarPessoa(pessoa);
            return ResponseEntity.ok(salva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        Optional<Pessoa> pessoaExistente = pessoaService.buscarPorId(id);
        if (pessoaExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pessoa pessoa = pessoaExistente.get();
        pessoa.setNome(pessoaAtualizada.getNome());
        pessoa.setEndereco(pessoaAtualizada.getEndereco());
        // Apenas sobrescreve se vier valor
        if (pessoaAtualizada.getEmail() != null) pessoa.setEmail(pessoaAtualizada.getEmail());
        if (pessoaAtualizada.getTel() != null) pessoa.setTel(pessoaAtualizada.getTel());

        try {
            return ResponseEntity.ok(pessoaService.salvarPessoa(pessoa));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPessoa(@PathVariable Long id) {
        return pessoaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerPessoa(@PathVariable Long id) {
        pessoaService.removerPessoa(id);
        return ResponseEntity.ok("Pessoa removida com sucesso!");
    }
}