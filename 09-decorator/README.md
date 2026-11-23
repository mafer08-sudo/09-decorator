# MercaSENA · Patrón Decorator (Estructural)

**Dominio:** Extras que se suman al costo de un pedido

## Contexto

Al pagar, el cliente de MercaSENA puede agregar extras a su pedido: **empaque de regalo**, **envío prioritario**, **seguro de envío** y **cupón de descuento**. Los extras se pueden combinar en cualquier orden. Con herencia harían falta decenas de subclases, así que se usa **Decorator**: cada extra envuelve al anterior y ajusta el costo y la descripción.

Clases principales:

- `CostoPedido`: componente.
- `PedidoBase`: componente concreto.
- `DecoradorCosto`: decorador abstracto. Sus decoradores concretos son `EmpaqueRegalo`, `EnvioPrioritario`, `SeguroEnvio` y `DescuentoCupon`.

## Reglas de negocio

1. **Empaque de regalo:** suma $5.000.
2. **Envío prioritario:** suma $8.000.
3. **Seguro de envío:** suma el **2 %** del costo acumulado hasta ese momento, es decir, del costo del objeto que envuelve.
4. **Cupón:** resta el **10 %** del costo acumulado, con un **tope de $20.000** de descuento.
5. **Todos los valores se manejan en pesos enteros:** cada porcentaje se redondea a 0 decimales (*half up*) en el momento de calcularlo.
6. Cada decorador agrega su texto a la descripción, por ejemplo `Pedido + empaque de regalo + envío prioritario`.

## Tu misión

Este proyecto implementa el patrón **Decorator** dentro de la tienda en línea **MercaSENA**. El código *compila*, pero tiene **errores sembrados**: algunos los detectan las pruebas que ya existen y otros **no**. Tu trabajo es encontrarlos todos, demostrarlos con pruebas y corregirlos con ayuda de la IA, sin perder el control técnico.

> La fuente de verdad son las **reglas de negocio** de este README. La IA no las conoce si no se las das.

## Protocolo de trabajo (obligatorio)

1. **Prepara el repositorio.** Crea un repositorio en GitHub con este proyecto y haz el primer commit sin cambios: `git commit -m "chore: estado inicial"`.
2. **Predice sin IA (20 min).** Lee este README y el código. Escribe tus hipótesis en `BITACORA_IA.md`, sección 1.
3. **Ejecuta las pruebas.** Corre `mvn test` o las pruebas desde IntelliJ / Eclipse. Anota cuáles fallan.
4. **Demuestra cada error con una prueba.** Por cada error que encuentres, incluidos los que las pruebas actuales no detectan, escribe primero una prueba que **falle**. Haz commit: `test: demuestra <error>`.
5. **Consulta al jurado de IAs.** Envía el mismo prompt a ChatGPT, Gemini y DeepSeek. Usa el prompt de 5 piezas: contexto, tarea, restricciones, formato y criterio de verificación. Registra en la bitácora en qué coincidieron y en qué no.
6. **Corrige.** Aplica la corrección que **tú** entiendes y puedes explicar. La prueba debe pasar. Haz commit: `fix: corrige <error>`.
7. **Refactoriza con IA.** Pide a la IA una mejora de legibilidad que no cambie el comportamiento. Todas las pruebas deben seguir en verde. Haz commit: `refactor: ...`.
8. **Revisa la seguridad.** Pregúntate qué podría hacer un usuario malicioso con este código y anota tu respuesta en la bitácora.
9. **Prepara la defensa.** El instructor te pedirá explicar, **sin IA**, cualquier línea que hayas cambiado.

## Cómo ejecutar

```bash
mvn test
```

Requisitos: JDK 17 o superior y Maven 3.9 o superior, o el Maven que trae IntelliJ IDEA o Eclipse.

## Qué NO hacer

- No borres ni debilites pruebas para que pasen.
- No pegues el proyecto completo en una IA sin explicarle las reglas de negocio.
- No aceptes una corrección que no sabes explicar.

## Referencia del patrón

- https://refactoring.guru/es/design-patterns/decorator
