package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;

public record Codigo(String value) {

    private static final int LIMITE_CARACTERES = 3;

    public Codigo {
        if (value == null) {
            throw new RegraDeNegocioException("Código não pode ser nulo");
        }

        if (value.isBlank()) {
            throw new RegraDeNegocioException("Código não pode ser um valor vazio");
        }   

        if (value.length() != LIMITE_CARACTERES) {
            throw new RegraDeNegocioException("Código deve ter exatamente 3 caractéres");
        }
    }
}
