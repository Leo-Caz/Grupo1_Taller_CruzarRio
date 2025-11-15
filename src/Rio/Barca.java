package Rio;

public class Barca {
    private boolean tieneDosPuestos = true;
    private boolean sentido = true; //Empieza en la izquierda true= izquierda
    private boolean seMovio = false;
    private final int rioLength = 30;

    private Vikingo vikingo;

    public Barca(Vikingo vikingo){
        this.vikingo = vikingo;
    }

    /**
     * Cruza el río llevando al vikingo y, opcionalmente, un pasajero.
     * @param vivo pasajero que sube con el vikingo (Lobo, Caperucita o Uva).
     *             Puede ser null si cruza solo.
     * @return true si se pudo cruzar.
     */

    public boolean cruzar(SerVivo vivo) {
        if (vivo != null && vivo.isIsIzquierda() != sentido) {
            return false;
        }
        animarCruce(vivo);
        tieneDosPuestos = (vivo != null);
        if (sentido) {            
            vikingo.irALaDerecha();
            if (vivo != null) {
                vivo.irALaDerecha();
            }
            sentido = false;
        } else {                      
            vikingo.irALaIzquierda();
            if (vivo != null) {
                vivo.irALaIzquierda();
            }
            sentido = true;
        }
        seMovio = true;
        tieneDosPuestos = false;  
        return true;
    }
    private void animarCruce(SerVivo pasajero) {
        String etiquetaBarca = "<_V_,";
        if (pasajero != null) {
            etiquetaBarca += "_" + pasajero.getNombre().charAt(0);
        }
        etiquetaBarca += "_>";
        if (sentido) {
            for (int i = 0; i <= rioLength; i++) {
                String izq = "_".repeat(i);
                String der = "_".repeat(rioLength - i);
                System.out.print("\r" + izq + etiquetaBarca + der);
                dormir(100);
            }
        } else {
            for (int i = 0; i <= rioLength; i++) {
                String izq = "_".repeat(rioLength - i);
                String der = "_".repeat(i);
                System.out.print("\r" + izq + etiquetaBarca + der);
                dormir(100);
            }
        }
        System.out.println();
    }

    private void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isTieneDosPuestos() {
        return tieneDosPuestos;
    }

    public void setTieneDosPuestos(boolean tieneDosPuestos) {
        this.tieneDosPuestos = tieneDosPuestos;
    }

    public boolean isSentido() {
        return sentido;
    }

    public void setSentido(boolean sentido) {
        this.sentido = sentido;
    }

    public boolean isSeMovio() {
        return seMovio;
    }

    public void setSeMovio(boolean seMovio) {
        this.seMovio = seMovio;
    }

    public Vikingo getVikingo() {
        return vikingo;
    }

    public void setVikingo(Vikingo vikingo) {
        this.vikingo = vikingo;
    }
}
