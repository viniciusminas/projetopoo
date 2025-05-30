package com.example.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @ManyToOne
    @JoinColumn(name = "pessoa_id") // Adicione esta anotação
    private Pessoa pessoa;

    @Column(nullable = false)
    private int numeroDeReservas;

    @Column(nullable = false)
    private LocalDateTime dataIni;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    public Reserva() {
        this.numeroDeReservas = 1;
        this.dataIni = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public int getNumeroDeReservas() {
        return numeroDeReservas;
    }

    public void setNumeroDeReservas(int numeroDeReservas) {
        this.numeroDeReservas = numeroDeReservas;
    }

    public LocalDateTime getDataIni() {
        return dataIni;
    }

    public void setDataIni(LocalDateTime dataIni) {
        this.dataIni = dataIni;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    @PrePersist
    @PreUpdate
    public void calcularDataFim() {
        if (this.dataIni != null && this.dataFim == null) {
            this.dataFim = this.dataIni.plusDays(10);
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}