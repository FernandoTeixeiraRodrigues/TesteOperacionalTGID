package br.com.tgid.Usuario;

public class TaxaSistema {
    private String nome;
    private double percentual;

    public TaxaSistema(String nome, double percentual) {
        this.nome = nome;
        this.percentual = percentual;
    }

    public double calcularTaxa(double valor) {
        return valor * (percentual / 100);
    }

public void realizarTransacao(double valor, Cliente cliente, double saldo) {
    double taxaTotal = calcularTaxa(valor);
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
}