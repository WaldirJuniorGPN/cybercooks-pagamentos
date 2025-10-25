package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public record ValorMonetario(BigDecimal valor) {

    public ValorMonetario {
        if (valor == null) {
            throw new RegraDeNegocioValidation("O valor não pode ser nulo");
        }

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new RegraDeNegocioValidation("O valor não pode ser negativo");
        }
    }
}
