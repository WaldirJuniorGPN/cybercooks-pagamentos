package br.com.bytecooks.pagamentos.model.valueobjects;

import br.com.bytecooks.pagamentos.exception.RegraDeNegocioException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValorMonetarioTest {

    @Nested
    @DisplayName("Quando criar ValorMonetario")
    class Criar {

        @Nested
        @DisplayName("Então deve criar com sucesso quando valor for válido")
        class Sucesso {

            @Test
            void deveCriarComSucesso() {
                var valorArredondado = BigDecimal.valueOf(20.2222).setScale(2, RoundingMode.HALF_UP);
                var expectativa = new ValorMonetario(BigDecimal.valueOf(20.2222));

                assertThat(expectativa.valor()).isEqualTo(valorArredondado);
            }
        }

        @Nested
        @DisplayName("Então deve falhar quando o valor for inválido")
        class Falha {

            @Test
            void deveFalharQuandoValorForNegativo() {
                var valorNegativo = new BigDecimal("-1.0");
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new ValorMonetario(valorNegativo))
                        .withMessage("O valor não pode ser negativo");
            }

            @Test
            void deveFalharQuandoValorForNull() {
                assertThatExceptionOfType(RegraDeNegocioException.class)
                        .isThrownBy(() -> new ValorMonetario(null))
                        .withMessage("O valor não pode ser nulo");
            }
        }
    }
}