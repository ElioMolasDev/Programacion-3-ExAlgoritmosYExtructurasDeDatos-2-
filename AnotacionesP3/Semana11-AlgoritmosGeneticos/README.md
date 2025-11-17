# Algoritmos Genéticos

## Contexto: Algoritmos Exactos vs. Heurísticas

Dado un problema NP-completo, tenemos dos alternativas principales:

| Aspecto | Algoritmos Exactos | Algoritmos Heurísticos |
|---------|-------------------|----------------------|
| **Calidad de la solución** | "Buena" (óptima) | "Mala" (aproximada) |
| **Complejidad** | "Mala" (exponencial) | "Buena" (polinomial) |

### Pregunta Fundamental

¿Podemos tener en un mismo algoritmo una buena complejidad **Y** una buena calidad de solución?

**Respuesta**: ¡**NO**! A menos que P = NP.

### Estrategias Realistas

1. **Algoritmos exactos con tiempos razonables** para instancias específicas
2. **Heurísticas con la mejor calidad de solución posible** (sin garantías)

Los algoritmos genéticos se encuadran en el **segundo grupo**.

---

## ¿Qué son los Algoritmos Genéticos?

### Definición

Los **algoritmos genéticos** son una técnica de optimización heurística inspirada en la teoría de evolución de las especies con selección natural (bio-inspired computing).

### Características Principales

1. ✅ **Son algoritmos heurísticos**: No garantizan la solución exacta
2. ✅ **Son algoritmos eficientes**: Tienen complejidad polinomial
3. 🧬 **Inspirados en la naturaleza**: Simulan evolución biológica

### Idea Central

Un algoritmo genético simula una **población de individuos** (soluciones candidatas para el problema) que va **evolucionando** hasta encontrar una buena solución mediante:
- Mutación
- Recombinación (crossover)
- Selección natural

---

## Conceptos Fundamentales

### 1. Individuo o Cromosoma

Una **solución candidata** representada como una secuencia de bits.

**Ejemplo para el problema de la mochila con n objetos:**
```
0001010110101001010
```
- Cada bit representa si un objeto está incluido (1) o no (0)
- Posición i = 1 → objeto i está en la mochila
- Posición i = 0 → objeto i NO está en la mochila

### 2. Gen

Una **parte específica** de un cromosoma que codifica un atributo particular de la solución.

**Ejemplo para el problema del círculo más grande:**
```
0110101101  0110101101  0101101010
    ↓           ↓           ↓
   x(k bits)   y(k bits)   r(k bits)
```

### 3. Población

Un **conjunto de individuos** (soluciones candidatas) que evolucionan juntos.

Parámetro típico: **m = 1000 individuos**

### 4. Función de Fitness

Una **función que evalúa la calidad** de un individuo (solución).

**Ejemplos:**
- **Problema de la mochila**: Beneficio total (penalizando si excede capacidad)
- **Círculo más grande**: Área del círculo - cantidad de círculos que interseca

---

## Operadores Genéticos

### 1. Mutación

Modificación aleatoria de algunos bits en un individuo.

**Ejemplo:**
```
Antes:  011010110101101011010101101010
Después: 011010110101101111010101101010
                        ↑
                    bit mutado
```

**Parámetro**: Tasa de mutación **tₘ** (probabilidad de mutar un individuo)
- Valor típico: **tₘ = 0.001** (0.1%)

### 2. Recombinación (Crossover)

Combinación de dos individuos padres para generar dos individuos hijos.

**Ejemplo (crossover de un punto):**
```
Padre 1:  011010110101101011010101101010
Padre 2:  111011011111010010111101010101
                    ↓ punto de corte
Hijo 1:   011010110101101010111101010101
Hijo 2:   111011011111010011010101101010
```

**Parámetro**: Tasa de recombinación **tᵣ** (probabilidad de seleccionar un individuo para recombinar)
- Valor típico: **tᵣ = 0.7** (70%)

### 3. Selección Natural

Eliminación de los **peores individuos** según la función de fitness y reemplazo por nuevos individuos (aleatorios o generados por mutación/recombinación).

---

## Esquema General de un Algoritmo Genético

```pseudocode
1. Generar la población P aleatoriamente;
2. while(la población no es satisfactoria)
3. {
4.     Seleccionar algunos individuos de P y mutarlos;
5.     Seleccionar algunos pares de individuos de P y recombinarlos;
6.     Eliminar de P los peores individuos según la función de fitness;
7.     Reemplazar los individuos eliminados con nuevos individuos aleatorios;
8. }
9. return el mejor individuo de P;
```

---

## Parámetros de un Algoritmo Genético

### Parámetros Esenciales

1. **Tamaño de la población (m)**
   - Cantidad de individuos en la población
   - Valor típico: **m = 1000**

2. **Tasa de mutación (tₘ)**
   - Probabilidad de seleccionar un individuo para mutarlo
   - Valor típico: **tₘ = 0.001** (0.1%)

3. **Tasa de recombinación (tᵣ)**
   - Probabilidad de seleccionar un individuo para recombinarlo
   - Valor típico: **tᵣ = 0.7** (70%)

### Ajuste de Parámetros

Estos valores deben **ajustarse empíricamente** para cada problema específico:
- Muy poca mutación → convergencia prematura
- Mucha mutación → búsqueda aleatoria
- Muy poca recombinación → poca exploración
- Mucha recombinación → pérdida de buenos individuos

---

## Criterios de Terminación

Un algoritmo genético puede terminar cuando:

### 1. Máximo de Iteraciones
Se alcanza un número predeterminado de generaciones.

### 2. Umbral de Fitness
La mejor solución tiene un fitness por encima de cierto umbral establecido de antemano.

### 3. Convergencia
Pasa una cierta cantidad de iteraciones sin mejora en el mejor fitness.

### Observación Importante

En general, **no hay un criterio definido** para saber cuándo se alcanzó el óptimo. Un algoritmo genético es un **proceso iterativo convergente** hacia la solución óptima, pero **no es posible saber** con certeza cuándo se llegó al óptimo.

---

## Ejemplo 1: Problema de la Mochila

### Planteamiento

**Datos de entrada:**
- Capacidad C ∈ R⁺ de la mochila
- Cantidad n ∈ ℕ de objetos
- Peso pᵢ ∈ R⁺ del objeto i
- Beneficio bᵢ ∈ R⁺ del objeto i

**Objetivo:** Maximizar beneficio sin exceder capacidad C

### Codificación

**Cromosoma:** Secuencia de n bits
```
0001010110101001010
```
- Bit i = 1 → objeto i incluido
- Bit i = 0 → objeto i NO incluido

### Función de Fitness

```
fitness(individuo) = beneficio_total - penalización

donde:
- beneficio_total = Σ bᵢ para objetos incluidos
- penalización = 0 si peso ≤ C
                 ∞ (o valor muy grande) si peso > C
```

### Operadores

**Mutación:** Invertir un bit aleatorio (incluir/excluir un objeto)

**Recombinación:** Combinar dos soluciones en un punto de corte aleatorio

---

## Ejemplo 2: Círculo Más Grande

### Planteamiento

**Problema:** Dado un conjunto de círculos en el plano, encontrar el círculo más grande que se puede dibujar sin tocar los círculos existentes.

**Complejidad:**
- En 2D: Se puede resolver eficientemente (largest empty circle)
- En más dimensiones: Complejidad exponencial

### Codificación

**Solución:** Tres valores doubles (x, y, r)
- Centro: (x, y)
- Radio: r

**Cromosoma:** 3k bits divididos en tres genes
```
0110101101  0110101101  0101101010
    ↓           ↓           ↓
   x           y           r
  (k bits)   (k bits)   (k bits)
```

Cada gen codifica un valor double usando k bits.

### Función de Fitness

```
fitness(x, y, r) = área_círculo - cantidad_intersecciones

donde:
- área_círculo = π × r²
- cantidad_intersecciones = número de círculos del input que interseca
```

**Validación:** Dados (x, y, r), se puede verificar eficientemente si corresponde a una solución válida.

---

## Cómo Diseñar un Algoritmo Genético

### Pasos Esenciales

1. **Definir la codificación**
   - ¿Cómo se representa una solución como secuencia de bits?
   - ¿Qué genes conforman un cromosoma?

2. **Diseñar la función de fitness**
   - Debe medir la calidad de una solución
   - Debe ser eficiente de calcular
   - Debe guiar la búsqueda hacia buenas soluciones

3. **Configurar parámetros**
   - Tamaño de población (m)
   - Tasa de mutación (tₘ)
   - Tasa de recombinación (tᵣ)
   - Criterio de terminación

4. **Implementar operadores (opcional)**
   - Mutación personalizada
   - Recombinación especializada
   - Selección (ruleta, torneo, etc.)

---

## Ventajas y Desventajas

### Ventajas ✅

- **No requieren información del gradiente** (útil para problemas discretos)
- **Exploran ampliamente el espacio de búsqueda** (evitan mínimos locales)
- **Paralelizables naturalmente** (cada individuo se evalúa independientemente)
- **Aplicables a diversos problemas** sin necesidad de adaptaciones complejas
- **Combinan exploración y explotación** mediante operadores genéticos

### Desventajas ❌

- **No garantizan encontrar el óptimo** (son heurísticas)
- **Muchos parámetros para ajustar** empíricamente
- **Pueden ser lentos para converger** en algunos problemas
- **No hay criterio claro de optimalidad** (no se sabe cuándo parar)
- **Requieren buena función de fitness** (diseño no trivial)

---

## Cuándo Usar Algoritmos Genéticos

### Casos Ideales 🎯

1. **Problemas NP-completos** donde se necesita solución razonable en tiempo polinomial
2. **Espacios de búsqueda grandes y complejos** con muchos mínimos locales
3. **Problemas de optimización combinatoria** difíciles de resolver exactamente
4. **Cuando no se conoce estructura del problema** para diseñar heurística específica
5. **Optimización multiobjetivo** (con adaptaciones)

### No Recomendados ⚠️

1. **Problemas con algoritmos exactos eficientes** conocidos
2. **Cuando se requiere garantía de optimalidad**
3. **Espacios de búsqueda muy pequeños** (fuerza bruta es más simple)
4. **Tiempo muy limitado** para ajustar parámetros

---

## Variantes y Extensiones

### Tipos de Selección

- **Selección por ruleta**: Probabilidad proporcional al fitness
- **Selección por torneo**: Competencia entre subconjuntos
- **Selección elitista**: Preservar mejores individuos

### Tipos de Crossover

- **Crossover de un punto**: Corte en una posición
- **Crossover de dos puntos**: Dos cortes
- **Crossover uniforme**: Cada bit se hereda aleatoriamente

### Algoritmos Evolutivos Relacionados

- **Estrategias evolutivas**: Mutación adaptativa
- **Programación genética**: Evolución de programas/árboles
- **Algoritmos meméticos**: Combinan AG con búsqueda local

---

## Comparación con Otras Técnicas

| Técnica | Garantía | Complejidad | Flexibilidad |
|---------|----------|-------------|--------------|
| **Fuerza bruta** | Óptima | Exponencial | Universal |
| **Backtracking** | Óptima | Exponencial (con poda) | Necesita estructura |
| **Golosos** | Variable | Polinomial | Limitada |
| **Alg. Genéticos** | No garantiza | Polinomial | Muy flexible |
| **Programación dinámica** | Óptima | Pseudo-polinomial | Requiere subestructura |

---

## Consideraciones Prácticas

### Diseño de Fitness

- Debe ser **rápida de evaluar** (se calcula muchas veces)
- Debe **discriminar bien** entre soluciones buenas y malas
- Considerar **penalizaciones** para soluciones inválidas
- Evitar **fitness engañoso** que guíe hacia malas regiones

### Balance Exploración-Explotación

- **Alta mutación**: Más exploración (búsqueda amplia)
- **Baja mutación**: Más explotación (refinamiento local)
- **Alta recombinación**: Combina características exitosas
- **Elitismo**: Preserva mejores soluciones encontradas

### Convergencia

El algoritmo puede:
- **Converger prematuramente** → aumentar diversidad (más mutación)
- **No converger** → aumentar selección o reducir mutación
- **Oscilar** → ajustar balance de operadores

---

## Conclusiones

Los algoritmos genéticos representan una herramienta poderosa para:

- ✅ Resolver problemas NP-completos de forma aproximada
- ✅ Explorar espacios de búsqueda complejos
- ✅ Encontrar soluciones razonables sin conocimiento del dominio
- ✅ Aplicar principios biológicos a problemas computacionales

**Clave del éxito:** 
- Buena codificación de soluciones
- Función de fitness adecuada
- Ajuste empírico de parámetros
- Criterio de terminación apropiado

Son especialmente útiles cuando:
- No existe algoritmo exacto eficiente
- Se prioriza tiempo de ejecución sobre garantía de optimalidad
- El espacio de búsqueda es grande y complejo

---

*Material basado en las clases de Programación III - UNGS*
