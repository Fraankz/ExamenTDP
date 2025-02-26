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

package Grafo;

import java.util.*;

/**
 * Clase que representa un grafo y permite buscar caminos entre nodos.
 */
public class Camino<V> {
    final Map<V, Set<V>> listaAdyacencia;

    /**
     * Constructor que inicializa el grafo como una lista de adyacencia.
     */
    public Camino() {
        listaAdyacencia = new HashMap<>();
    }

    /**
     * Añade un vértice al grafo.
     * @param v Vértice a añadir.
     * @return true si el vértice se añadió, false si ya existía.
     */
    public boolean addVertex(V v) {
        if (!listaAdyacencia.containsKey(v)) {
            listaAdyacencia.put(v, new HashSet<>());
            return true;
        }
        return false;
    }

    /**
     * Añade un arco entre dos vértices.
     * @param v1 Vértice de origen.
     * @param v2 Vértice de destino.
     * @return true si el arco fue añadido, false si ya existía.
     */
    public boolean addEdge(V v1, V v2) {
        addVertex(v1);
        addVertex(v2);
        return listaAdyacencia.get(v1).add(v2) && listaAdyacencia.get(v2).add(v1);
    }

    /**
     * Obtiene los vértices adyacentes a un vértice dado.
     * @param v Vértice del que se obtendrán los adyacentes.
     * @return Conjunto de vértices adyacentes.
     */
    public Set<V> obtainAdjacents(V v) {
        return listaAdyacencia.getOrDefault(v, new HashSet<>());
    }

    /**
     * Comprueba si un vértice está en el grafo.
     * @param v Vértice a comprobar.
     * @return true si el vértice está en el grafo, false en caso contrario.
     */
    public boolean containsVertex(V v) {
        return listaAdyacencia.containsKey(v);
    }

    /**
     * Busca un camino entre dos vértices usando búsqueda en profundidad (DFS).
     * @param v1 Vértice de inicio.
     * @param v2 Vértice destino.
     * @return Lista con la secuencia de vértices desde v1 hasta v2, o null si no hay camino.
     */
    public List<V> onePath(V v1, V v2) {
        Stack<V> abierta = new Stack<>();
        Map<V, V> traza = new HashMap<>();
        abierta.push(v1);
        traza.put(v1, null);

        while (!abierta.isEmpty()) {
            V v = abierta.pop();
            if (v.equals(v2)) {
                return reconstruirCamino(traza, v1, v2);
            }
            for (V s : obtainAdjacents(v)) {
                if (!traza.containsKey(s)) {
                    abierta.push(s);
                    traza.put(s, v);
                }
            }
        }
        return null;
    }

    /**
     * Reconstruye el camino desde v1 hasta v2 usando la traza generada en DFS.
     * @param traza Mapa que almacena los padres de cada nodo en la búsqueda.
     * @param v1 Nodo de inicio.
     * @param v2 Nodo destino.
     * @return Lista con el camino desde v1 hasta v2.
     */
    private List<V> reconstruirCamino(Map<V, V> traza, V v1, V v2) {
        List<V> camino = new ArrayList<>();
        for (V actual = v2; actual != null; actual = traza.get(actual)) {
            camino.add(actual);
        }
        Collections.reverse(camino);
        return camino;
    }
}
