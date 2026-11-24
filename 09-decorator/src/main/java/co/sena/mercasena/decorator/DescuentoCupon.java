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

        BigDecimal costoBase = envuelto.costo();

        BigDecimal descuentoCalculado = costoBase.multiply(PORCENTAJE)
                .setScale(0, RoundingMode.HALF_UP);

        BigDecimal descuentoMaximo = BigDecimal.valueOf(20_000);

        if (descuentoCalculado.compareTo(descuentoMaximo) > 0) {
            descuentoCalculado = descuentoMaximo;
        }

        return costoBase.subtract(descuentoCalculado);
    }

    @Override
    public String descripcion() {
        return envuelto.descripcion() + " - cupón 10%";
    }
}
