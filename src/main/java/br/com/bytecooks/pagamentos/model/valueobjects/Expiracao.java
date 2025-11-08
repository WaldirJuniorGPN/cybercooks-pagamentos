package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;

public record Expiracao(String value) {

    private static final int LIMITE_CARACTERES = 7;

    public Expiracao {
        if (value == null) {
            throw new RegraDeNegocioException("Expiração não pode ser nulo");
        }

        if (value.isBlank()) {
            throw new RegraDeNegocioException("Expiração não pode ser um valor vazio");
        }

        if (value.length() > LIMITE_CARACTERES) {
            throw new RegraDeNegocioException("Expiração não pode ter mais de 7 caracteres");
        }
    }
}
