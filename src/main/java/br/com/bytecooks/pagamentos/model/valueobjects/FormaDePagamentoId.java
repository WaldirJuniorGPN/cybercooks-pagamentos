package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import jakarta.persistence.Embeddable;

@Embeddable
public record FormaDePagamentoId(Long value) {

    public FormaDePagamentoId {
        if (value == null || value < 0) {
            throw new RegraDeNegocioException("ID da Forma de Pagamento está inválido");
        }
    }
}
