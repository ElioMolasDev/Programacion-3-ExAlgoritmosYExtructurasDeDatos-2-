# Introducción a la Teoría de NP-Completitud

## Conceptos Fundamentales

### Problemas de Decisión

Un **problema de decisión** es un problema cuya respuesta es un valor booleano (verdadero o falso).

**Ejemplo de conversión a problema de decisión:**

*Problema original*: Sumar los elementos de un arreglo.

*Versión de decisión*:
- Entrada: Un arreglo A y un número real k ∈ R
- Salida: ¿Es cierto que la suma de los elementos de A es mayor o igual que k?

**Nota importante**: Utilizando búsqueda binaria sobre k, se puede convertir un algoritmo polinomial para el problema de decisión en un algoritmo polinomial para el problema original.

---

## Computadoras No Determinísticas

### Definición

Una **computadora no determinística** es una computadora que incluye una operación `guess(A)`, que genera una opción aleatoriamente seleccionada del conjunto A.

### Algoritmo No Determinístico

Un algoritmo no determinístico resuelve un problema de decisión si existe una secuencia de resultados de `guess()` que retorna `true` si y solo si la respuesta correcta es afirmativa.

**Características importantes:**
- No siempre tiene que dar la respuesta correcta
- Solo debe existir **una ejecución** que retorne `true` cuando la respuesta es afirmativa
- Si la respuesta correcta es `false`, entonces **siempre** debe retornar `false`

### Ejemplo: Camino Mínimo

```java
boolean caminoMinimo(Grafo grafo, int s, int t, double k) {
    Camino P := new Camino(grafo);
    int actual = s;
    
    while (actual != t) {
        P.add(actual);
        actual = guess(grafo.vecinos(actual));
    }
    
    return P.distancia() <= k;
}
```

---

## La Clase NP

### Definición

La clase **NP** está compuesta por los problemas que se pueden resolver en tiempo polinomial por un algoritmo no determinístico.

**Aclaraciones críticas:**
- Esto **NO** implica que un problema NP se pueda resolver en tiempo eficiente en una computadora normal
- Los algoritmos determinísticos también son no determinísticos, con lo cual los problemas polinomiales están en NP
- Por lo tanto: **P ⊆ NP**

### Ejemplos de Problemas en NP

#### TSP (Traveling Salesman Problem)

```java
boolean tsp(Grafo grafo, double k) {
    Circuito C := new Circuito(grafo);
    ArrayList<Integer> todos = grafo.vertices();
    
    while (!todos.vacio()) {
        int prox = guess(todos);
        todos.remove(prox);
        C.add(prox);
    }
    
    return C.distancia() <= k;
}
```

#### Sudoku

```java
boolean sudoku(Matriz matriz) {
    for(int i=0; i<matriz.filas(); ++i)
        for(int j=0; j<matriz.columnas(); ++j) 
            if(matriz.libre(i,j)) {
                int valor = guess({1,...,9});
                matriz.set(i, j, valor);
            }
    
    return matriz.valida();
}
```

#### Otros Problemas en NP

Las versiones de decisión de:
1. Buscar un elemento en un arreglo
2. Determinar si un arreglo está ordenado
3. Elemento máximo de un arreglo
4. Determinar si un grafo es conexo
5. Camino mínimo entre dos ciudades
6. Camino máximo entre dos ciudades
7. Árbol generador mínimo
8. Flujo máximo
9. Clique máxima

**Nota**: Algunos de estos problemas se pueden resolver con algoritmos polinomiales (están en P).

---

## Transformaciones y Reducciones

### Transformación Polinomial

Sean A y B dos problemas de decisión.

Una **transformación** de A en B es un programa `p` que toma un input `I` para A y lo convierte en un input `p(I) = I'` para B, de modo tal que:

```
A(I) = true  ⟺  B(I') = true
```

Si `p` es un algoritmo polinomial en el tamaño de I, decimos que es una **transformación polinomial**.

### Notación de Reducción

Si existe una transformación polinomial de A en B, escribimos:

```
A ≤P B
```

**Interpretación**: B es igual o más difícil que A, dado que se puede usar un algoritmo que resuelve B para resolver A:

1. Dado el input I, calcular I' = p(I)
2. Aplicar el algoritmo b sobre I' y retornar b(I')

---

## Problemas NP-Completos

### Definición

Un problema B ∈ NP es **NP-completo** si A ≤P B para todo otro problema A ∈ NP.

Los problemas NP-completos son los **problemas más difíciles** dentro de NP según la relación de dificultad ≤P.

### Estructura de la Clase NP

```
┌─────────────────────────────────┐
│            NP                   │
│  ┌──────────────────────────┐  │
│  │         P                │  │
│  │   (Problemas            │  │
│  │    Polinomiales)        │  │
│  └──────────────────────────┘  │
│                                 │
│  ┌──────────────────────────┐  │
│  │   NP-Completos           │  │
│  │   (Problemas más         │  │
│  │    difíciles)            │  │
│  └──────────────────────────┘  │
└─────────────────────────────────┘
```

### Propiedades Importantes

- No se conocen algoritmos polinomiales para resolver problemas NP-completos
- Si existe un algoritmo polinomial para **algún** problema NP-completo, entonces **todos** los problemas en NP son polinomiales (P = NP)
- Si se prueba que no existe algoritmo polinomial para **algún** problema NP-completo, entonces P ≠ NP

---

## Teorema de Cook-Levin

### El Problema SAT

**Satisfactibilidad (SAT)**:
- Entrada: Una fórmula proposicional f
- Salida: ¿Existe una asignación de valores de verdad a las proposiciones de f que hace que f sea verdadera?

### Teorema Fundamental

**Teorema (Cook, 1971 – Levin, 1973)**: SAT es NP-completo.

Este fue el **primer** problema probado como NP-completo, y estableció el punto de partida para demostrar que otros problemas son NP-completos.

### Historia

- **1972**: Richard Karp demostró que otros 21 problemas son NP-completos
- **Actualidad**: Se conocen más de 3,000 problemas NP-completos

---

## Cómo Demostrar que un Problema es NP-Completo

Para demostrar que un problema B es NP-completo:

1. **Verificar que B ∈ NP** (generalmente fácil)
2. **Encontrar una transformación polinomial** desde un problema NP-completo conocido C hacia B

Si C ≤P B y C es NP-completo, entonces para todo problema A ∈ NP:

```
A ≤P C ≤P B
```

Por lo tanto, B es NP-completo.

### Ejemplo: TSP ≤P VRP

**Problema del Ruteo de Vehículos (VRP)**:
- Entrada: n clientes con matriz de distancias A ∈ R^(n×n), cantidad ci a entregar en cada cliente, m camiones con capacidad C, número real k
- Salida: ¿Existe un conjunto de m rutas que pase por todos los clientes, respetando capacidades, con distancia total ≤ k?

**Transformación desde TSP:**

Dada una instancia del TSP (matriz A, número k), construimos la instancia del VRP:
- Matriz de distancias: misma A
- Cantidad de camiones: m = 1
- Capacidad de cada cliente: ci = 1
- Capacidad del camión: C = n
- Número k: el mismo

La instancia del TSP tiene solución ⟺ La instancia del VRP tiene solución.

Por lo tanto, **VRP es NP-completo**.

---

## Ejemplo: 3-SAT ≤P MIS

### 3-SAT

**Problema**:
- Entrada: Una fórmula proposicional con a lo sumo tres proposiciones por cláusula
- Salida: ¿Existe una valuación que haga verdadera a la fórmula?

Ejemplo: `(¬x ∨ y ∨ ¬z) ∧ (x ∨ ¬y ∨ z) ∧ (x ∨ y ∨ z) ∧ (¬x ∨ ¬y)`

### Conjunto Independiente Máximo (MIS)

Un **conjunto independiente** en un grafo es un conjunto de vértices que no son vecinos entre sí.

**Problema MIS**:
- Entrada: Un grafo G y un número k ∈ Z+
- Salida: ¿Existe un conjunto independiente en G de tamaño k o mayor?

### Transformación

1. Para cada cláusula, crear un triángulo (o par/triple) de vértices, uno por cada literal
2. Conectar literales contradictorios (x y ¬x) entre diferentes cláusulas
3. Si la fórmula tiene c cláusulas, fijar k = c

**Teorema**: La fórmula es satisfactible ⟺ El grafo tiene un conjunto independiente de tamaño k o superior.

Por lo tanto, **MIS es NP-completo**.

---

## Ejemplos de Problemas NP-Completos

1. **Clique máxima** en grafos
2. **Problema del viajante de comercio** (TSP)
3. **Problema de la mochila** (Knapsack)
4. **Problema de ruteo de vehículos** (VRP)
5. **Set partition**
6. **Programación de máquinas homogéneas**
7. **Sudoku**
8. **Tetris**
9. **SAT**: Determinar si una fórmula proposicional es satisfactible
10. **Coloreo de grafos**
11. **Muchos más...** (más de 3,000 conocidos)

---

## La Conjetura P vs. NP

### Los Dos Escenarios Posibles

**Escenario 1: P = NP**
- Todos los problemas en NP se pueden resolver en tiempo polinomial
- Implicaciones revolucionarias para criptografía, optimización, biología, etc.
- Consecuencias negativas: sistemas criptográficos actuales quedarían obsoletos

**Escenario 2: P ≠ NP**
- Los problemas NP-completos son intrínsecamente difíciles
- No existe algoritmo polinomial para ellos
- La investigación debe enfocarse en soluciones aproximadas y casos especiales

### Importancia

- Es uno de los **problemas del milenio** con premio de U$S 1,000,000
- Uno de los problemas abiertos más importantes de la computación
- La mayoría de los expertos cree que P ≠ NP

---

## ¿Qué Hacer con un Problema NP-Completo?

Dado un problema de decisión, tenemos tres posibilidades:

1. **Existe un algoritmo polinomial** (se demuestra encontrándolo)
2. **Es NP-completo** (se demuestra por transformación polinomial)
3. **Es un problema abierto**

### Estrategias Prácticas

Si necesitas resolver un problema NP-completo:

1. **Analizar el tamaño de las instancias**: Si son pequeñas, fuerza bruta o backtracking pueden ser viables

2. **Reducir a problemas conocidos**: Transformar a problemas NP-completos con solvers eficientes (SAT, programación lineal entera)

3. **Buscar casos particulares polinomiales**: Muchos problemas NP-completos tienen restricciones del input que los hacen polinomiales

4. **Diseñar heurísticas ad hoc**: Aprovechar la estructura particular del problema

5. **Usar metaheurísticas**: Algoritmos genéticos, algoritmos evolutivos, simulated annealing, etc.

---

## Algoritmos Exactos vs. Heurísticas

| Aspecto | Algoritmos Exactos | Algoritmos Heurísticos |
|---------|-------------------|----------------------|
| **Calidad de la solución** | Óptima (garantizada) | Buena (no garantizada) |
| **Complejidad** | Exponencial (impracticable) | Polinomial (practicable) |
| **Garantía** | Siempre encuentra el óptimo | Puede dar soluciones subóptimas |

### Pregunta Fundamental

¿Podemos tener en un mismo algoritmo una buena complejidad **y** una buena calidad de solución garantizada?

**Respuesta**: ¡**NO**! A menos que P = NP.

### Estrategia Realista

- Podemos tener **algoritmos exactos con tiempos razonables** para instancias específicas
- O bien **heurísticas con la mejor calidad de solución posible** sin garantías formales

---

## Perspectiva Histórica y Práctica

### De "Computers and Intractability" (Garey & Johnson, 1979)

Cuando te enfrentas a un problema difícil en la práctica:

1. **No es tu culpa** si no encuentras un algoritmo eficiente - puede ser NP-completo
2. **No tiene sentido** contratar a otro experto - el problema es inherentemente difícil
3. **La teoría de NP-completitud** te permite:
   - Dirigir esfuerzos hacia enfoques prometedores
   - Resolver casos especiales eficientemente
   - Diseñar algoritmos que funcionen bien en la práctica (sin garantías teóricas)
   - Relajar el problema para encontrar soluciones aproximadas

### Realidad Actual

Con el paso de los años, se probó que la **gran mayoría** de problemas interesantes en NP son NP-completos. Quedan muy pocos problemas abiertos (como la factorización en primos).

---

## Conclusiones

La teoría de NP-completitud:

- **Clasifica** la dificultad de los problemas computacionales
- **Explica** por qué ciertos problemas parecen imposibles de resolver eficientemente
- **Guía** la investigación hacia enfoques prácticos y realistas
- **Unifica** miles de problemas bajo un marco teórico común
- **Plantea** una de las preguntas más fundamentales de las ciencias de la computación

Entender NP-completitud es esencial para cualquier profesional de la computación, ya que permite reconocer cuándo un problema es inherentemente difícil y tomar decisiones informadas sobre cómo abordarlo.

---

*Material basado en las clases de Programación III - UNGS*
