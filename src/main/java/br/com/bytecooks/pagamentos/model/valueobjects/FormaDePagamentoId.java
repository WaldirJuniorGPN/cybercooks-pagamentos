package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;
import jakarta.persistence.Embeddable;

@Embeddable
public record FormaDePagamentoId(Long value) {

    public FormaDePagamentoId {
        if (value == null || value < 0) {
            throw new RegraDeNegocioValidation("ID da Forma de Pagamento está inválido");
        }
    }
}
