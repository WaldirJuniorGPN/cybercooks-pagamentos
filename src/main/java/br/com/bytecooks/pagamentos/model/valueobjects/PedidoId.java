package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import jakarta.persistence.Embeddable;

@Embeddable
public record PedidoId(Long value) {

    public PedidoId {
        if (value == null || value < 0) {
            throw new RegraDeNegocioException("ID do pedido está inválido");
        }
    }
}
