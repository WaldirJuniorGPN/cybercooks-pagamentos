package br.com.bytecooks.pagamentos.model.factory;

import br.com.bytecooks.pagamentos.model.Pagamento;
import br.com.bytecooks.pagamentos.model.enuns.StatusEnum;
import br.com.bytecooks.pagamentos.model.valueobjects.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public final class PagamentoTestFactory {

    private static final String NOME = "Nome-pagamento";
    private static final BigDecimal VALOR = BigDecimal.TEN;
    private static final String NUMERO = "4829173650291847365";
    private static final String EXPIRACAO = "2304197";
    private static final String CODIGO = "134";
    private static final long PEDIDO_ID = 1L;
    private static final long FORMA_DE_PAGAMENTO_ID = 1L;

    public static List<Pagamento> obterListaDePagamento() {
        var pagamento = criarPagamento();

        return List.of(pagamento, pagamento);
    }

    public static Pagamento criarPagamento() {
        var nome = new Nome(NOME);
        var valor = new ValorMonetario(VALOR);
        var numero = new Numero(NUMERO);
        var expiracao = new Expiracao(EXPIRACAO);
        var codigo = new Codigo(CODIGO);
        var pedidoId = new PedidoId(PEDIDO_ID);
        var formaDePagamentoId = new FormaDePagamentoId(FORMA_DE_PAGAMENTO_ID);
        var status = StatusEnum.CRIADO;

        return Pagamento.builder()
                .nome(nome)
                .valor(valor)
                .numero(numero)
                .expedicao(expiracao)
                .codigo(codigo)
                .statusEnum(status)
                .pedidoId(pedidoId)
                .formaDePagamentoId(formaDePagamentoId)
                .build();
    }
}