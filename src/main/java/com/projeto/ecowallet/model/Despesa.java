package com.projeto.ecowallet.model;

import java.time.LocalDate;

public class Despesa extends Transacao {
    public Despesa(String descricao, double valor, LocalDate data, TipoTransacao tipo, Categoria categoria) {
        super(descricao, valor, data, tipo, categoria);
    }

    @Override
    public double getValorParaSaldo(){
        return -getValor();
    }
}
