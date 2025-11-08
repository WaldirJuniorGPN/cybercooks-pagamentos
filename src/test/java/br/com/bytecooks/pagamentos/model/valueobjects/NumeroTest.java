package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NumeroTest {

    @Nested
    @DisplayName("Quando criar Numero")
    class Criar {

        @Nested
        @DisplayName("Então deve criar com sucesso quando valor válido")
        class Sucesso {

            @Test
            void deveCriarComSucesso() {
                var expectativa = new Numero("a".repeat(19));
                assertThat(expectativa.value()).isEqualTo("a".repeat(19));
            }
        }

        @Nested
        @DisplayName("Deve lançar exceção quando o valor for inválido")
        class Falha {

            @Test
            void deveFalharQuandoNumeroForMuitoGrande() {
                var numeroGrande = "a".repeat(20);
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Numero(numeroGrande))
                        .withMessage("Número não pode ter mais de 19 caracteres");
            }

            @Test
            void deveFalharQuandoNumeroEstiverEmBranco() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Numero(""))
                        .withMessage("Número não pode ser um valor vazio");
            }

            @Test
            void deveFalharQuandoNumeroForNull() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Numero(null))
                        .withMessage("Número não pode ser nulo");
            }
        }
    }
}