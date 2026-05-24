package com.projeto.ecowallet.factory;

import com.projeto.ecowallet.model.Despesa;
import com.projeto.ecowallet.model.Receita;
import com.projeto.ecowallet.model.TipoTransacao;
import com.projeto.ecowallet.model.Transacao;

import java.time.LocalDate;

public class TransacaoFactory {
    public static Transacao criarTransacao(TipoTransacao tipo, String descricao, double valor, LocalDate data) {

        switch (tipo) {
            case RECEITA:
                return  new Receita(descricao, valor, data);
            case DESPESA:
                return new Despesa(descricao, valor, data);
            default:
                throw new IllegalArgumentException("Tipo de transação inválido");
        }

    }
}


