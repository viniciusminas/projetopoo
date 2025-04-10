package com.example.biblioteca.controller;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    @GetMapping("/{id}")
    public Livro buscarLivro(@PathVariable Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/reservar")
    public Livro reservarLivro(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null && !livro.isReservado()) {
            livro.setReservado(true);
            livroRepository.save(livro);

            //APENAS TESTE
            System.out.println("Livro reservado com sucesso!" + livro);
        } else if (livro != null && livro.isReservado()) {
            System.out.println("Livro já estava reservado: " + livro);
        } else {
            System.out.println("Livro não encontrado com ID: " + id);
        }
        return livro;
    }

    @PutMapping("/{id}/devolver")
    public Livro devolverLivro(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null && livro.isReservado()) {
            livro.setReservado(false);
            livroRepository.save(livro);
        }
        return livro;
    }

    @DeleteMapping("/{id}")
    public String removerLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return "Livro removido com sucesso!";
    }
}
