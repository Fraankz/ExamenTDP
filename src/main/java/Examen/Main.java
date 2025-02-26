/*
 * Copyright 2025 Frank David Quezada Ochoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */

package Examen;

import Dominio.Tablero;
import Matematicas.Matematicas;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal que ejecuta tanto la Práctica 1 (Aproximación de PI) como la Práctica 2 (Juego de la Vida).
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU DE PRACTICAS ---");
            System.out.println("1. Aproximación de PI (Método Montecarlo)");
            System.out.println("2. Juego de la Vida");
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
                case 0:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Ejecuta la práctica 1: Aproximación de PI usando Montecarlo.
     */
    private static void ejecutarAproximacionPi(Scanner scanner) {
        System.out.print("Ingrese el número de puntos para la simulación de Montecarlo: ");
        long pasos = scanner.nextLong();

        double piAproximado = Matematicas.generarNumeroPi(pasos);

        System.out.println("Aproximación de π con " + pasos + " puntos: " + piAproximado);
    }

    /**
     * Ejecuta la práctica 2: Juego de la Vida.
     */
    private static void ejecutarJuegoDeLaVida(Scanner scanner) {
        System.out.print("Ingrese el número de generaciones a simular: ");
        int generaciones = scanner.nextInt();

        Tablero tablero = new Tablero();
        tablero.generarEstadoInicial();

        System.out.println("Estado Inicial:");
        System.out.println(tablero);

        for (int i = 1; i <= generaciones; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("Error en la pausa entre generaciones.");
            }

            tablero.transitarAlEstadoSiguiente();
            System.out.println("Generación " + i + ":");
            System.out.println(tablero);
        }
    }
}
