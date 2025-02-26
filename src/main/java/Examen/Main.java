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

import java.util.Scanner;

/**
 * Clase principal que ejecuta la aproximación de PI mediante Montecarlo.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de puntos para la simulación de Montecarlo: ");
        long pasos = scanner.nextLong();

        double piAproximado = Matematicas.generarNumeroPi(pasos);

        System.out.println("Aproximación de π con " + pasos + " puntos: " + piAproximado);

        scanner.close();
    }
}
