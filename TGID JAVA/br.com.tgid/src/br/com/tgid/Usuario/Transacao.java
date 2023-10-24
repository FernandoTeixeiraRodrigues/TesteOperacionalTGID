package br.com.tgid.Usuario;

class Transacao {
    private Cliente cliente;
    private Empresa empresa;
    private double valor;
    private double taxa;

    public Transacao(Cliente cliente, Empresa empresa2, double valor, double taxa) {
        this.cliente = cliente;
        this.empresa = empresa2;
        this.valor = valor;
        this.taxa = taxa;
    }

    // Getters para informações da transação
    public Cliente getCliente() {
        return cliente;
    }

    public TaxaSistema getEmpresa() {
        return empresa;
    }

    public double getValor() {
        return valor;
    }

    public double getTaxa() {
        return taxa;
    }
}

