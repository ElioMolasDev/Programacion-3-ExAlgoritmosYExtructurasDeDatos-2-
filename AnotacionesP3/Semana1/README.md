# 📘 Semana 1 – Complejidad Computacional(Repaso) y Estrategia Divide & Conquer

Esta primera semana se estudian dos pilares fundamentales del análisis de algoritmos:

## 🧩 Complejidad Computacional

La **complejidad computacional** analiza el rendimiento de un algoritmo en función del tamaño de la entrada. Se utiliza para comparar algoritmos y estimar su eficiencia.

### Conceptos principales
- **Eficiencia temporal:** mide el tiempo de ejecución.
- **Eficiencia espacial:** mide la memoria utilizada.
- **Tipos comunes de complejidad:**
  - O(1) → constante  
  - O(log n) → logarítmica  
  - O(n) → lineal  
  - O(n log n) → casi lineal  
  - O(n²), O(n³) → polinomial  
  - O(2ⁿ), O(n!) → exponencial / factorial

### Ejemplos típicos
- Búsqueda secuencial → O(n)
- Búsqueda binaria → O(log n)
- Ordenamiento burbuja → O(n²)
- Quicksort → O(n log n) (promedio)
- Fuerza bruta → O(2ⁿ)

---

## ⚙️ Estrategia Divide & Conquer

El método **Divide and Conquer (Dividir y Vencer)** consiste en resolver un problema grande dividiéndolo en subproblemas más pequeños, resolviendo cada uno y combinando los resultados.

### Etapas principales
1. **Dividir:** separar el problema en partes más pequeñas.
2. **Conquistar:** resolver los subproblemas de forma recursiva.
3. **Combinar:** integrar las soluciones parciales para formar la solución global.

### Ejemplos clásicos
- **MergeSort** (ordenamiento eficiente)
- **QuickSort** (particionamiento recursivo)
- **Búsqueda binaria**
