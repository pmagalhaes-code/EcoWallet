package com.projeto.ecowallet.service;

import com.projeto.ecowallet.model.Transacao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GerenciadorFinancas {

    private final ObservableList<Transacao> transacoes;

    public GerenciadorFinancas() {
        this.transacoes = FXCollections.observableArrayList();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void removerTransacao(Transacao transacao) {
        transacoes.remove(transacao);
    }

    public ObservableList<Transacao> getTransacoes() {
        return transacoes;
    }

    public double calcularSaldo() {
        double saldo = 0;

        for (Transacao t : transacoes) {
            saldo += t.getValorParaSaldo();
        }

        return saldo;
    }
}
