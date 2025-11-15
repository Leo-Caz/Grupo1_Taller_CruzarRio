package Rio;

public class Lobo extends SerVivo {
    private final boolean patas;
    private final boolean dientes;
    private final boolean osico;

    public Lobo(boolean izq){
        super("Lobo", true);
        this.patas = true;
        this.dientes = true;
        this.osico = true;
    }

    public boolean tienePatas() {
        return patas;
    }

    public boolean tieneDientes() {
        return dientes;
    }

    public boolean tieneOsico() {
        return osico;
    }

    public void comer(Caperucita caperucita) {
        if (caperucita != null && caperucita.estaVivo()) {
            caperucita.setVivo(false);
            System.out.println("El lobo se comio a Caperucita.");
        }
    }
}
