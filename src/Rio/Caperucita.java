package Rio;

public class Caperucita extends Persona {
    private final boolean capa;

    public Caperucita(boolean izq,boolean capa) {
        super("Caperucita",true, true,true);
        this.capa = capa;
    }

    public boolean tieneCapa() {
        return capa;
    }

    public void comer(Uva uva) {
        if (uva == null) {
            return;
        }
        System.out.println("Caperucita no se pudo resistir y se comio las uvas.");
    }
}
