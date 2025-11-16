package br.com.bytecooks.pagamentos.infra.amqp;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class PagamentoAMQPUtils {
    public static final String QUEUE_PROCESSAR_PAGAMENTO = "pagamento.processar";
    public static final String QUEUE_PAGAMENTO_DLQ = "pagamento.dlq";
}
