import java.util.HashMap;
import java.util.Map;

public class ControladorRio {
    private final Vikingo vikingo = new Vikingo(true);
    private final Caperucita caperucita = new Caperucita(true);
    private final Lobo lobo = new Lobo();
    private final Uva uva = new Uva("moradas");
    private final Barca barca = new Barca();
    private final Map<SerVivo, Lado> ubicaciones = new HashMap<>();
    private Lado ladoUvas = Lado.IZQUIERDA;

    public ControladorRio() {
        ubicaciones.put(vikingo, Lado.IZQUIERDA);
        ubicaciones.put(caperucita, Lado.IZQUIERDA);
        ubicaciones.put(lobo, Lado.IZQUIERDA);
    }

    public void iniciarSimulacion() {
        System.out.println("Acertijo: cruzar el rio con el vikingo, el lobo, Caperucita y las uvas.");
        mostrarEstado();
        cruzarCon(caperucita);
        regresarSolo();
        cruzarCon(lobo);
        cruzarCon(caperucita);
        cruzarConUvas();
        regresarSolo();
        cruzarCon(caperucita);
        System.out.println("Listo. Todos llegaron sanos y salvos.");
    }

    private void cruzarCon(SerVivo acompanante) {
        Lado destino = ubicaciones.get(vikingo).opuesto();
        barca.cruzar(vikingo, acompanante, destino);
        mover(vikingo, destino);
        if (acompanante != null) {
            mover(acompanante, destino);
        }
        validarReglas();
        mostrarEstado();
    }

    private void cruzarConUvas() {
        Lado destino = ubicaciones.get(vikingo).opuesto();
        barca.cruzar(vikingo, uva, destino);
        mover(vikingo, destino);
        moverUvas(destino);
        validarReglas();
        mostrarEstado();
    }

    private void regresarSolo() {
        Lado destino = ubicaciones.get(vikingo).opuesto();
        barca.cruzar(vikingo, null, destino);
        mover(vikingo, destino);
        validarReglas();
        mostrarEstado();
    }

    private void mover(SerVivo ser, Lado destino) {
        ubicaciones.put(ser, destino);
    }

    private void moverUvas(Lado destino) {
        ladoUvas = destino;
    }

    private void validarReglas() {
        Lado ladoVikingo = ubicaciones.get(vikingo);
        Lado ladoCaperucita = ubicaciones.get(caperucita);
        Lado ladoLobo = ubicaciones.get(lobo);

        if (ladoCaperucita == ladoLobo && ladoVikingo != ladoCaperucita) {
            lobo.comer(caperucita);
            throw new IllegalStateException("El lobo se comio a Caperucita. Solucion invalida.");
        }

        if (ladoCaperucita == ladoUvas && ladoVikingo != ladoCaperucita && uva.estaFresca()) {
            caperucita.comer(uva);
            throw new IllegalStateException("Caperucita se comio las uvas. Solucion invalida.");
        }
    }

    private void mostrarEstado() {
        String izquierda = elementosEn(Lado.IZQUIERDA);
        String derecha = elementosEn(Lado.DERECHA);
        System.out.println("Margen izquierdo: " + izquierda);
        System.out.println("Margen derecho : " + derecha);
        System.out.println("Barca en la " + (barca.getLadoActual() == Lado.IZQUIERDA ? "izquierda" : "derecha"));
        System.out.println("--------------------------------------------------");
    }

    private String elementosEn(Lado lado) {
        StringBuilder sb = new StringBuilder();
        agregarSiEsta(sb, vikingo, lado);
        agregarSiEsta(sb, lobo, lado);
        agregarSiEsta(sb, caperucita, lado);
        if (ladoUvas == lado) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("Uvas");
        }
        if (sb.length() == 0) {
            sb.append("vacio");
        }
        return sb.toString();
    }

    private void agregarSiEsta(StringBuilder sb, SerVivo ser, Lado lado) {
        if (ubicaciones.get(ser) == lado) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(ser);
        }
    }
}
