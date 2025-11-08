package br.com.bytecooks.pagamentos.infra.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ms-pedidos")
public interface PedidoClient {

    @PostMapping(value = "/v1/pedidos/{id}/pago")
    void atualizaPagamento(@PathVariable Long id);

}
