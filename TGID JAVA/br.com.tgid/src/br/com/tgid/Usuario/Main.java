package br.com.tgid.Usuario;

 public class Main {
    public static void main(String[] args) {
        // Criando um cliente
        Cliente cliente1 = new Cliente("Cliente 1", "123.456.789-00");

        // Criando uma empresa com callback de notificação
        TransactionCallback callback = new NotificationCallback();
        Empresa empresa1 = new Empresa("Empresa 1", "12.345.678/0001-90", callback);
        empresa1.adicionarTaxa(new TaxaSistema("Taxa A", 2.5));

        // Realizando uma transação
        double valorDeposito = 1000.0;
        empresa1.realizarTransacao(valorDeposito);

        // Verificando o saldo da empresa
        System.out.println("Saldo da Empresa 1: R$" + empresa1.getSaldo());
    }
 }
