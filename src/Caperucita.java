public class Caperucita extends Persona {
    private final boolean capa;

    public Caperucita(boolean capa) {
        super(true, true);
        this.capa = capa;
    }

    public boolean tieneCapa() {
        return capa;
    }

    public void comer(Uva uva) {
        if (uva == null) {
            return;
        }
        if (uva.estaFresca()) {
            uva.serComida();
            System.out.println("Caperucita no se pudo resistir y se comio las uvas.");
        }
    }

    @Override
    public void comer() {
        System.out.println("Caperucita disfruta un bocadillo.");
    }

    @Override
    public String toString() {
        return "Caperucita";
    }
}
