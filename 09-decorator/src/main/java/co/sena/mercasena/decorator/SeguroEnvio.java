package co.sena.mercasena.decorator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SeguroEnvio extends DecoradorCosto {

    public SeguroEnvio(CostoPedido envuelto) {
        super(envuelto);
    }

    @Override
    public BigDecimal costo() {

        BigDecimal base = envuelto.costo();

        BigDecimal seguro = base
                .multiply(new BigDecimal("0.02"))
                .setScale(0, RoundingMode.HALF_UP);

        return base.add(seguro);
    }

    @Override
    public String descripcion() {
        return envuelto.descripcion() + " + seguro";
    }
}