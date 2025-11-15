package Rio;

public abstract class SerVivo {
    private boolean vivo = true;
    private boolean isIzquierda = true;
    private String nombre;

    public SerVivo(String nombre, boolean isIzquierda) {
        this.nombre = nombre;
        this.isIzquierda = isIzquierda;
    }

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

    public boolean isIsIzquierda() {
        return isIzquierda;
    }

    public void setIsIzquierda(boolean isIzquierda) {
        this.isIzquierda = isIzquierda;
    }

    public void irALaIzquierda() {
        isIzquierda = true;
    }

    public void irALaDerecha() {
        isIzquierda = false;
    }
}
