package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import jakarta.persistence.Embeddable;

@Embeddable
public record Numero(String value) {

    private static final int LIMITE_CARACTERES = 19;

    public Numero {
        if (value == null) {
            throw new RegraDeNegocioException("Número não pode ser nulo");
        }

        if (value.isBlank()) {
            throw new RegraDeNegocioException("Número não pode ser um valor vazio");
        }

        if (value.length() > LIMITE_CARACTERES) {
            throw new RegraDeNegocioException("Número não pode ter mais de 19 caracteres");
        }
    }
}
