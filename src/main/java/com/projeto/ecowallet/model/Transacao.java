package com.projeto.ecowallet.model;

import java.time.LocalDate;

public abstract class Transacao {

    private String descricao;
    private double valor;
    private LocalDate data;
    private TipoTransacao tipo;
    private Categoria categoria;

    public Transacao(String descricao, double valor, LocalDate data, TipoTransacao tipo, Categoria categoria) {

        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public abstract double getValorParaSaldo();
}