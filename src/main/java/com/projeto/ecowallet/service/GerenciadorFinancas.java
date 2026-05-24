package com.projeto.ecowallet.service;

import com.projeto.ecowallet.model.Transacao;
import com.projeto.ecowallet.persistence.PersistenciaJson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GerenciadorFinancas {

    private final ObservableList<Transacao> transacoes;
    private final PersistenciaJson persistencia;

    public GerenciadorFinancas() {
        this.persistencia = new PersistenciaJson();
        this.transacoes = FXCollections.observableArrayList(
                persistencia.carregar()   // ← carrega do disco ao iniciar
        );
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
        persistencia.salvar(transacoes);  // ← persiste sempre que adiciona
    }

    public void removerTransacao(Transacao transacao) {
        transacoes.remove(transacao);
        persistencia.salvar(transacoes);  // ← persiste sempre que remove
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
