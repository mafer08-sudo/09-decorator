package co.sena.mercasena.decorator;

import java.math.BigDecimal;

public class SeguroEnvio extends DecoradorCosto {

    public SeguroEnvio(CostoPedido envuelto) {
        super(envuelto);
    }

    @Override
    public BigDecimal costo() {
        BigDecimal base = envuelto.costo();
        BigDecimal seguro = BigDecimal.valueOf(base.doubleValue() * 0.02);
        return base.add(seguro);
    }

    @Override
    public String descripcion() {
        return envuelto.descripcion() + " + seguro";
    }
}
