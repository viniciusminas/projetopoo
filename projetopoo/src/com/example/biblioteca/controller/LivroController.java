package com.example.biblioteca.controller;
import com.example.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/livros")

//endpoints que serão utilizados no projeto com Rest
public class LivroController {

    private List<Livro> livros = new ArrayList<Livro>();

    @GetMapping
    public List<Livro> getTodos() {
        return livros;
    }

    @PostMapping
    public Livro adicionar(@RequestBody Livro livro) {
        livros.add(livro);
        return livro;
    }

    @PutMapping("/{indice}/reservar")
    public Livro reservar(@PathVariable int indice){
        Livro livro = livros.get(indice);
        livro.setReservado(true);
        return livro;
    }

    @DeleteMapping("/{indice}")
    public String deletar(@PathVariable int indice){
        livros.remove(indice);
        return "Livro removido com sucesso."; //fazer tratativas para que não seja possível deletar sem DEVOLVER
    }
}
