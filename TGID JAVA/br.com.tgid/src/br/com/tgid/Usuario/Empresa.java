package br.com.tgid.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Empresa extends Usuario {
    private double saldo;
    private List<TaxaSistema> taxas;
	private Cliente cliente;
    public Empresa(String nome, String cnpj, TransactionCallback callback) {
        super(nome, cnpj);
        this.saldo = 0;
        this.taxas = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarTaxa(TaxaSistema taxa) {
        taxas.add(taxa);
    }

    public void realizarTransacao(double valor) {
        double taxaTotal = calcularTaxas(valor);
        double valorFinal = valor - taxaTotal;

        if (valorFinal > 0) {
            saldo += valorFinal;

            // Notificar a empresa e o cliente sobre a transação
            Transacao transacao = new Transacao(cliente, this, valor, taxaTotal);
            TransactionCallback.onTransactionComplete(transacao);
        } else {
            // Lidar com erro de transação inválida
            System.out.println("Erro: Transação inválida. Saldo insuficiente.");
        }
    }

    private double calcularTaxas(double valor) {
        double taxaTotal = 0;
        for (TaxaSistema taxa : taxas) {
            taxaTotal += taxa.calcularTaxa(valor);
        }
        return taxaTotal;
    }
}