package Rio;

public abstract class Persona extends SerVivo {
    private final boolean boca;
    private final boolean brazos;

    protected Persona(String nombre,boolean boca, boolean brazos, boolean izq) {
        super(nombre,true);
        this.boca = boca;
        this.brazos = brazos;
    }

    public boolean tieneBoca() {
        return boca;
    }

    public boolean tieneBrazos() {
        return brazos;
    }
}
