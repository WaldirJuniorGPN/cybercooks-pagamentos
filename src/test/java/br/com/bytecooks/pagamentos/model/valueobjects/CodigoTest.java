package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CodigoTest {

    @Nested
    @DisplayName("Quando criar Codigo")
    class Criar {

        @Nested
        @DisplayName("Então deve criar com sucesso quando valor for válido")
        class Sucesso {

            @Test
            void deveCriarComSucesso() {
                var codigo = new Codigo("123");
                assertThat(codigo.value()).isEqualTo("123");
            }
        }

        @Nested
        @DisplayName("Então deve falhar quando o valor for inválido")
        class Falha {

            @Test
            void deveFalharQuandoValorForNull() {
                assertThatExceptionOfType(ReflectiveOperationException.class)
                        .isThrownBy(() -> new Codigo(null))
                        .withMessage("Código não pode ser nulo");
            }

            @Test
            void deveFalharQuandoValorForVazio() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Codigo(""))
                        .withMessage("Código não pode ser um valor vazio");
            }

            @Test
            void deveFalharQuandoValorTiverMenosDe3Caracteres() {
                var stringPequena = "a".repeat(2);
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Codigo(stringPequena))
                        .withMessage("Código deve ter exatamente 3 caracteres");
            }

            @Test
            void deveFalharQuandoValorTiverMaisDe3Caracteres() {
                var stringGrande = "a".repeat(4);
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Codigo(stringGrande))
                        .withMessage("Código deve ter exatamente 3 caracteres");
            }
        }
    }
}