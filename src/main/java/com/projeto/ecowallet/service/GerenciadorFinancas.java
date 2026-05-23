package com.projeto.ecowallet.service;
import com.projeto.ecowallet.model.Transacao;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorFinancas {

    private List<Transacao> transacoes;

    public GerenciadorFinancas(){
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    public double calcularSaldo(){
        double saldo = 0;

        for (Transacao t : transacoes){
            saldo += t.getValorParaSaldo();
        }
        return saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
