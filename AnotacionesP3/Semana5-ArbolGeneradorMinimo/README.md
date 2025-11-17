# Árbol Generador Mínimo (AGM)

## Conceptos Básicos

### Árboles
Un **árbol** es un grafo conexo sin circuitos.

**Propiedades equivalentes de un árbol G = (V, E):**
1. G es un árbol
2. G no tiene circuitos simples, pero agregar cualquier arista crea exactamente un circuito
3. Existe exactamente un camino simple entre todo par de vértices
4. G es conexo, pero eliminar cualquier arista lo desconecta

**Teoremas importantes:**
- Una **hoja** es un vértice de grado 1
- Todo árbol no trivial (≥2 vértices) tiene al menos dos hojas
- Si G es un árbol: |E| = |V| - 1

### Árbol Generador Mínimo
Dado un grafo G, un **árbol generador** es un subgrafo que:
- Es un árbol
- Tiene el mismo conjunto de vértices que G

La **longitud** de un árbol T se define como: l(T) = Σ l(e) para todas las aristas e en T

Un **AGM** es un árbol generador de mínima longitud entre todos los árboles generadores posibles.

**Aplicación práctica:** Diseño de redes eléctricas y de comunicación.

---

## Algoritmo de Prim

**Desarrollado por:** Jarník (1930), Prim (1957), Dijkstra (1959)

### Funcionamiento
```
1. Iniciar con un vértice cualquiera u
2. VT := {u}, ET := ∅
3. Mientras i ≤ n-1:
   - Elegir arista e = (u,v) de peso mínimo
     donde u ∈ VT y v ∉ VT
   - Agregar e a ET
   - Agregar v a VT
4. Retornar T = (VT, ET)
```

### Características
- Construye el árbol expandiendo desde un vértice inicial
- En cada paso, agrega la arista de menor peso que conecta el árbol actual con un vértice fuera de él
- **Correctitud garantizada:** El algoritmo siempre encuentra un AGM

---

## Algoritmo de Kruskal

**Desarrollado por:** Joseph Kruskal (1956)

### Funcionamiento
```
1. Ordenar todas las aristas por peso
2. ET := ∅
3. Mientras i ≤ n-1:
   - Elegir arista e de peso mínimo que no forme circuito
   - Agregar e a ET
4. Retornar T = (V, ET)
```

### Características
- Construye el árbol considerando las aristas en orden creciente de peso
- Agrega una arista solo si no crea un circuito
- Requiere detectar circuitos eficientemente

---

## Estructura Union-Find

**Desarrollado por:** Galler y Fischer (1964)

### Propósito
Optimizar el Algoritmo de Kruskal mediante detección eficiente de circuitos.

### Operaciones Básicas

**1. Estructura de datos:**
- Arreglo donde cada vértice apunta a su padre
- Forma árboles donde la raíz representa la componente conexa

**2. Operaciones fundamentales:**

```c
// Encontrar la raíz de un vértice
int root(int i) {
    while(A[i] != i)
        i = A[i];
    return i;
}

// Verificar si dos vértices están en la misma componente
boolean find(int i, int j) {
    return root(i) == root(j);
}

// Unir dos componentes
void union(int i, int j) {
    int ri = root(i);
    int rj = root(j);
    A[ri] = rj;
}
```

### Optimizaciones

**Union por tamaño:**
- Hacer que la raíz del árbol menor apunte a la del mayor
- Complejidad: O(log n)

**Técnicas de compactación:**
1. **Path compression:** Todos los nodos apuntan directamente a la raíz
2. **Path splitting:** Cada nodo apunta a su abuelo
3. **Path halving:** Path splitting aplicado a nodos alternados

### Complejidad
Con union por tamaño + compactación:
- **Tiempo amortizado:** O(α(n))
- α(n) es la inversa de la función de Ackermann
- **A efectos prácticos:** α(n) ≤ 5 (crece extremadamente lento)

---

## Comparación de Algoritmos

| Aspecto | Prim | Kruskal |
|---------|------|---------|
| Estrategia | Expansión desde un vértice | Ordenar aristas por peso |
| Mejor para | Grafos densos | Grafos dispersos |
| Requiere | Estructura de cola de prioridad | Union-Find para eficiencia |
| Complejidad | Depende de implementación | O(E log E) con Union-Find optimizado |

---

## Correctitud

**Teorema clave:** Si F es un subconjunto de aristas en un AGM y S es un conjunto de vértices de una componente conexa de F, entonces la arista de peso mínimo entre S y S̄ puede agregarse a F manteniendo la propiedad de AGM.

Este teorema fundamenta la correctitud de ambos algoritmos.
