public abstract class Persona extends SerVivo {
    private final boolean boca;
    private final boolean brazos;

    protected Persona(boolean boca, boolean brazos) {
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
