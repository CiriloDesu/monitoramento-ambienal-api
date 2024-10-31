package br.com.fiap.alertas.exception;

public class AlertaNaoEncotradoException extends RuntimeException {
    public AlertaNaoEncotradoException(String mensagem) {
        super(mensagem);
    }
}
