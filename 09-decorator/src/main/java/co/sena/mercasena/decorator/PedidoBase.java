package co.sena.mercasena.decorator;

import java.math.BigDecimal;

public class PedidoBase implements CostoPedido {

    private final BigDecimal subtotal;

    public PedidoBase(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public BigDecimal costo() {
        return subtotal;
    }

    @Override
    public String descripcion() {
        return "Pedido";
    }
}
