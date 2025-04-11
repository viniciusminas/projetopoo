package com.example.biblioteca.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "reservas")

public class Reserva {
    @OneToOne
    @JoinColumn(nullable = false, name = "livro_id")
    private Livro livro;
    @OneToOne
    @JoinColumn(nullable = false, name = "pessoa_id")
    private Pessoa pessoa;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int numeroDeReservas;
    @Column(nullable = false)
    private LocalDateTime dataIni;
    @Column(nullable = false)
    private LocalDateTime dataFim;

    public Reserva() {
        this.numeroDeReservas = 1;
        this.dataIni = LocalDateTime.now();
        this.dataFim = LocalDateTime.now();
    }

    public Reserva(Livro livro, Pessoa pessoa, Long id, int numeroDeReservas, LocalDateTime dataIni, LocalDateTime dataFim) {
        this.livro = livro;
        this.pessoa = pessoa;
        this.id = id;
        this.numeroDeReservas = numeroDeReservas;
        this.dataIni = dataIni;
        this.dataFim = dataFim;
    }

    public Livro getLivro() {
        return livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public int getNumeroDeReservas() {
        return numeroDeReservas;
    }

    public LocalDateTime getDataIni() {
        return dataIni;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }
}
