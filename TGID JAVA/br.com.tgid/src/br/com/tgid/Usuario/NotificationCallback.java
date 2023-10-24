package br.com.tgid.Usuario;

public class NotificationCallback implements TransactionCallback {
    public void onTransactionComplete(Transacao transacao) {
        // Implemente aqui a notificação por e-mail, SMS, etc.
        System.out.println("Notificação: Transação completa. Cliente: " + transacao.getCliente().getDocumento() + ", Valor: " + transacao.getValor());
    }
}