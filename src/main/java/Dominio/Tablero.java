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

package Dominio;

import java.util.Random;

/**
 * Representa el tablero del Juego de la Vida.
 */
public class Tablero {
    private static final int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente;

    /**
     * Constructor: Inicializa los tableros.
     */
    public Tablero() {
        estadoActual = new int[DIMENSION][DIMENSION];
        estadoSiguiente = new int[DIMENSION][DIMENSION];
    }

    /**
     * Genera un estado inicial aleatorio para el tablero.
     */
    public void generarEstadoInicial() {
        Random rand = new Random();
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = rand.nextDouble() < 0.5 ? 1 : 0;
            }
        }
    }

    /**
     * Aplica las reglas del Juego de la Vida y transita al siguiente estado.
     */
    public void transitarAlEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                int vecinosVivos = contarVecinosVivos(i, j);

                if (estadoActual[i][j] == 1) {
                    estadoSiguiente[i][j] = (vecinosVivos == 2 || vecinosVivos == 3) ? 1 : 0;
                } else {
                    estadoSiguiente[i][j] = (vecinosVivos == 3) ? 1 : 0;
                }
            }
        }

        // Intercambia los tableros
        int[][] temp = estadoActual;
        estadoActual = estadoSiguiente;
        estadoSiguiente = temp;
    }

    /**
     * Cuenta el número de vecinos vivos alrededor de una celda.
     * @param fila Fila de la celda.
     * @param columna Columna de la celda.
     * @return Número de vecinos vivos.
     */
    private int contarVecinosVivos(int fila, int columna) {
        int[] direcciones = {-1, 0, 1};
        int vecinosVivos = 0;

        for (int dx : direcciones) {
            for (int dy : direcciones) {
                if (dx == 0 && dy == 0) continue;

                int nuevaFila = fila + dx;
                int nuevaColumna = columna + dy;

                if (nuevaFila >= 0 && nuevaFila < DIMENSION && nuevaColumna >= 0 && nuevaColumna < DIMENSION) {
                    vecinosVivos += estadoActual[nuevaFila][nuevaColumna];
                }
            }
        }

        return vecinosVivos;
    }

    /**
     * Devuelve una representación en texto del tablero.
     * @return String con el estado actual del tablero.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] fila : estadoActual) {
            for (int celda : fila) {
                sb.append(celda == 1 ? "⬛" : "⬜");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
