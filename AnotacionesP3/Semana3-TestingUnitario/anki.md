# 🧩 Preguntas y Respuestas – Testing Unitario y JUnit

## 🧪 Conceptos Generales
<details>
<summary><b>¿Qué es el testing unitario?</b></summary> 
  Es la práctica de probar automáticamente unidades individuales del código (como clases o métodos) para verificar que funcionen correctamente de forma aislada.
</details>

<details> 
<summary><b>¿Cuál es el objetivo del testing unitario?</b></summary> 
  Detectar errores de manera temprana, mejorar el diseño del código y aumentar la confianza en que cada componente funciona según lo esperado. 
</details>

<details> <summary><b>¿Garantiza el testing unitario la ausencia de errores?</b></summary> 
  No. Solo aumenta la probabilidad de detectar errores y mejora la calidad general, pero no asegura que el sistema esté completamente libre de fallos. 
</details>

<details> <summary><b>¿Qué se considera una “unidad” en programación orientada a objetos?</b></summary> 
  Una unidad suele ser una clase o un método individual que se prueba de manera independiente. 
</details>

<details> <summary><b>¿Quién debe escribir los tests unitarios?</b></summary> 
  Los programadores son responsables de escribirlos, generalmente junto con el código de producción. 
</details>

## ⚙️ JUnit
<details> <summary><b>¿Qué es JUnit?</b></summary> 
  Es un framework de testing unitario para Java, desarrollado por Kent Beck y Erich Gamma. Permite definir, ejecutar y automatizar tests fácilmente. 
</details>

<details> <summary><b>¿Cómo se instala JUnit en Eclipse?</b></summary> 
  Al crear un proyecto de pruebas, Eclipse agrega automáticamente la librería `junit.jar` al <b>build path</b>*. 
</details>

<details> <summary><b>¿Qué convención de nombres se usa para las clases de prueba?</b></summary> 
  Se suele agregar la palabra <code>Test</code> al final del nombre de la clase, por ejemplo: <code>PersonaTest</code>, <code>MateriaTest</code>, <code>ArregloTest</code>. 
</details>

## 🧠 Estructura de un Test Unitario

<details> 
<summary><b>¿Cuál es la estructura básica de un test?</b></summary>
* Setup: preparar los datos necesarios.
* Exercise: ejecutar la funcionalidad que se quiere probar.
* Verify: comprobar que el resultado sea el esperado.
* Teardown (opcional): limpiar o restaurar el entorno.
</details>

<details> <summary><b>Ejemplo de test unitario básico en JUnit</b></summary>

@Test
public void cumplirAniosTest() {
    Persona p = new Persona("Pepe", 17); // Setup
    p.cumplirAnios();                    // Exercise
    assertEquals(18, p.getEdad());       // Verify
}
Este test verifica que el método cumplirAnios() incremente correctamente la edad de una persona.
</details>

<details> <summary><b>¿Cómo se ejecutan los tests unitarios en Eclipse?</b></summary> 
    Seleccionando la clase de prueba y eligiendo Run As → JUnit Test. JUnit ejecuta todos los métodos con la anotación <code>@Test</code>. 
</details>

## 🔍 Assertions (Aserciones)
<details> <summary><b>¿Qué son las assertions?</b></summary> 
    Son métodos que verifican condiciones durante el test. Si la condición no se cumple, el test **falla automáticamente**. 
</details>

<details> <summary><b>¿Cuáles son las principales assertions de JUnit?</b></summary>
|Método	|Descripción|
| :--- | :--- |
|assertEquals(expected, actual)	|Verifica igualdad entre valores|
|assertArrayEquals(expected, actual)|	Compara arreglos.|
|assertTrue(cond) / assertFalse(cond)|	Evalúa condiciones booleanas.|
|assertNull(obj) / assertNotNull(obj)|	Verifica nulidad.|
|fail(msg)	|Fuerza un fallo explícito.|
>
</details>
🏷️ Anotaciones Importantes
<details> <summary><b>¿Para qué sirve <code>@Test</code>?</b></summary> Indica que el método es un caso de prueba. </details>
<details> <summary><b>¿Qué hace <code>@Before</code>?</b></summary> Ejecuta un método **antes de cada test**, normalmente para inicializar datos o preparar el entorno. </details>
<details> <summary><b>¿Qué hace <code>@After</code>?</b></summary> Ejecuta un método **después de cada test**, generalmente para liberar recursos o limpiar el entorno. </details>
<details> <summary><b>¿Qué hace <code>@Ignore</code>?</b></summary> Permite **omitir temporalmente** la ejecución de un test. </details>
<details> <summary><b>¿Cómo se prueban excepciones con JUnit?</b></summary>

Se usa la anotación <code>@Test(expected = TipoDeExcepcion.class)</code>.
Ejemplo:

@Test(expected = NullPointerException.class)
public void nullTest() {
    Arreglos.sumarPositivos(null);
}

</details>
<details> <summary><b>¿Qué hace <code>@Test(timeout = 100)</code>?</b></summary> Hace que el test falle si tarda más de **100 milisegundos** en ejecutarse. </details>
✅ Ventajas del Testing Unitario
<details> <summary><b>¿Cuáles son las ventajas principales?</b></summary>

Detecta errores de forma temprana.

Mejora el diseño y la estructura del código.

Da confianza para refactorizar.

Sirve como documentación viva.

Reduce el tiempo de depuración.

</details>
<details> <summary><b>¿Qué dijo Robert Martin sobre los tests?</b></summary> > “Los tests son documentos vivos, claros y sincronizados con el código, porque se ejecutan y no pueden desactualizarse.” Además, los tests bien diseñados **reducen el acoplamiento** y permiten refactorizar sin miedo. </details>
⚠️ Limitaciones del Testing Unitario
<details> <summary><b>¿Qué limitaciones tiene?</b></summary>

No garantiza que el sistema esté libre de errores.

Requiere mantenimiento constante.

No cubre los errores de integración entre módulos.

Puede ser difícil diseñar tests totalmente independientes.

</details>
🧮 Ejemplos de Tests de Borde
<details> <summary><b>¿Qué son los casos de borde?</b></summary> Son escenarios extremos o límites que prueban el comportamiento del sistema frente a valores mínimos, máximos o situaciones no comunes. Ejemplo: listas vacías, valores nulos o negativos. </details>
<details> <summary><b>Ejemplo de test de borde para una clase Materia</b></summary>
@Test
public void sinInscriptosTest() {
    Materia m = new Materia("Programacion III");
    assertEquals(0, m.cantidadAprobados());
}


Comprueba que una materia sin inscriptos tenga 0 aprobados.

</details>
<details> <summary><b>Ejemplo de test de inscripción válida</b></summary>
@Test
public void postInscripcionTest() {
    Materia m = new Materia("Programacion III");
    Alumno a = new Alumno("Jose Perez", "32514521/2011");
    m.inscribir(a);
    assertTrue(m.estaInscripto(a));
}


Verifica el caso correcto de inscripción de un alumno.

</details>
🧱 TDD – Test Driven Development
<details> <summary><b>¿Qué es el Test Driven Development (TDD)?</b></summary> Es una metodología donde primero se escribe un **test que falla**, luego el **código mínimo para pasarlo**, y finalmente se **refactoriza** el código. </details>
<details> <summary><b>¿Cuáles son las tres leyes del TDD?</b></summary>

No escribir código de producción sin un test que falle.

No escribir más de un test que falle a la vez.

No escribir más código del necesario para pasar el test.

</details>
<details> <summary><b>¿Qué ventajas tiene el TDD?</b></summary>

Mejora el diseño del código.

Reduce errores.

Obliga a pensar en la interfaz antes de implementarla.

Garantiza cobertura de pruebas desde el inicio.

</details>
<details> <summary><b>¿Qué desventajas puede tener el TDD?</b></summary>

Puede requerir más tiempo inicial.

No siempre es fácil escribir buenos tests antes del código.

Puede ser menos útil en proyectos con requisitos poco definidos.

</details>
💡 Buenas Prácticas
<details> <summary><b>¿Qué buenas prácticas se recomiendan al escribir tests unitarios?</b></summary>

Escribir un test por cada funcionalidad importante.

No testear getters ni setters triviales.

Asegurar independencia entre tests.

Usar mocks para evitar efectos reales sobre los datos.

Actualizar los tests con cada cambio de funcionalidad.

Ejecutar los tests con frecuencia.

Crear un test antes de corregir un bug.

</details>
<details> <summary><b>¿Por qué escribir un test antes de corregir un bug?</b></summary> Para garantizar que el bug se reproduce, que se corrige efectivamente y que **no vuelva a aparecer** en el futuro. </details>
<details> <summary><b>¿Qué recomendación hace Alex Iskold sobre testing?</b></summary> > “Al principio parece trabajo extra, pero una vez que empezás a escribir tests, te preguntás cómo programabas sin ellos.” También recomienda practicarlo en **parejas (pair testing)** para hacerlo más productivo y divertido. </details>
