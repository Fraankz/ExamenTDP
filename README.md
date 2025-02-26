# Proyecto: Implementación de Algoritmos - Examen de Programación

## 📌 Descripción  
Este proyecto contiene la implementación de varios algoritmos en Java, organizados en distintas prácticas. Se incluyen:
- **Aproximación de PI** mediante el método de Montecarlo.
- **Juego de la Vida** de Conway.
- **Búsqueda de caminos en un Grafo** con DFS.

---

## 📂 Estructura del Proyecto  

Este proyecto sigue la estructura estándar de un proyecto **Maven** en **Java**.

```plaintext
Proyecto/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Examen/
│   │   │   │   ├── Main.java
│   │   │   ├── Dominio/
│   │   │   │   ├── Tablero.java
│   │   │   ├── Grafo/
│   │   │   │   ├── Camino.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── Grafo/
│   │   │   │   ├── CaminoTest.java
│── target/  (Generado por Maven)
│── pom.xml
│── README.md
│── .gitignore
```
src/main/java/ → Contiene las clases principales del proyecto.  
src/test/java/ → Contiene las pruebas unitarias con JUnit.  
target/ → Carpeta generada automáticamente por Maven tras compilar el proyecto.  
pom.xml → Archivo de configuración de Maven.  
README.md → Documentación del proyecto.  
.gitignore → Archivos y carpetas que no deben subirse al repositorio.    

## 🚀 Instalación y Ejecución  

### **1️⃣ Requisitos Previos**
- Java 17 o superior.
- Maven instalado (`mvn -version` para verificar).
- IntelliJ IDEA (opcional pero recomendado).

### **2️⃣ Clonar el Repositorio**
```sh
git clone <URL_DEL_REPOSITORIO>
cd Proyecto
```
## 📜 Documentación
La documentación generada con Javadoc se encuentra en:  

```sh
target/site/apidocs/index.html
```  
Para generarla manualmente, usa:  
```sh
mvn javadoc:javadoc
```

## 📊 Análisis de Complejidad de los Métodos    
🟢 **Matematicas.java**  
generarNumeroPi(long pasos)  
Descripción: Calcula una aproximación de π con Montecarlo.  
Complejidad: O(n) (itera n veces generando puntos aleatorios).    

🟢 **Tablero.java** (Juego de la Vida)  
transitarAlEstadoSiguiente()  
Descripción: Calcula la siguiente generación del tablero aplicando las reglas del Juego de la Vida.  
Complejidad: O(m × n) (donde m y n son las dimensiones del tablero).    

🟢 **Camino.java** (Grafo)  
addVertex(V v)  
Descripción: Añade un vértice al grafo si no existe.  
Complejidad: O(1) (uso de HashMap).    

addEdge(V v1, V v2)  
Descripción: Añade una arista entre dos vértices.  
Complejidad: O(1) (acceso y modificación de HashMap y HashSet).    

onePath(V v1, V v2)  
Descripción: Encuentra un camino entre dos nodos con DFS.  
Complejidad: O(V + E) (búsqueda en profundidad en un grafo con V vértices y E aristas).    

## ✅ **Pruebas Unitarias**
Las pruebas están implementadas con JUnit 5 y se ejecutan con:  
```ssh
mvn test
```
Ubicación de las pruebas:
```ssh
src/test/java/Grafo/CaminoTest.java
```
## 🔥 **Autor**
Frank David Quezada Ochoa    

## 📄 **Licencia**
Este proyecto está licenciado bajo la Apache License 2.0.
Más información en el archivo LICENSE.
