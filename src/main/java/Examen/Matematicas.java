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

import java.util.Random;

/**
 * Clase que implementa el metodo de Montecarlo para calcular una aproximación del número PI.
 */
public class Matematicas {

    /**
     * Genera una aproximacion al número π utilizando el metodo de Montecarlo.
     * @param pasos Numero de puntos a generar.
     * @return Aproximacion del valor de π.
     */
    public static double generarNumeroPi(long pasos) {
        Random random = new Random();
        long aciertos = 0;

        for (long i = 0; i < pasos; i++) {
            double x = random.nextDouble() * 2 - 1; // Número aleatorio entre -1 y 1
            double y = random.nextDouble() * 2 - 1; // Número aleatorio entre -1 y 1

            // Si el punto (x, y) cae dentro del círculo, se cuenta como acierto
            if (x * x + y * y <= 1) {
                aciertos++;
            }
        }

        // Aproximación de π: (aciertos / total) * 4
        return 4.0 * aciertos / pasos;
    }
}
