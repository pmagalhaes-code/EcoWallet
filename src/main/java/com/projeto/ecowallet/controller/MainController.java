package com.projeto.ecowallet.controller;

import com.projeto.ecowallet.factory.TransacaoFactory;
import com.projeto.ecowallet.model.*;
import com.projeto.ecowallet.service.GerenciadorFinancas;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtValor;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private ComboBox<String> cbCategoria;

    @FXML
    private DatePicker dpData;

    @FXML
    private Label lblSaldo;

    @FXML
    private TableView<Transacao> tabelaTransacoes;

    @FXML
    private TableColumn<Transacao, String> colDescricao;

    @FXML
    private TableColumn<Transacao, Double> colValor;

    @FXML
    private TableColumn<Transacao, String> colData;

    @FXML
    private TableColumn<Transacao, TipoTransacao> colTipo;

    @FXML
    private TableColumn<Transacao, Categoria> colCategoria;

    private final GerenciadorFinancas gerenciador =
            new GerenciadorFinancas();

    @FXML
    public void initialize() {

        cbTipo.getItems().addAll(
                "RECEITA",
                "DESPESA"
        );

        cbCategoria.getItems().addAll(
                "ALIMENTACAO",
                "TRANSPORTE",
                "LAZER",
                "SALARIO",
                "CONTAS"
        );

        colDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));

        colValor.setCellValueFactory(
                new PropertyValueFactory<>("valor"));

        colData.setCellValueFactory(
                new PropertyValueFactory<>("data"));

        colTipo.setCellValueFactory(
                new PropertyValueFactory<>("tipo"));

        colCategoria.setCellValueFactory(
                new PropertyValueFactory<>("categoria"));

        tabelaTransacoes.setItems(
                gerenciador.getTransacoes()
        );

        atualizarSaldo();
    }

    @FXML
    private void adicionarTransacao() {

        try {

            String descricao = txtDescricao.getText();

            double valor =
                    Double.parseDouble(
                            txtValor.getText()
                    );

            TipoTransacao tipo =
                    TipoTransacao.valueOf(
                            cbTipo.getValue()
                    );

            Categoria categoria =
                    Categoria.valueOf(
                            cbCategoria.getValue()
                    );

            Transacao transacao =
                    TransacaoFactory.criarTransacao(
                            descricao,
                            valor,
                            dpData.getValue(),
                            tipo,
                            categoria
                    );

            gerenciador.adicionarTransacao(
                    transacao
            );

            atualizarSaldo();

            limparCampos();

        } catch (Exception e) {

            mostrarAlerta(
                    "Preencha os campos corretamente!"
            );
        }
    }

    private void atualizarSaldo() {

        lblSaldo.setText(
                String.format(
                        "Saldo Total: R$ %.2f",
                        gerenciador.calcularSaldo()
                )
        );
    }

    private void limparCampos() {

        txtDescricao.clear();
        txtValor.clear();

        cbTipo.setValue(null);
        cbCategoria.setValue(null);

        dpData.setValue(null);
    }

    private void mostrarAlerta(String mensagem) {

        Alert alert =
                new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Aviso");

        alert.setHeaderText(null);

        alert.setContentText(mensagem);

        alert.showAndWait();
    }
}