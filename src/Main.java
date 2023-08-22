import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] opciones = {"piedra", "papel", "tijera"};

        System.out.println("¡Bienvenido a Piedra, Papel o Tijera!");

        int victoriasUsuario = 0;
        int victoriasComputadora = 0;

        for (int turno = 1; turno <= 3; turno++) {
            System.out.println("\nTurno " + turno);
            System.out.println("Elige una opción: piedra, papel o tijera");
            String eleccionUsuario = scanner.nextLine().toLowerCase();

            if (!eleccionUsuario.equals("piedra") && !eleccionUsuario.equals("papel") && !eleccionUsuario.equals("tijera")) {
                System.out.println("Opción no válida. Debes elegir piedra, papel o tijera.");
                turno--;
                continue;
            }

            int indiceEleccionComputadora = random.nextInt(3);
            String eleccionComputadora = opciones[indiceEleccionComputadora];

            System.out.println("La computadora eligió: " + eleccionComputadora);
            System.out.println("Tú elegiste: " + eleccionUsuario);

            if (eleccionUsuario.equals(eleccionComputadora)) {
                System.out.println("¡Es un empate!");
            } else if ((eleccionUsuario.equals("piedra") && eleccionComputadora.equals("tijera")) ||
                    (eleccionUsuario.equals("papel") && eleccionComputadora.equals("piedra")) ||
                    (eleccionUsuario.equals("tijera") && eleccionComputadora.equals("papel"))) {
                System.out.println("¡Ganaste el turno!");
                victoriasUsuario++;
            } else {
                System.out.println("¡La computadora ganó el turno!");
                victoriasComputadora++;
            }
        }

        System.out.println("\nJuego terminado.");
        if (victoriasUsuario > victoriasComputadora) {
            System.out.println("¡Ganaste el juego con " + victoriasUsuario + " victorias!");
        } else if (victoriasComputadora > victoriasUsuario) {
            System.out.println("¡La computadora ganó el juego con " + victoriasComputadora + " victorias!");
        } else {
            System.out.println("El juego terminó en empate.");
        }
    }
}