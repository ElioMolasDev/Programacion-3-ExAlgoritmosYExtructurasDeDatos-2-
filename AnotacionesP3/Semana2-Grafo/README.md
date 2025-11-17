# Introducción a la Teoría de Grafos

## Definiciones Básicas

### Grafo

**Definición:** Un grafo es un par G = (V, E) tal que:
1. **V** es un conjunto finito llamado el **conjunto de vértices** de G
2. **E ⊆ {ij ∈ V × V : i ≠ j}** es un conjunto de **aristas**

**Ejemplo:**
```
    1 ─── 3
    │     │ ╲
    2 ─── 4   6
          │   │ ╲
          5 ─ 7
```

V = {1, 2, 3, 4, 5, 6, 7}
E = {12, 13, 23, 24, 34, 36, 45, 47, 56, 57, 67}

### Propiedades de las Aristas

- El **orden de los extremos NO es importante**
- La arista 34 se puede denotar como: 34, 43 o {3, 4}
- No hay aristas de un vértice a sí mismo
- No hay aristas múltiples entre dos vértices

---

## Conceptos Fundamentales

### Vecinos y Vecindario

**Vecinos:** Si ij ∈ E, decimos que los vértices i y j son **vecinos** (o adyacentes).

**Vecindario:** Dado i ∈ V, el vecindario de i es:
```
N(i) = {j ∈ V : ij ∈ E}
```

**Ejemplo:** En el grafo anterior:
- N(1) = {2, 3}
- N(4) = {2, 3, 5, 7}

### Grado

**Definición:** El **grado** de un vértice i ∈ V es:
```
d(i) = |N(i)|
```

Es decir, la cantidad de vecinos que tiene el vértice.

**Ejemplo:**
- d(1) = 2
- d(4) = 4
- d(3) = 4

### Vértice Aislado

Un **vértice aislado** es un vértice i con d(i) = 0 (no tiene vecinos).

---

## Caminos y Distancias

### Camino

Un **camino** entre dos vértices i y j es una secuencia de aristas desde i hasta j.

**Ejemplo:** Camino de 1 a 7:
- 1 → 2 → 4 → 7
- 1 → 3 → 4 → 7
- 1 → 3 → 6 → 7

### Distancia

La **distancia** entre dos vértices es la cantidad de aristas del camino **más corto** entre ellos.

**Ejemplo:**
- dist(1, 7) = 3 (camino más corto: 1 → 2 → 4 → 7)
- dist(1, 3) = 1 (están conectados directamente)

---

## Conectividad

### Grafo Conexo

Un grafo es **conexo** si existe un camino entre **todo par de vértices**.

El grafo del ejemplo anterior es conexo.

### Componente Conexa

Una **componente conexa** es un subconjunto de vértices conexo, **maximal** con esta propiedad (no se puede agregar ningún otro vértice manteniendo la conexidad).

**Propiedades:**
1. Un grafo conexo tiene **exactamente una** componente conexa
2. Si i y j están en componentes conexas distintas, hay una **distancia infinita** entre ellos

**Ejemplo de grafo no conexo:**
```
    1 ─── 2       4 ─── 5
                  │
    3             6
```
- Componente 1: {1, 2}
- Componente 2: {3}
- Componente 3: {4, 5, 6}

---

## Motivación y Aplicaciones

Los grafos representan **relaciones simétricas** entre entidades:

### 1. Redes de Transporte
**Vértices:** Ciudades
**Aristas:** Rutas entre ciudades

### 2. Mapas Urbanos
**Vértices:** Esquinas
**Aristas:** Calles

### 3. Redes Sociales
**Vértices:** Personas
**Aristas:** Relaciones de amistad

### 4. Planificación Académica
**Vértices:** Cursos
**Aristas:** Dos cursos se solapan (tienen horarios conflictivos)

### 5. Redes de Telecomunicaciones
**Vértices:** Antenas celulares
**Aristas:** Áreas de cobertura superpuestas

---

## Representaciones de Grafos

### 1. Matriz de Adyacencia

**Definición:** La matriz de adyacencia de un grafo G es una matriz A = (aᵢⱼ) ∈ R^(|V|×|V|) tal que:
- aᵢⱼ = 1 si ij ∈ E
- aᵢⱼ = 0 en caso contrario

**Ejemplo:**
```
    1 ─ 2      A = ⎡0 1 1⎤
    │ ╲ │          ⎢1 0 1⎥
    3 ─ 4          ⎣1 1 0⎦
```

**Implementación en Java:**

```java
class Grafo {
    private int vertices;
    private boolean[][] adj;
    
    public Grafo(int n) {
        vertices = n;
        adj = new boolean[n][n];
    }
    
    public void agregarArista(int i, int j) {
        adj[i][j] = adj[j][i] = true;
    }
    
    public void eliminarArista(int i, int j) {
        adj[i][j] = adj[j][i] = false;
    }
    
    public boolean existeArista(int i, int j) {
        return adj[i][j];
    }
}
```

**Ventajas:** ✅
- Agregar una arista: **O(1)**
- Eliminar una arista: **O(1)**
- Consultar si existe arista: **O(1)**

**Desventajas:** ❌
- Agregar un vértice: **O(n²)**
- Eliminar un vértice: **O(n²)**
- Obtener todos los vecinos de un vértice: **O(n)**
- Espacio: **O(n²)** (ineficiente para grafos con pocas aristas)

---

### 2. Matriz de Incidencia

**Definición:** La matriz de incidencia de un grafo G es una matriz M = (mᵢⱼ) ∈ R^(|V|×|E|) tal que:
- mᵢₑ = 1 si el vértice i es uno de los extremos de la arista e
- mᵢₑ = 0 en caso contrario

**Ejemplo:**
```
E = {12, 13, 23, 24, 34, 36, 45, 47, 56, 57, 67}

M = ⎡1 1 0 0 0 0 0 0 0 0 0⎤
    ⎢1 0 1 1 0 0 0 0 0 0 0⎥
    ⎢0 1 1 0 1 1 0 0 0 0 0⎥
    ⎢0 0 0 1 1 0 1 1 0 0 0⎥
    ⎢0 0 0 0 0 0 1 0 1 1 0⎥
    ⎢0 0 0 0 0 1 0 0 1 0 1⎥
    ⎣0 0 0 0 0 0 0 1 0 1 1⎦
```

**Observación:** Esta representación **NO es conveniente** en la práctica:
- Requiere espacio O(|V| × |E|)
- Operaciones son menos eficientes
- Poco usada en implementaciones

---

### 3. Listas de Adyacencia (Recomendada)

**Idea:** Cada vértice tiene una lista (o conjunto) de sus vecinos.

**Representación visual:**
```
1 → {2, 3}
2 → {1, 3, 4}
3 → {1, 2, 4, 6}
4 → {2, 3, 5, 7}
5 → {4, 6, 7}
6 → {3, 5, 7}
7 → {4, 5, 6}
```

**Implementación en Java:**

```java
class Grafo {
    private ArrayList<HashSet<Integer>> vecinos;
    
    public Grafo(int n) {
        vecinos = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; ++i)
            vecinos.add(new HashSet<Integer>());
    }
    
    public void agregarArista(int i, int j) {
        vecinos.get(i).add(j);
        vecinos.get(j).add(i);
    }
    
    public void eliminarArista(int i, int j) {
        vecinos.get(i).remove(j);
        vecinos.get(j).remove(i);
    }
    
    public boolean existeArista(int i, int j) {
        return vecinos.get(i).contains(j);
    }
    
    public HashSet<Integer> obtenerVecinos(int i) {
        return vecinos.get(i);
    }
}
```

**Ventajas:** ✅
- Obtener todos los vecinos de un vértice: **O(1)**
- Agregar un vértice: **O(1) amortizado** (O(n) peor caso)
- Agregar una arista: **O(1) promedio**
- Eliminar una arista: **O(1) promedio**
- Consultar si existe arista: **O(1) promedio**
- Espacio: **O(|V| + |E|)** (eficiente para grafos dispersos)

**Desventajas:** ❌
- Eliminar un vértice: **O(n)**

**Nota sobre HashSet vs TreeSet:**
- **HashSet:** Operaciones O(1) promedio
- **TreeSet:** Operaciones O(log n) peor caso (pero garantizado)

---

## Comparación de Representaciones

| Operación | Matriz de Adyacencia | Listas de Adyacencia |
|-----------|---------------------|---------------------|
| **Agregar arista** | O(1) | O(1) promedio |
| **Eliminar arista** | O(1) | O(1) promedio |
| **¿Existe arista?** | O(1) | O(1) promedio |
| **Obtener vecinos** | O(n) | O(1) |
| **Agregar vértice** | O(n²) | O(1) amortizado |
| **Eliminar vértice** | O(n²) | O(n) |
| **Espacio** | O(n²) | O(n + m)* |

*donde n = |V| y m = |E|

### ¿Cuál usar?

**Matriz de Adyacencia:**
- Grafos **densos** (muchas aristas): m ≈ n²
- Consultas frecuentes de existencia de aristas
- Número fijo de vértices

**Listas de Adyacencia:** ⭐ (Recomendada en general)
- Grafos **dispersos** (pocas aristas): m << n²
- Necesidad de recorrer vecinos frecuentemente
- Número variable de vértices
- Eficiencia de espacio importante

---

## Grafos Dirigidos (Digrafos)

### Definición

Un **grafo dirigido** (o digrafo) es un par D = (N, A) tal que:
1. **N** es un conjunto finito (conjunto de **nodos**)
2. **A ⊆ {(i, j) ∈ V × V : i ≠ j}** es un conjunto de **pares ordenados** llamados **arcos**

**Diferencia clave:** Las aristas ahora son **pares ordenados** (tienen dirección).

**Ejemplo:**
```
    1 ──→ 3
    ↓     ↓ ╲
    2 ──→ 4  ↘ 6
          ↓     ↓
          5 ──→ 7
```

### Grados en Grafos Dirigidos

**Grado de entrada:**
```
d⁻(i) = |N⁻(i)| = |{j ∈ N : (j, i) ∈ A}|
```
Cantidad de arcos que **llegan** al nodo i.

**Grado de salida:**
```
d⁺(i) = |N⁺(i)| = |{j ∈ N : (i, j) ∈ A}|
```
Cantidad de arcos que **salen** del nodo i.

**Ejemplo:**
- d⁻(4) = 2 (llegan desde 2 y 3)
- d⁺(4) = 2 (salen hacia 5 y 6)

### Caminos en Grafos Dirigidos

Un **camino** entre dos nodos es una secuencia de arcos entre ellos, **respetando el sentido de los arcos**.

**Ejemplo:** En el grafo anterior:
- Existe camino de 1 a 7: 1 → 3 → 6 → 7
- **NO** existe camino de 7 a 1 (no se puede ir "hacia atrás")

---

## Implementación de Grafos Dirigidos

### Matriz de Adyacencia

```java
class GrafoDirigido {
    private boolean[][] adj;
    
    public void agregarArco(int origen, int destino) {
        adj[origen][destino] = true;  // Solo una dirección
    }
    
    public boolean existeArco(int origen, int destino) {
        return adj[origen][destino];
    }
}
```

**Nota:** La matriz **ya NO es simétrica**.

### Listas de Adyacencia

```java
class GrafoDirigido {
    private ArrayList<HashSet<Integer>> sucesores;
    
    public void agregarArco(int origen, int destino) {
        sucesores.get(origen).add(destino);  // Solo una dirección
    }
    
    public HashSet<Integer> obtenerSucesores(int nodo) {
        return sucesores.get(nodo);
    }
}
```

**Variante:** Se pueden mantener también listas de **predecesores** para acceso eficiente:
```java
private ArrayList<HashSet<Integer>> sucesores;
private ArrayList<HashSet<Integer>> predecesores;
```

---

## Terminología: Grafos vs. Digrafos

| Concepto | Grafos (No Dirigidos) | Digrafos (Dirigidos) |
|----------|----------------------|---------------------|
| **Elementos** | Vértices | Nodos |
| **Conexiones** | Aristas | Arcos |
| **Relación** | Simétrica | Asimétrica |
| **Notación** | {i, j} o ij | (i, j) |
| **Grado** | d(i) | d⁻(i) y d⁺(i) |

---

## Conceptos Importantes

### Grafos Dispersos vs. Densos

**Grafo disperso:** Pocas aristas (m << n²)
- Ejemplo: m = O(n)
- Representación ideal: Listas de adyacencia

**Grafo denso:** Muchas aristas (m ≈ n²)
- Ejemplo: m = Θ(n²)
- Representación aceptable: Matriz de adyacencia

### Grafo Completo

Un grafo donde **todos** los pares de vértices están conectados.
- Cantidad de aristas: m = n(n-1)/2
- Es el grafo más denso posible

---

## Aplicaciones Clásicas

### Problemas sobre Grafos

1. **Camino más corto** (Shortest Path)
   - Entre dos vértices específicos
   - Desde un vértice a todos los demás (Dijkstra, Bellman-Ford)

2. **Componentes conexas**
   - Identificar grupos de vértices conectados
   - DFS, BFS, Union-Find

3. **Árbol generador mínimo** (Minimum Spanning Tree)
   - Kruskal, Prim

4. **Coloreo de grafos**
   - Asignación de horarios
   - Coloreo de mapas

5. **Flujo máximo**
   - Redes de transporte
   - Matching bipartito

6. **Clique máxima**
   - Encontrar el subgrafo completo más grande

7. **Recorridos**
   - DFS (Depth-First Search)
   - BFS (Breadth-First Search)

---

## Algoritmos Fundamentales (Vista Previa)

Estos algoritmos se estudian en detalle en temas posteriores:

### DFS (Depth-First Search)
- Recorrido en profundidad
- Usa pila (recursión)
- Complejidad: O(n + m)

### BFS (Breadth-First Search)
- Recorrido en amplitud
- Usa cola
- Complejidad: O(n + m)
- Encuentra caminos más cortos (sin pesos)

### Dijkstra
- Camino más corto con pesos no negativos
- Complejidad: O((n + m) log n) con heap

### Kruskal / Prim
- Árbol generador mínimo
- Complejidad: O(m log n)

---

## Conclusiones

La teoría de grafos es fundamental en ciencias de la computación porque:

- ✅ **Modela relaciones** entre objetos naturalmente
- ✅ **Resuelve problemas reales** en redes, planificación, optimización
- ✅ **Proporciona algoritmos eficientes** para muchos problemas prácticos
- ✅ **Es base de estructuras de datos** avanzadas

**Claves para trabajar con grafos:**
1. Elegir la **representación adecuada** según el problema
2. Conocer las **complejidades** de las operaciones
3. Aplicar los **algoritmos apropiados** para cada tarea
4. Considerar si el grafo es **dirigido o no dirigido**

---

*Material basado en las clases de Programación III - UNGS*
