package Examen;

import Dominio.Tablero;
import Grafo.Camino;
import Matematicas.Matematicas;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal que ejecuta las prácticas: Aproximación de PI, Juego de la Vida y Búsqueda en un Grafo.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU DE PRACTICAS ---");
            System.out.println("1. Aproximación de PI (Método Montecarlo)");
            System.out.println("2. Juego de la Vida");
            System.out.println("3. Búsqueda de un camino en un Grafo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ejecutarAproximacionPi(scanner);
                    break;
                case 2:
                    ejecutarJuegoDeLaVida(scanner);
                    break;
                case 3:
                    ejecutarBusquedaEnGrafo(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void ejecutarAproximacionPi(Scanner scanner) {
        System.out.print("Ingrese el número de puntos para la simulación de Montecarlo: ");
        long pasos = scanner.nextLong();
        double piAproximado = Matematicas.generarNumeroPi(pasos);
        System.out.println("Aproximación de π con " + pasos + " puntos: " + piAproximado);
    }

    private static void ejecutarJuegoDeLaVida(Scanner scanner) {
        System.out.print("Ingrese el número de generaciones a simular: ");
        int generaciones = scanner.nextInt();
        Tablero tablero = new Tablero();
        tablero.generarEstadoInicial();
        for (int i = 1; i <= generaciones; i++) {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException ignored) {}
            tablero.transitarAlEstadoSiguiente();
            System.out.println("Generación " + i + ":\n" + tablero);
        }
    }

    private static void ejecutarBusquedaEnGrafo(Scanner scanner) {
        Camino<Integer> grafo = new Camino<>();
        grafo.addEdge(1, 2);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);
        grafo.addEdge(1, 5);
        grafo.addEdge(5, 6);
        grafo.addEdge(6, 4);

        System.out.print("Ingrese nodo de inicio: ");
        int inicio = scanner.nextInt();
        System.out.print("Ingrese nodo destino: ");
        int destino = scanner.nextInt();

        System.out.println("Buscando camino...");
        System.out.println("Camino encontrado: " + grafo.onePath(inicio, destino));
    }
}
