package co.sena.mercasena.decorator;

import java.math.BigDecimal;

public class EnvioPrioritario extends DecoradorCosto {

    public EnvioPrioritario(CostoPedido envuelto) {
        super(envuelto);
    }

    @Override
    public BigDecimal costo() {
        return BigDecimal.valueOf(8_000);
    }

    @Override
    public String descripcion() {
        return envuelto.descripcion() + " + envío prioritario";
    }
}
