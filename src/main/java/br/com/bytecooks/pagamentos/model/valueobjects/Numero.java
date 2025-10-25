package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;

public record Numero(String value) {

    private static final int LIMITE_CARACTERES = 19;

    public Numero {
        if (value == null) {
            throw new RegraDeNegocioValidation("Número não pode ser nulo");
        }

        if (value.isBlank()) {
            throw new RegraDeNegocioValidation("Número não pode ser um valor vazio");
        }

        if (value.length() > LIMITE_CARACTERES) {
            throw new RegraDeNegocioValidation("Número não pode ter mais de 19 caracteres");
        }
    }
}
