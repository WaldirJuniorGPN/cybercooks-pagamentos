package br.com.bytecooks.pagamentos.model;

import br.com.bytecooks.pagamentos.model.enuns.StatusEnum;
import br.com.bytecooks.pagamentos.model.valueobjects.*;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public final class PagamentoBuilder {

    public static INome builder() {
        return new Step();
    }

    public interface INome {
        IValor nome(Nome nome);
    }

    public interface IValor {
        INumero valor(ValorMonetario valor);
    }

    public interface INumero {
        IExpiracao numero(Numero numero);
    }

    public interface IExpiracao {
        ICodigo expedicao(Expiracao expiracao);
    }

    public interface ICodigo {
        IStatusEnum codigo(Codigo codigo);
    }

    public interface IStatusEnum {
        IPedidoId statusEnum(StatusEnum statusEnum);
    }

    public interface IPedidoId {
        IFormaDePagamentoId pedidoId(PedidoId pedidoId);
    }

    public interface IFormaDePagamentoId {
        IBuild formaDePagamentoId(FormaDePagamentoId formaDePagamentoId);
    }

    public interface IBuild {
        Pagamento build();
    }

    private static final class Step implements INome, IValor, INumero, IExpiracao, ICodigo, IStatusEnum, IPedidoId, IFormaDePagamentoId, IBuild {

        private Nome nome;
        private ValorMonetario valor;
        private Numero numero;
        private Expiracao expiracao;
        private Codigo codigo;
        private StatusEnum status;
        private PedidoId pedidoId;
        private FormaDePagamentoId formaDePagamentoId;

        @Override
        public Pagamento build() {
            return new Pagamento(nome,
                    valor,
                    numero,
                    expiracao,
                    codigo,
                    status,
                    pedidoId,
                    formaDePagamentoId);
        }

        @Override
        public IStatusEnum codigo(Codigo codigo) {
            this.codigo = codigo;
            return this;
        }

        @Override
        public ICodigo expedicao(Expiracao expiracao) {
            this.expiracao = expiracao;
            return this;
        }

        @Override
        public IBuild formaDePagamentoId(FormaDePagamentoId formaDePagamentoId) {
            this.formaDePagamentoId = formaDePagamentoId;
            return this;
        }

        @Override
        public IValor nome(Nome nome) {
            this.nome = nome;
            return this;
        }

        @Override
        public IExpiracao numero(Numero numero) {
            this.numero = numero;
            return this;
        }

        @Override
        public IFormaDePagamentoId pedidoId(PedidoId pedidoId) {
            this.pedidoId = pedidoId;
            return this;
        }

        @Override
        public IPedidoId statusEnum(StatusEnum status) {
            this.status = status;
            return this;
        }

        @Override
        public INumero valor(ValorMonetario valor) {
            this.valor = valor;
            return this;
        }
    }
}
