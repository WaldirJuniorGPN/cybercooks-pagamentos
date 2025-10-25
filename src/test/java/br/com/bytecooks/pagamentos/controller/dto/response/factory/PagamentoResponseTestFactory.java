package br.com.bytecooks.pagamentos.controller.dto.response.factory;

import br.com.bytecooks.pagamentos.controller.dto.response.PagamentoResponse;
import lombok.NoArgsConstructor;

import static br.com.bytecooks.pagamentos.model.factory.PagamentoTestFactory.criarPagamento;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public final class PagamentoResponseTestFactory {

    public static PagamentoResponse criarPagamentoResponse() {
        var pagamento = criarPagamento();
        return new PagamentoResponse(pagamento.obterId(),
                pagamento.obterValor(),
                pagamento.obterNome(),
                pagamento.obterNumero(),
                pagamento.obterExpiracao(),
                pagamento.obterCodigo(),
                pagamento.obterStatus(),
                pagamento.obterpedidoId(),
                pagamento.obterFormaDePagamentoId());
    }
}