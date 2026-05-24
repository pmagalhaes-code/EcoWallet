package com.projeto.ecowallet.model;

import java.time.LocalDate;

public class Despesa extends Transacao {

    public Despesa(){
        super();
    }

    public Despesa(String descricao, double valor, LocalDate data, Categoria categoria) {
        super(descricao, valor, data, TipoTransacao.DESPESA, categoria);
    }

    @Override
    public double getValorParaSaldo(){
        return -getValor();
    }
}
