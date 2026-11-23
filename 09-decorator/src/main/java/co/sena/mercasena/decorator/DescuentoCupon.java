package co.sena.mercasena.decorator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DescuentoCupon extends DecoradorCosto {

    private static final BigDecimal PORCENTAJE = new BigDecimal("0.10");

    public DescuentoCupon(CostoPedido envuelto) {
        super(envuelto);
    }

    @Override
    public BigDecimal costo() {
        BigDecimal base = envuelto.costo();
        BigDecimal descuento = base.multiply(PORCENTAJE).setScale(0, RoundingMode.HALF_UP);
        return base.subtract(descuento);
    }

    @Override
    public String descripcion() {
        return envuelto.descripcion() + " - cupón 10%";
    }
}
