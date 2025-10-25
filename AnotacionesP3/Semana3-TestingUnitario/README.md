# 🧪 Unit Testing – Pruebas Unitarias

Fuente: _Coding with Confidence – Unit Testing_
Materia: Programación III – UNGS
Tema: Pruebas unitarias en Java con JUnit

---

## 📘 Introducción: Escribiendo Código con Confianza

Las <b>pruebas unitarias</b> son una herramienta fundamental para los programadores modernos.
<b>No se diseñaron para los usuarios, jefes o equipos de QA, sino por y para los desarrolladores.</b>
Su objetivo es ayudarnos a escribir código con confianza, detectando errores de forma temprana y asegurando que cada parte del sistema funcione correctamente.

### La Historia de Pat y Dale

El concepto se ilustra con la historia de Pat y Dale:

* <b>Pat</b> desarrolla rápido sin probar nada, y al final su código falla completamente.
* <b>Dale</b>, en cambio, escribe una pequeña prueba por cada función. Avanza más lento, pero su código funciona casi perfecto al final.

La diferencia entre ambos no está en sus habilidades, sino en su <b>enfoque de testing</b> Las pruebas unitarias son la base de la confianza en el código.

---

## 💡 ¿Qué es una Prueba Unitaria?

Una prueba unitaria es un <b>pequeño bloque de código</b> que verifica el funcionamiento de una unidad específica del programa, generalmente un <b>método o una función</b>

Estas pruebas se centran en comprobar que el código hace lo que el programador espera que haga, <b>no en validar requerimientos de usuario ni rendimiento</b>

<b>Ejemplos:</b>
* Agregar un valor a una lista ordenada y verificar que esté en la posición correcta.
* Eliminar caracteres de una cadena y comprobar que hayan desaparecido.

El propósito es garantizar que <b>cada pieza pequeña del sistema funcione correctamente</b> antes de integrarla con el resto.

---

## ⚙️ ¿Por qué realizar pruebas unitarias?

El documento resalta los siguientes beneficios clave:

| Beneficio | Impacto |
| :--- | :--- |
| <b>Reducen el tiempo de depuración</b> | Los errores se encuentran al instante. |
| <b>Mejoran el diseño del código</b> | Escribir pruebas te obliga a pensar en modularidad. |
| <b>Generan confianza al refactorizar</b> | Podés cambiar el código sin miedo a romper nada. |
| <b>Previenen efectos en cascada</b> | Evitan que errores pequeños deriven en grandes fallos. |
| <b>Sirven como documentación viva</b> | Las pruebas muestran cómo se espera que funcione cada método. |

> Sin pruebas, el código se convierte en un castillo de naipes: un error en la base puede derribar todo el sistema.

---

## 🧠 Coding with Confidence

El corazón del testing unitario se resume en una frase:

* <b>"Para tener confianza en tu código, debés preguntarle al código mismo qué está haciendo.”</b>

Esto significa que debemos escribir pruebas que verifiquen automáticamente el comportamiento de cada unidad. Si el resultado no es el esperado, la prueba falla y el error se detecta de inmediato.

Las pruebas unitarias son, por tanto, <b>la herramienta más efectiva para mejorar la calidad y seguridad del desarrollo</b>

---

## 📈 Beneficios del Unit Testing (Resumen)
Detección temprana de errores: los fallos se descubren al escribir el código.

* Mejor diseño: el código se vuelve más modular y fácil de mantener.

* Seguridad al refactorizar: garantiza que los cambios no rompan el comportamiento esperado.

* Documentación automática: cada prueba describe cómo debería funcionar el método.

* Reducción del uso del depurador: los tests localizan el error rápidamente.

## 🧱 Buenas prácticas
* Escribir las pruebas antes o junto al código.

* Empezar con casos simples y avanzar a los límites o excepciones.

* Probar entradas vacías, valores negativos y duplicados.

* Mantener el código de prueba legible y claro, aunque sea más largo.

* No buscar probar todos los valores posibles, sino los casos significativos.

## 🧩 Conclusión
* Las pruebas unitarias no garantizan que el sistema cumpla todos los requisitos del cliente, pero sí aseguran que el código hace lo que vos esperás que haga.

* Son una herramienta para escribir software más confiable, más fácil de mantener y más simple de evolucionar.

<b>“Testing, like charity, begins at home.” (Las pruebas, como la caridad, comienzan en casa.)</b>
