package co.sena.mercasena.decorator;

import java.math.BigDecimal;

public class EmpaqueRegalo extends DecoradorCosto {

    public EmpaqueRegalo(CostoPedido envuelto) {
        super(envuelto);
    }

    @Override
    public BigDecimal costo() {
        return envuelto.costo().add(BigDecimal.valueOf(5_000));
    }

    @Override
    public String descripcion() {
        return envuelto.descripcion() + " + empaque de regalo";
    }
}
