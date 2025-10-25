package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;
import jakarta.persistence.Embeddable;

@Embeddable
public record PedidoId(Long value) {

    public PedidoId {
        if (value == null || value < 0) {
            throw new RegraDeNegocioValidation("ID do pedido está inválido");
        }
    }
}
