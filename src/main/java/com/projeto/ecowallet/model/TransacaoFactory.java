package com.projeto.ecowallet.model;

import java.time.LocalDate;

public class TransacaoFactory {
    public static Transacao criarTransacao(String tipo, String descricao, double valor, LocalDate data){

        if (tipo.equalsIgnoreCase("receita")){
            return new Receita(descricao, valor, data);
        } else if (tipo.equalsIgnoreCase("despesa")) {
            return  new Despesa(descricao, valor, data);
        } else {
            throw new IllegalArgumentException("Tipo de transação inválida.");
        }
    }
}
