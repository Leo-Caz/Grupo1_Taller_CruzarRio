public class Uva {
    private final String color;
    private boolean fresca;

    public Uva(String color) {
        this.color = color;
        this.fresca = true;
    }

    public String getColor() {
        return color;
    }

    public boolean estaFresca() {
        return fresca;
    }

    public void serComida() {
        this.fresca = false;
    }

    @Override
    public String toString() {
        return "Uvas " + color + (fresca ? " frescas" : " comidas");
    }
}
