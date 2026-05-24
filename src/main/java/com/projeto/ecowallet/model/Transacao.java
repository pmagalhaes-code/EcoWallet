package com.projeto.ecowallet.model;

import com.projeto.ecowallet.model.Categoria;
import com.projeto.ecowallet.model.TipoTransacao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipoClasse"
)

@JsonSubTypes({
        @JsonSubTypes.Type(value = Receita.class, name = "RECEITA"),
        @JsonSubTypes.Type(value = Despesa.class, name = "DESPESA")
})

public abstract class Transacao {

    private String descricao;
    private double valor;
    private LocalDate data;
    private TipoTransacao tipo;
    private Categoria categoria;

    public Transacao() {
    }

    public Transacao(String descricao,
                     double valor,
                     LocalDate data,
                     TipoTransacao tipo,
                     Categoria categoria) {

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