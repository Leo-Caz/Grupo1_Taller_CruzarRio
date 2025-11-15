package Rio;

public class Vikingo extends Persona {
    private final boolean casco;

    public Vikingo(boolean izq, boolean casco) {
        super("Vikingo", true, true, true);
        this.casco = casco;
    }

    public boolean tieneCasco() {
        return casco;
    }

    public boolean remar() {
        return tieneBrazos();
    }
}
