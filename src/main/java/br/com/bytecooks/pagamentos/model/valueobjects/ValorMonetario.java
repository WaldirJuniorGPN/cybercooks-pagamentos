package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Embeddable
public record ValorMonetario(BigDecimal valor) {

    public ValorMonetario {
        validar(valor);
        valor = arredondar(valor);
    }

    private void validar(BigDecimal valor) {
        if (valor == null) {
            throw new RegraDeNegocioValidation("O valor não pode ser nulo");
        }

        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new RegraDeNegocioValidation("O valor não pode ser negativo");
        }
    }

    private BigDecimal arredondar(BigDecimal valor) {
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}
