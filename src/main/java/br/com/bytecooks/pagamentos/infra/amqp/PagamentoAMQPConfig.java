package br.com.bytecooks.pagamentos.infra.amqp;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static br.com.bytecooks.pagamentos.infra.amqp.PagamentoAMQPUtils.QUEUE_PAGAMENTO_DLQ;
import static br.com.bytecooks.pagamentos.infra.amqp.PagamentoAMQPUtils.QUEUE_PROCESSAR_PAGAMENTO;

@Configuration
public class PagamentoAMQPConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue queueProcessarPagamento() {
        return QueueBuilder
                .nonDurable(QUEUE_PROCESSAR_PAGAMENTO)
                .build();
    }

    @Bean
    public Queue queuePagamentoDlq() {
        return QueueBuilder
                .durable(QUEUE_PAGAMENTO_DLQ)
                .build();
    }


    @Bean
    public RabbitAdmin criaRabbaitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> anicializaAddmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }
}
