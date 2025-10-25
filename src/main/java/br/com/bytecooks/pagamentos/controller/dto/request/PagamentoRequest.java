package br.com.bytecooks.pagamentos.controller.dto.request;

import br.com.bytecooks.pagamentos.model.enuns.StatusEnum;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record PagamentoRequest(

        @NotNull
        @DecimalMin(value = "0", message = "O valor não pode ser menor do que zero")
        BigDecimal valor,

        @NotBlank(message = "O nome não pode ser nulo ou estar em branco")
        @Length(max = 100, message = "O nome não pode ter mais de 100 caracteres")
        String nome,

        @NotBlank(message = "O número não pode ser nulo ou estar em branco")
        @Length(max = 19, message = "O número pode ter no máximo 19 caracteres")
        String numero,

        @NotBlank(message = "A expiração não pode ser nula ou estar em branco")
        @Length(max = 7, message = "A expiração pode ter no máximo 7 caracteres")
        String expiracao,

        @NotBlank(message = "O código não pode ser nulo ou estar em branco")
        @Length(max = 3, message = "O código precisa ter exatamente 3 caracteres")
        String codigo,

        @NotNull(message = "O status não pode ser nulo")
        StatusEnum status,

        @NotNull(message = "O ID do pedido não pode ser nulo")
        Long pedidoId,

        @NotNull(message = "O ID da forma de pagamento não pode ser nulo")
        Long formaDePagamentoId
) {
}
