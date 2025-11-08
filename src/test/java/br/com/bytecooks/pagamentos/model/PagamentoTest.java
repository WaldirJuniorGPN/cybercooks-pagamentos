package br.com.bytecooks.pagamentos.model;

import br.com.bytecooks.pagamentos.model.valueobjects.Expiracao;
import br.com.bytecooks.pagamentos.model.valueobjects.Nome;
import br.com.bytecooks.pagamentos.model.valueobjects.Numero;
import br.com.bytecooks.pagamentos.model.valueobjects.ValorMonetario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static br.com.bytecooks.pagamentos.model.factory.PagamentoTestFactory.criarPagamento;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static org.assertj.core.api.Assertions.assertThat;

class PagamentoTest {

    private Pagamento pagamento;

    @BeforeEach
    void setUp() {
        pagamento = criarPagamento();
    }

    @Nested
    class Consultas {

        @Test
        @DisplayName("Deve retornar o valor em BigDecimal correspondente")
        void deveObterValorComoBigDecimal() {
            var resultado = pagamento.obterValor();
            assertThat(resultado).isEqualTo(TEN);
        }

        @Test
        @DisplayName("Deve retornar o nome em formato String")
        void deveObterNomeEmFormatoString() {
            var resultado = pagamento.obterNome();
            assertThat(resultado).isEqualTo("Nome-pagamento");
        }

        @Test
        @DisplayName("Deve retornar o número em formato String")
        void deveObterNumeroEmFormatoString() {
            var resultado = pagamento.obterNumero();
            assertThat(resultado).isEqualTo("4829173650291847365");
        }

        @Test
        @DisplayName("Devee retornar expiração em formato String")
        void deveObterExpircacaoEmFormatoString() {
            var resultado = pagamento.obterExpiracao();
            assertThat(resultado).isEqualTo("2304197");
        }

        @Test
        @DisplayName("Deve retornar código em formato String")
        void deveObterCodigoEmFormatoString() {
            var resultado = pagamento.obterCodigo();
            assertThat(resultado).isEqualTo("134");
        }

        @Test
        @DisplayName("Deve retornar ID do Pedido em formato Long")
        void deveObterIdDoPedidoEmFormatoLong() {
            var resultado = pagamento.obterpedidoId();
            assertThat(resultado).isEqualTo(1L);
        }

        @Test
        @DisplayName("Deve retornar ID da Forma de Pagamento em formato Long")
        void deveObterIdDaFormaDePagamentoEmFormatoLong() {
            var resultado = pagamento.obterFormaDePagamentoId();
            assertThat(resultado).isEqualTo(1L);
        }
    }

    @Nested
    class Modificadores {

        @Test
        @DisplayName("Deve alterar nome com sucesso")
        void deveAlterarNomeComSucesso() {
            var novoNome = new Nome("novo nome");
            pagamento.atualizarNome(novoNome);
            assertThat(pagamento.obterNome()).isEqualTo("novo nome");
        }

        @Test
        @DisplayName("Deve alterar valor com sucesso")
        void deveAlteraValorComSucesso() {
            var novoValor = new ValorMonetario(ONE);
            pagamento.atualizarValor(novoValor);
            assertThat(pagamento.obterValor()).isEqualTo(ONE);
        }

        @Test
        @DisplayName("Deve alterar número com sucesso")
        void deveAlterarNumeroComSucesso() {
            var novoNumero = new Numero("12345678910");
            pagamento.atualizarNumero(novoNumero);
            assertThat(pagamento.obterNumero()).isEqualTo("12345678910");
        }

        @Test
        @DisplayName("Deve alterar exiração com sucesso")
        void deveAlterarExpiracaoComSucesso() {
            var novaExpiracao = new Expiracao("123456");
            pagamento.atualizarExpiracao(novaExpiracao);
            assertThat(pagamento.obterExpiracao()).isEqualTo("123456");
        }
    }
}