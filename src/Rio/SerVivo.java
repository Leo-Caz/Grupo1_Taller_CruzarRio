package Rio;

public abstract class SerVivo {
    private boolean vivo = true;
    private String nombre;

    public boolean estaVivo() {
        return vivo;
    }

    protected void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
