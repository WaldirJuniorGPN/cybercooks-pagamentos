package br.com.bytecooks.pagamentos.model;

import br.com.bytecooks.pagamentos.model.enuns.StatusEnum;
import br.com.bytecooks.pagamentos.model.valueobjects.*;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity(name = "Pagamento")
@Table(name = "pagamentos")
@NoArgsConstructor(access = PROTECTED)
public class Pagamento {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "nome", nullable = false, length = 100))
    private Nome nome;

    @Embedded
    @AttributeOverride(name = "valor", column = @Column(name = "valor", nullable = false))
    private ValorMonetario valor;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "numero", nullable = false, length = 19))
    private Numero numero;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "expiracao", nullable = false, length = 7))
    private Expiracao expiracao;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "codigo", nullable = false, length = 3, precision = 3))
    private Codigo codigo;

    @Column(name = "status", nullable = false)
    @Enumerated(STRING)
    private StatusEnum status;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "pedido_id"))
    private PedidoId pedidoId;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "fomra_de_pagamento_id"))
    private FormaDePagamentoId formaDePagamentoId;

    public Long obterId() {
        return id;
    }

    @SuppressWarnings("java:S107")
    Pagamento(Nome nome,
              ValorMonetario valor,
              Numero numero,
              Expiracao expiracao,
              Codigo codigo,
              StatusEnum status,
              PedidoId pedidoId,
              FormaDePagamentoId formaDePagamentoId) {
        this.nome = nome;
        this.valor = valor;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.pedidoId = pedidoId;
        this.formaDePagamentoId = formaDePagamentoId;
    }

    public static PagamentoBuilder.INome builder() {
        return PagamentoBuilder.builder();
    }

    public BigDecimal obterValor() {
        return valor.valor();
    }

    public String obterNome() {
        return nome.value();
    }

    public String obterNumero() {
        return numero.value();
    }

    public String obterExpiracao() {
        return expiracao.value();
    }

    public String obterCodigo() {
        return codigo.value();
    }

    public StatusEnum obterStatus() {
        return status;
    }

    public Long obterpedidoId() {
        return pedidoId.value();
    }

    public Long obterFormaDePagamentoId() {
        return formaDePagamentoId.value();
    }

    public Pagamento atualizarNome(Nome nome) {
        this.nome = nome;
        return this;
    }

    public Pagamento atualizarValor(ValorMonetario valor) {
        this.valor = valor;
        return this;
    }

    public Pagamento atualizarNumero(Numero numero) {
        this.numero = numero;
        return this;
    }

    public Pagamento atualizarExpiracao(Expiracao expiracao) {
        this.expiracao = expiracao;
        return this;
    }

    public Pagamento atualizarCodigo(Codigo codigo) {
        this.codigo = codigo;
        return this;
    }

    public Pagamento atualizarStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public Pagamento atualizarPedidoId(PedidoId pedidoId) {
        this.pedidoId = pedidoId;
        return this;
    }

    public Pagamento atualizarFormaDePagamentoId(FormaDePagamentoId formaDePagamentoId) {
        this.formaDePagamentoId = formaDePagamentoId;
        return this;
    }
}
