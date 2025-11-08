package br.com.bytecooks.pagamentos.exception;

public class RegraDeNegocioException extends RuntimeException {
    public RegraDeNegocioException(String msg) {
        super(msg);
    }
}
