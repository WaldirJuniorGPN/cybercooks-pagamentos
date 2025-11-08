package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NomeTest {

    @Nested
    @DisplayName("Quando criar Nome")
    class Criar {

        @Nested
        @DisplayName("Então deve criar com sucesso quando a String for válida")
        class Sucesso {

            @Test
            void criarNomeComSucesso() {
                var nome = new Nome("Nome válido");
                var expectativa = "Nome válido";
                assertThat(expectativa).isEqualTo(nome.value());
            }
        }

        @DisplayName("Então deve lançar exceção quando a String estiver inválida")
        @Nested
        class Falha {

            @Test
            void deveFalharQuandoStringForMaiorQue100Caracteres() {
                var stringMuitoGrande = "a".repeat(101);
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Nome(stringMuitoGrande))
                        .withMessage("Nome não pode ter mais de 100 caracteres");
            }

            @Test
            void deveFalharQuandoStringForNull() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Nome(null))
                        .withMessage("Nome não pode ser nulo");
            }

            @Test
            void deveFalharQuandoStringEstiverEmBranco() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new Nome(""))
                        .withMessage("Nome não pode ser um valor vazio");
            }
        }
    }


}