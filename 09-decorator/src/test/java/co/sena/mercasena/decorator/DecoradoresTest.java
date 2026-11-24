package co.sena.mercasena.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DecoradoresTest {

    private static void assertPesos(long esperado, BigDecimal real) {
        assertEquals(0, BigDecimal.valueOf(esperado).compareTo(real), "esperado " + esperado + " pero fue " + real);
    }

    private static CostoPedido base(long valor) {
        return new PedidoBase(BigDecimal.valueOf(valor));
    }

    @Test
    void empaqueDeRegalo() {
        assertPesos(105_000, new EmpaqueRegalo(base(100_000)).costo());
    }

    @Test
    void envioPrioritarioConEmpaque() {
        CostoPedido c = new EnvioPrioritario(new EmpaqueRegalo(base(100_000)));
        assertPesos(113_000, c.costo());
        assertEquals("Pedido + empaque de regalo + envío prioritario", c.descripcion());
    }

    @Test
    void seguroSobreValorRedondo() {
        assertPesos(102_000, new SeguroEnvio(base(100_000)).costo());
    }

    @Test
    void cuponSobrePedidoPequeno() {
        assertPesos(90_000, new DescuentoCupon(base(100_000)).costo());
    }

    @Test
    void cuponDebeRespetarTopeMaximo() {CostoPedido pedido = new DescuentoCupon(base(300_000)); assertPesos(280_000, pedido.costo());}
}
