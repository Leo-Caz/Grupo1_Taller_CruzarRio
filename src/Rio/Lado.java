package Rio;

public enum Lado {
    IZQUIERDA,
    DERECHA;

    public Lado opuesto() {
        return this == IZQUIERDA ? DERECHA : IZQUIERDA;
    }
}
