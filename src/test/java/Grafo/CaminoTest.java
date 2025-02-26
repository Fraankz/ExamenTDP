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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

/**
 * Clase de pruebas unitarias para la clase Camino.
 */
public class CaminoTest {
    private Camino<Integer> grafo;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        grafo = new Camino<>();
        grafo.addEdge(1, 2);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);
        grafo.addEdge(1, 5);
        grafo.addEdge(5, 6);
        grafo.addEdge(6, 4);
    }

    /**
     * Prueba para verificar que se pueden agregar vértices.
     */
    @Test
    void testAddVertex() {
        assertTrue(grafo.addVertex(7), "El vértice 7 debería agregarse correctamente.");
        assertFalse(grafo.addVertex(1), "El vértice 1 ya existía en el grafo.");
    }

    /**
     * Prueba para verificar que se pueden agregar aristas.
     */
    @Test
    void testAddEdge() {
        assertTrue(grafo.addEdge(4, 7), "La arista (4,7) debería agregarse correctamente.");
        assertFalse(grafo.addEdge(1, 2), "La arista (1,2) ya existía en el grafo.");
    }

    /**
     * Prueba para verificar que se pueden obtener vértices adyacentes.
     */
    @Test
    void testObtainAdjacents() {
        assertEquals(2, grafo.obtainAdjacents(1).size(), "El vértice 1 debería tener dos adyacentes.");
    }

    /**
     * Prueba para verificar que el método containsVertex funciona correctamente.
     */
    @Test
    void testContainsVertex() {
        assertTrue(grafo.containsVertex(1), "El grafo debería contener el vértice 1.");
        assertFalse(grafo.containsVertex(99), "El grafo no debería contener el vértice 99.");
    }

    /**
     * Prueba para verificar que se encuentra un camino entre dos vértices conectados.
     */
    @Test
    void testOnePathFindsAPath() {
        List<Integer> expectedPath = List.of(1, 5, 6, 4);
        assertEquals(expectedPath, grafo.onePath(1, 4), "El camino encontrado no es el esperado.");
    }

    /**
     * Prueba para verificar que no se encuentra un camino entre nodos desconectados.
     */
    @Test
    void testOnePathNoPath() {
        assertNull(grafo.onePath(1, 99), "No debería encontrarse un camino entre 1 y 99.");
    }
}
