package Rio;

public abstract class SerVivo {
    private boolean vivo = true;

    public boolean estaVivo() {
        return vivo;
    }

    protected void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public abstract void comer();
}
