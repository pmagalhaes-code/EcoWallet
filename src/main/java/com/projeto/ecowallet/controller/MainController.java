package com.projeto.ecowallet.controller;
import  com.projeto.ecowallet.model.*;

import java.time.LocalDate;

public class MainController {
    private GerenciadorFinancas gerenciador = new GerenciadorFinancas();

    public void adicionarTransacao(String tipo, String descricao, String valorTexto, String dataTexto){
        try {
            double valor = Double.parseDouble(valorTexto);
            LocalDate data = LocalDate.parse(dataTexto);
            Transacao transacao = TransacaoFactory.criarTransacao(tipo, descricao, valor, data);
            gerenciador.adicionarTransacao(transacao);

            System.out.println("Saldo atual: " + gerenciador.calcularSaldo());
        } catch (NumberFormatException e){
            System.out.println("Erro: Valor inválido!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
