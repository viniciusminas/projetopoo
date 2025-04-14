package com.example.biblioteca.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="multas")
public class Multa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(length = 255)
    private String descricao;

    @Column(name = "data_multa", nullable = false)
    private LocalDate dataMulta;

    @Column (nullable = false)
    private boolean pago = false;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    public Multa() {
    }

    public Multa(BigDecimal valor, LocalDate dataMulta, Pessoa pessoa) {
        this.valor = valor;
        this.dataMulta = dataMulta;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataMulta() {
        return dataMulta;
    }

    public void setDataMulta(LocalDate dataMulta) {
        this.dataMulta = dataMulta;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setMotivo(String motivo) {

    }

    public void setData(LocalDate data) {

    }
}
