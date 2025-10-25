package br.com.bytecooks.pagamentos.model;

import br.com.bytecooks.pagamentos.model.enuns.StatusEnum;
import br.com.bytecooks.pagamentos.model.valueobjects.*;
import jakarta.persistence.*;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "Pagamento")
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "valor", column = @Column(name = "valor", nullable = false))
    private ValorMonetario valor;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "nome", nullable = false, length = 100))
    private Nome nome;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "numero", nullable = false, length = 19))
    private Numero numero;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "expiracao", nullable = false, length = 7))
    private Expiracao expiracao;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "codigo", nullable = false, length = 3, precision = 3))
    private Codigo codigo;

    @Embedded
    @Column(name = "numero", nullable = false)
    @Enumerated(STRING)
    private StatusEnum status;

    private Long pedidoId;

    private Long formaDePagamentoId;
}
