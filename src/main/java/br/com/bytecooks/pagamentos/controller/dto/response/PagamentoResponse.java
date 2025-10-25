package br.com.bytecooks.pagamentos.controller.dto.response;

import br.com.bytecooks.pagamentos.model.enuns.StatusEnum;

import java.math.BigDecimal;

public record PagamentoResponse(Long id,
                                BigDecimal valor,
                                String nome,
                                String numero,
                                String expiracao,
                                String codigo,
                                StatusEnum status,
                                Long pedidoId,
                                Long formaDePagamentoId) {
}
