package co.sena.mercasena.decorator;

import java.math.BigDecimal;

/** Componente del patrón Decorator. */
public interface CostoPedido {

    BigDecimal costo();

    String descripcion();
}
