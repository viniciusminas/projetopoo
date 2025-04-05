package com.example.biblioteca.model;
//livro.java é o modelo da aplicação
public class Livro {
    private boolean reservado;
    private String titulo;
    private String subtitulo;//ver com o Pedro se será necessário
    private String autor;
    private int ano;
    private int edicao;

    public Livro(String titulo, String autor, int ano, int edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
        this.reservado = false;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
}
