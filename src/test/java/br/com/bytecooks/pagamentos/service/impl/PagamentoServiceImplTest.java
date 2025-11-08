package br.com.bytecooks.pagamentos.service.impl;

import br.com.bytecooks.pagamentos.infra.repository.PagamentoRepository;
import br.com.bytecooks.pagamentos.model.Pagamento;
import br.com.bytecooks.pagamentos.model.PagamentoMapper;
import br.com.bytecooks.pagamentos.service.PagamentoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static br.com.bytecooks.pagamentos.controller.dto.response.factory.PagamentoResponseTestFactory.criarPagamentoResponse;
import static br.com.bytecooks.pagamentos.model.factory.PagamentoTestFactory.criarPagamento;
import static br.com.bytecooks.pagamentos.model.factory.PagamentoTestFactory.obterListaDePagamento;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PagamentoServiceImplTest {

    @InjectMocks
    private PagamentoService service;

    @Mock
    private PagamentoRepository repository;

    @Mock
    private PagamentoMapper mapper;


    @Nested
    @DisplayName("Quando consultar no banco, com retorno paginado")
    class ObterTodos {

        @Nested
        @DisplayName("Então deve retorar uma lista paginada")
        class Sucesso {

            @Test
            void deveRetornarUmaListaPaginada() {
                var pagamentoList = obterListaDePagamento();
                var pageable = PageRequest.of(1, 10);
                var page = new PageImpl<>(pagamentoList, pageable, pagamentoList.size());

                when(mapper.mapearPagamentoToPagamentoResponse(any(Pagamento.class))).thenReturn(criarPagamentoResponse());
                when(repository.findAll(pageable)).thenReturn(page);

                var resultado = service.obterTodos(pageable);
                var elementosNaPagina = resultado.getContent();

                verify(repository, times(1)).findAll(pageable);
                verify(mapper, times(pagamentoList.size())).mapearPagamentoToPagamentoResponse(any(Pagamento.class));
                assertThat(resultado).isNotNull();
                assertThat(elementosNaPagina).hasSize(pagamentoList.size());
            }

            @Test
            void deveRetorarUmaListaPaginadaVazia() {
                var pageable = PageRequest.of(0, 10);
                var page = new PageImpl<Pagamento>(List.of(), pageable, 0);

                when(repository.findAll(pageable)).thenReturn(page);

                var resultado = service.obterTodos(pageable);

                assertThat(resultado).isNotNull();
                assertThat(resultado.getContent()).isEmpty();
                assertThat(resultado.getTotalElements()).isZero();
            }
        }
    }

    @Nested
    @DisplayName("Quando consultar Pagamento por ID")
    class ObterPorId {

        @Nested
        @DisplayName("Então deve retornar um Pagamento correspondente ao ID fornecido")
        class Sucesso {

            @Test
            void deveRetornarPagamentoEquivalenteAoIdFornecido() {
                var id = 1L;
                when(repository.findById(id)).thenReturn(Optional.of(criarPagamento()));
                when(mapper.mapearPagamentoToPagamentoResponse(any(Pagamento.class))).thenReturn(criarPagamentoResponse());

                service.obterPorId(id);

                verify(repository, times(1)).findById(id);
                verify(mapper, times(1)).mapearPagamentoToPagamentoResponse(any(Pagamento.class));
            }
        }
    }

    @Nested
    @DisplayName("Quando deletar pagamento")
    class Deletar {

        @Nested
        @DisplayName("Então deve fazer a deleção física no banco de dados")
        class Sucesso {

            @Test
            void deveFazerDelecaoFisicaComSucesso() {
                var id = 1L;

                repository.deleteById(id);

                verify(repository, times(1)).deleteById(id);
            }
        }
    }
}