package Rio;
import java.util.Scanner;

public class ControllerRio {
    private Vikingo vikingo;
    private Caperucita caperucita;
    private Lobo lobo;
    private Uva uva;
    private Barca barca;
    private final Scanner sc = new Scanner(System.in);

    public void iniciarMundo(){
        boolean jugarOtravez = true;
        while (jugarOtravez){
            vikingo    = new Vikingo(true,true);
            lobo       = new Lobo(true);
            caperucita = new Caperucita(true,true);
            uva        = new Uva(true);

            barca = new Barca(vikingo);
        
            boolean continuar = true;

            while (continuar) {
                mostrarEstado();
                SerVivo pasajero = pedirPasajero();
                boolean ok = barca.cruzar(pasajero);

                if (!ok) {
                    System.out.println("No puedes a ese pasajero (No estan en la misma orilla)");
                    continue;
                }

                continuar = validarReglas();
            }
                jugarOtravez = jugarDeNuevo();    
            }
        System.out.println("Gracias por jugar");
    }

    private void mostrarEstado(){
        System.out.println("\n");
        System.out.println("Orilla izquierda:");
        imprimirSiEstaAqui(vikingo, true);
        imprimirSiEstaAqui(lobo, true);
        imprimirSiEstaAqui(caperucita, true);
        imprimirSiEstaAqui(uva, true);
        System.out.println("\n");
        System.out.println("Orilla derecha:");
        imprimirSiEstaAqui(vikingo, false);
        imprimirSiEstaAqui(lobo, false);
        imprimirSiEstaAqui(caperucita, false);
        imprimirSiEstaAqui(uva, false);

        System.out.println("\n//Barca está en la " +
                (barca.isSentido() ? "izquierda//" : "derecha//"));
        System.out.println();
    }
    private void imprimirSiEstaAqui(SerVivo s, boolean izq) {
        if (s != null && s.isIsIzquierda() == izq) {
            System.out.println(" - " + s.getNombre());
        }
    }
    private SerVivo pedirPasajero() {
        System.out.println("¿Con quién cruza el vikingo?");
        System.out.println("0. Solo");
        System.out.println("1. Lobo");
        System.out.println("2. Caperucita");
        System.out.println("3. Uva");
        System.out.print("Opción: ");

        int opc = -1;
        do {
            try {
                opc = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opc = -1;
            }
            if (opc < 0 || opc > 3) {
                System.out.print("Ingrese una opción válida (0-3): ");
            }
        } while (opc < 0 || opc > 3);

        return switch (opc) {
            case 1 -> lobo;
            case 2 -> caperucita;
            case 3 -> uva;
            default -> null;
        }; 
    }
    /**
     * Devuelve true si el juego continúa.
     * Devuelve false si alguien se comió a alguien o si ganó.
     */
    public boolean validarReglas() {
        boolean vikingoIzq    = vikingo.isIsIzquierda();
        boolean loboIzq       = lobo.isIsIzquierda();
        boolean caperIzq      = caperucita.isIsIzquierda();
        boolean uvaIzq        = uva.isIsIzquierda();

        if (loboIzq == caperIzq && loboIzq != vikingoIzq) {
            lobo.comer(caperucita);
            return false;
        }
        if (caperIzq == uvaIzq && caperIzq != vikingoIzq) {
            caperucita.comer(uva);
            return false;
        }
        if (!vikingoIzq && !loboIzq && !caperIzq && !uvaIzq) {
            System.out.println("¡Lo lograste, Felicidades!");
            return false;
        }
        return true;
    }
    private boolean jugarDeNuevo() {
        System.out.print("Responde 's' para sí o 'n' para no ");
        System.out.print("\n¿Quieres jugar de nuevo? (s/n): ");
        while (true) {
            String resp = sc.nextLine().trim().toLowerCase();
            if (resp.equals("s")) return true;
            if (resp.equals("n")) return false;
        }
    }
}
