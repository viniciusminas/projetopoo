package com.example.biblioteca.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MultaDTO {

    private BigDecimal valor;
    private String descricao;
    private LocalDate dataMulta;
    private boolean pago;
    private Long pessoaId;

    // Getters e Setters
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

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }
}
