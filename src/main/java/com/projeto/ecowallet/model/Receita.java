package com.projeto.ecowallet.model;

import java.time.LocalDate;

public class Receita extends Transacao {

    public Receita(){
        super();
    }

    public Receita(String descricao, double valor, LocalDate data, Categoria categoria) {
        super(descricao, valor, data, TipoTransacao.RECEITA, categoria);
    }

    @Override
    public double getValorParaSaldo(){
        return getValor();
    }

}
