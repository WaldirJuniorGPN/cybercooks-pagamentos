package br.com.bytecooks.pagamentos.model;

import br.com.bytecooks.pagamentos.controller.dto.request.PagamentoRequest;
import br.com.bytecooks.pagamentos.controller.dto.response.PagamentoResponse;
import br.com.bytecooks.pagamentos.model.valueobjects.*;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    public PagamentoResponse mapearPagamentoToPagamentoResponse(Pagamento pagamento) {
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

    public Pagamento atualizar(PagamentoRequest pagamentoRequest, Pagamento pagamento) {
        var valor = new ValorMonetario(pagamentoRequest.valor());
        var nome = new Nome(pagamentoRequest.nome());
        var numero = new Numero(pagamentoRequest.numero());
        var expiracao = new Expiracao(pagamentoRequest.expiracao());
        var codigo = new Codigo(pagamentoRequest.codigo());
        var pedidoId = new PedidoId(pagamentoRequest.pedidoId());
        var formaDePagamentoId = new FormaDePagamentoId(pagamentoRequest.formaDePagamentoId());

        return pagamento.atualizarValor(valor)
                .atualizarNome(nome)
                .atualizarNumero(numero)
                .atualizarExpiracao(expiracao)
                .atualizarCodigo(codigo)
                .atualizarStatus(pagamentoRequest.status())
                .atualizarPedidoId(pedidoId)
                .atualizarFormaDePagamentoId(formaDePagamentoId);
    }
}
