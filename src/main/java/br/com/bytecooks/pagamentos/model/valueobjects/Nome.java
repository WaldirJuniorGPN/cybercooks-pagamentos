package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;
import jakarta.persistence.Embeddable;

@Embeddable
public record Nome(String value) {

    private static final int LIMITE_CARACTERES = 100;

    public Nome {
        if (value == null) {
            throw new RegraDeNegocioValidation("Nome não pode ser nulo");
        }

        if (value.isBlank()) {
            throw new RegraDeNegocioValidation("Nome não pode ser um valor vazio");
        }

        if (value.length() > LIMITE_CARACTERES) {
            throw new RegraDeNegocioValidation("Nome não pode ter mais de 100 caracteres");
        }
    }
}
