package br.com.bytecooks.pagamentos.service;

import br.com.bytecooks.pagamentos.controller.dto.request.PagamentoRequest;
import br.com.bytecooks.pagamentos.controller.dto.response.PagamentoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagamentoService {

    Page<PagamentoResponse> obterTodos(Pageable pageable);

    PagamentoResponse obterPorId(Long id);

    void deletar(Long id);

    PagamentoResponse atualizar(Long id, PagamentoRequest pagamentoRequest);

    PagamentoResponse criar(PagamentoRequest pagamentoRequest);
}
