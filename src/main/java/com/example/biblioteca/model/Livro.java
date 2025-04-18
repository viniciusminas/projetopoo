package com.example.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")

public class Livro {

    // Construtor padrão obrigatório para JPA
    public Livro() {
        this.reservado = false;
    }

    // Construtor com todos os campos
    public Livro(Long id, boolean reservado, String titulo, String autor, int ano, int edicao) {
        this.id = id;
        this.reservado = reservado;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
    }

    public Livro(String titulo, String autor, int ano, int edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.edicao = edicao;
        this.reservado = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "boolean default false") //como um campo da classe vai virar um coluna no BD
    private boolean reservado;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(nullable = false)
    private int ano;

    @Column(nullable = false)
    private int edicao;

    @OneToOne
    private Reserva reserva;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    //criado esse metodo para facilitar a depuração no console e verificar como os dados estao se comportando
    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                ", edicao=" + edicao +
                ", reservado=" + reservado +
                '}';
    }

    public void setReserva(Object o) {

    }
}