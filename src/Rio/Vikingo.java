package Rio;

public class Vikingo extends Persona {
    private final boolean casco;

    public Vikingo(boolean casco) {
        super(true, true);
        this.casco = casco;
    }

    public boolean tieneCasco() {
        return casco;
    }

    public boolean remar() {
        return tieneBrazos();
    }

    @Override
    public void comer() {
        System.out.println("El vikingo come un trozo de carne para recuperar fuerzas.");
    }

    @Override
    public String toString() {
        return "Vikingo";
    }
}
