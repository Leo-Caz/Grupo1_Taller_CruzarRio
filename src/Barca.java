public class Barca {
    private static final int CAPACIDAD_MAXIMA = 2;
    private Lado ladoActual;
    private boolean tieneVikingo;

    public Barca() {
        this.ladoActual = Lado.IZQUIERDA;
    }

    public Lado getLadoActual() {
        return ladoActual;
    }

    public void cruzar(Vikingo vikingo, Object acompanante, Lado destino) {
        if (vikingo == null || !vikingo.remar()) {
            throw new IllegalStateException("La barca necesita al vikingo para remar.");
        }
        int pasajeros = acompanante == null ? 1 : 2;
        if (pasajeros > CAPACIDAD_MAXIMA) {
            throw new IllegalStateException("La barca se sobrecargaria.");
        }
        tieneVikingo = true;
        ladoActual = destino;
        if (acompanante == null) {
            System.out.println(vikingo + " cruza solo hacia la " + nombreLado(destino) + ".");
        } else {
            System.out.println(vikingo + " lleva a " + acompanante + " hacia la " + nombreLado(destino) + ".");
        }
    }

    public boolean tieneVikingo() {
        return tieneVikingo;
    }

    private String nombreLado(Lado lado) {
        return lado == Lado.IZQUIERDA ? "izquierda" : "derecha";
    }
}
