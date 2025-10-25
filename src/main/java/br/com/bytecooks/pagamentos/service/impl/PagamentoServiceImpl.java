package br.com.bytecooks.pagamentos.service.impl;

import br.com.bytecooks.pagamentos.controller.dto.request.PagamentoRequest;
import br.com.bytecooks.pagamentos.controller.dto.response.PagamentoResponse;
import br.com.bytecooks.pagamentos.exception.RegraDeNegocioValidation;
import br.com.bytecooks.pagamentos.infra.repository.PagamentoRepository;
import br.com.bytecooks.pagamentos.model.Pagamento;
import br.com.bytecooks.pagamentos.model.PagamentoMapper;
import br.com.bytecooks.pagamentos.model.valueobjects.*;
import br.com.bytecooks.pagamentos.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PagamentoServiceImpl implements PagamentoService {

    private final PagamentoRepository repository;
    private final PagamentoMapper mapper;

    @Override
    public Page<PagamentoResponse> obterTodos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(mapper::mapearPagamentoToPagamentoResponse);
    }

    @Override
    public PagamentoResponse obterPorId(Long id) {
        var pagamento = fazerBuscaNoBanco(id);
        return mapper.mapearPagamentoToPagamentoResponse(pagamento);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PagamentoResponse atualizar(Long id, PagamentoRequest pagamentoRequest) {
        var pagamento = fazerBuscaNoBanco(id);
        pagamento = mapper.atualizar(pagamentoRequest, pagamento);
        repository.save(pagamento);

        return mapper.mapearPagamentoToPagamentoResponse(pagamento);
    }

    @Override
    public PagamentoResponse criar(PagamentoRequest pagamentoRequest) {
        var nome = new Nome(pagamentoRequest.nome());
        var valor = new ValorMonetario(pagamentoRequest.valor());
        var numero = new Numero(pagamentoRequest.numero());
        var expiracao = new Expiracao(pagamentoRequest.expiracao());
        var codigo = new Codigo(pagamentoRequest.codigo());
        var status = pagamentoRequest.status();
        var pedidoId = new PedidoId(pagamentoRequest.pedidoId());
        var formaDePagamentoId = new FormaDePagamentoId(pagamentoRequest.formaDePagamentoId());
        var pagamento = Pagamento.builder()
                .nome(nome)
                .valor(valor)
                .numero(numero)
                .expedicao(expiracao)
                .codigo(codigo)
                .statusEnum(status)
                .pedidoId(pedidoId)
                .formaDePagamentoId(formaDePagamentoId)
                .build();
        repository.save(pagamento);
        return mapper.mapearPagamentoToPagamentoResponse(pagamento);
    }

    private Pagamento fazerBuscaNoBanco(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new RegraDeNegocioValidation(String.format("Nenhum pagamento com ID %d foi encontrado", id)));
    }
}
