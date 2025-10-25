package br.com.bytecooks.pagamentos.exception;

public class RegraDeNegocioValidation extends RuntimeException {
    public RegraDeNegocioValidation(String msg) {
        super(msg);
    }
}
