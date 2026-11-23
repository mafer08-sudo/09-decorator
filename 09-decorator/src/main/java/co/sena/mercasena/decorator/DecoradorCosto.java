package co.sena.mercasena.decorator;

/** Decorador abstracto: envuelve otro CostoPedido. */
public abstract class DecoradorCosto implements CostoPedido {

    protected final CostoPedido envuelto;

    protected DecoradorCosto(CostoPedido envuelto) {
        this.envuelto = envuelto;
    }
}
