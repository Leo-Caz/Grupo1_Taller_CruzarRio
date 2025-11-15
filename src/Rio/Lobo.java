package Rio;

public class Lobo extends SerVivo {
    private final boolean patas;
    private final boolean dientes;
    private final boolean ojos;

    public Lobo() {
        this.patas = true;
        this.dientes = true;
        this.ojos = true;
    }

    public boolean tienePatas() {
        return patas;
    }

    public boolean tieneDientes() {
        return dientes;
    }

    public boolean tieneOjos() {
        return ojos;
    }

    public void comer(Caperucita caperucita) {
        if (caperucita != null && caperucita.estaVivo()) {
            caperucita.setVivo(false);
            System.out.println("El lobo se comio a Caperucita.");
        }
    }

    public void comer(Uva uva) {
        if (uva != null && uva.estaFresca()) {
            uva.serComida();
            System.out.println("El lobo se comio unas uvas.");
        }
    }

    @Override
    public void comer() {
        System.out.println("El lobo devora cualquier cosa que pueda.");
    }

    @Override
    public String toString() {
        return "Lobo";
    }
}
