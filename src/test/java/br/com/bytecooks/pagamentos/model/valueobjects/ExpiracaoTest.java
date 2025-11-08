package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ExpiracaoTest {

    @Nested
    @DisplayName("Quando criar um Expiracao")
    class Criar {

        @Nested
        @DisplayName("Então deve criar com sucesso quando o valor for válido")
        class Sucesso {

            @Test
            void deveCriarComSucesso() {
                var expectativa = new Expiracao("a".repeat(7));
                assertThat(expectativa.value()).isEqualTo("a".repeat(7));
            }
        }

        @Nested
        @DisplayName("Então deve lançar exceção quando valor for inválido")
        class Falha {

            @Test
            void deveFalharQuandoValorForNull() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Expiracao(null))
                        .withMessage("Expiração não pode ser nulo");
            }

            @Test
            void deveFalharQuandoValorForVazio() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Expiracao(""))
                        .withMessage("Expiração não pode ser um valor vazio");
            }

            @Test
            void deveFalharQuandoValorForMuitoGrande() {
                var stringMuitoGrande = "a".repeat(10);
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Expiracao(stringMuitoGrande))
                        .withMessage("Expiração não pode ter mais de 7 caracteres");
            }
        }
    }
}