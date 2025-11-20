# Temas Avanzados de Programación en Java

Este repositorio contiene resúmenes de conceptos avanzados de programación en Java, correspondientes al curso de Programación III - UNGS.

---

# Principios SOLID en Java

Los principios SOLID son cinco principios de diseño orientado a objetos que hacen el software más mantenible, flexible y escalable.

## 1. S - Single Responsibility Principle (Principio de Responsabilidad Única)

Una clase debe tener una sola razón para cambiar, es decir, una única responsabilidad.

### Ejemplo incorrecto:

```java
public class Empleado {
    private String nombre;
    private double salario;
    
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
    
    public void guardarEnBaseDatos() {
        // Lógica para guardar en BD
        System.out.println("Guardando empleado " + nombre + " en la base de datos");
    }
    
    public void calcularImpuestos() {
        // Cálculo de impuestos
        double impuesto = salario * 0.30;
        System.out.println("Impuesto calculado: " + impuesto);
    }
    
    public void generarReciboPago() {
        // Generación de recibo
        System.out.println("Generando recibo de pago para " + nombre);
    }
}
```

**Problema:** La clase Empleado tiene múltiples responsabilidades: gestión de datos, persistencia, cálculos fiscales y generación de documentos.

### Solución:

```java
public class Empleado {
    private String nombre;
    private double salario;
    
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
    
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }
}

public class EmpleadoRepository {
    public void guardar(Empleado empleado) {
        System.out.println("Guardando empleado " + empleado.getNombre() + " en la base de datos");
    }
}

public class CalculadoraImpuestos {
    public double calcular(Empleado empleado) {
        return empleado.getSalario() * 0.30;
    }
}

public class GeneradorRecibos {
    public void generar(Empleado empleado) {
        System.out.println("Generando recibo de pago para " + empleado.getNombre());
    }
}
```

---

## 2. O - Open/Closed Principle (Principio Abierto/Cerrado)

Las clases deben estar abiertas para extensión pero cerradas para modificación.

### Ejemplo incorrecto:

```java
public class ProcesadorPago {
    public void procesarPago(String metodoPago, double monto) {
        if (metodoPago.equals("tarjeta")) {
            System.out.println("Procesando pago con tarjeta: $" + monto);
        } else if (metodoPago.equals("paypal")) {
            System.out.println("Procesando pago con PayPal: $" + monto);
        } else if (metodoPago.equals("bitcoin")) {
            System.out.println("Procesando pago con Bitcoin: $" + monto);
        }
        // Si agregamos un nuevo método, debemos modificar esta clase
    }
}
```

**Problema:** Cada vez que agregamos un nuevo método de pago, debemos modificar la clase existente.

### Solución:

```java
public interface MetodoPago {
    void procesar(double monto);
}

public class PagoTarjeta implements MetodoPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Procesando pago con tarjeta: $" + monto);
    }
}

public class PagoPayPal implements MetodoPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Procesando pago con PayPal: $" + monto);
    }
}

public class PagoBitcoin implements MetodoPago {
    @Override
    public void procesar(double monto) {
        System.out.println("Procesando pago con Bitcoin: $" + monto);
    }
}

public class ProcesadorPago {
    private MetodoPago metodoPago;
    
    public ProcesadorPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public void procesar(double monto) {
        metodoPago.procesar(monto);
    }
}
```

---

## 3. L - Liskov Substitution Principle (Principio de Sustitución de Liskov)

Los objetos de una clase derivada deben poder reemplazar objetos de la clase base sin alterar el comportamiento del programa.

### Ejemplo incorrecto:

```java
public class Rectangulo {
    protected int ancho;
    protected int alto;
    
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    public int calcularArea() {
        return ancho * alto;
    }
}

public class Cuadrado extends Rectangulo {
    @Override
    public void setAncho(int ancho) {
        this.ancho = ancho;
        this.alto = ancho;  // Viola el principio
    }
    
    @Override
    public void setAlto(int alto) {
        this.ancho = alto;  // Viola el principio
        this.alto = alto;
    }
}
```

**Problema:** Cuadrado modifica el comportamiento esperado de Rectangulo, rompiendo la sustitución.

### Solución:

```java
public interface Forma {
    int calcularArea();
}

public class Rectangulo implements Forma {
    private int ancho;
    private int alto;
    
    public Rectangulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    @Override
    public int calcularArea() {
        return ancho * alto;
    }
}

public class Cuadrado implements Forma {
    private int lado;
    
    public Cuadrado(int lado) {
        this.lado = lado;
    }
    
    public void setLado(int lado) {
        this.lado = lado;
    }
    
    @Override
    public int calcularArea() {
        return lado * lado;
    }
}
```

---

## 4. I - Interface Segregation Principle (Principio de Segregación de Interfaces)

Los clientes no deberían verse obligados a depender de interfaces que no utilizan.

### Ejemplo incorrecto:

```java
public interface Vehiculo {
    void conducir();
    void volar();
    void navegar();
}

public class Coche implements Vehiculo {
    @Override
    public void conducir() {
        System.out.println("Conduciendo el coche");
    }
    
    @Override
    public void volar() {
        throw new UnsupportedOperationException("Los coches no vuelan");
    }
    
    @Override
    public void navegar() {
        throw new UnsupportedOperationException("Los coches no navegan");
    }
}
```

**Problema:** Coche se ve obligado a implementar métodos que no necesita.

### Solución:

```java
public interface Conducible {
    void conducir();
}

public interface Volable {
    void volar();
}

public interface Navegable {
    void navegar();
}

public class Coche implements Conducible {
    @Override
    public void conducir() {
        System.out.println("Conduciendo el coche");
    }
}

public class Avion implements Conducible, Volable {
    @Override
    public void conducir() {
        System.out.println("Rodando en la pista");
    }
    
    @Override
    public void volar() {
        System.out.println("Volando el avión");
    }
}

public class Barco implements Navegable {
    @Override
    public void navegar() {
        System.out.println("Navegando el barco");
    }
}
```

---

## 5. D - Dependency Inversion Principle (Principio de Inversión de Dependencias)

Las clases de alto nivel no deben depender de clases de bajo nivel. Ambas deben depender de abstracciones.

### Ejemplo incorrecto:

```java
public class AccesoMySQL {
    public void conectar() {
        System.out.println("Conectando a MySQL");
    }
    
    public String obtenerDatos() {
        return "Datos de MySQL";
    }
}

public class ServicioProductos {
    private AccesoMySQL baseDatos;
    
    public ServicioProductos() {
        this.baseDatos = new AccesoMySQL();  // Dependencia directa
    }
    
    public void listarProductos() {
        baseDatos.conectar();
        String datos = baseDatos.obtenerDatos();
        System.out.println(datos);
    }
}
```

**Problema:** ServicioProductos depende directamente de una implementación concreta, dificulta cambiar de base de datos.

### Solución:

```java
public interface BaseDatos {
    void conectar();
    String obtenerDatos();
}

public class AccesoMySQL implements BaseDatos {
    @Override
    public void conectar() {
        System.out.println("Conectando a MySQL");
    }
    
    @Override
    public String obtenerDatos() {
        return "Datos de MySQL";
    }
}

public class AccesoPostgreSQL implements BaseDatos {
    @Override
    public void conectar() {
        System.out.println("Conectando a PostgreSQL");
    }
    
    @Override
    public String obtenerDatos() {
        return "Datos de PostgreSQL";
    }
}

public class ServicioProductos {
    private BaseDatos baseDatos;
    
    public ServicioProductos(BaseDatos baseDatos) {
        this.baseDatos = baseDatos;  // Inyección de dependencia
    }
    
    public void listarProductos() {
        baseDatos.conectar();
        String datos = baseDatos.obtenerDatos();
        System.out.println(datos);
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        BaseDatos db = new AccesoPostgreSQL();
        ServicioProductos servicio = new ServicioProductos(db);
        servicio.listarProductos();
    }
}
```


## Conclusión

Estos principios trabajan juntos para crear código más limpio, modular y fácil de mantener. Aplicarlos correctamente facilita las pruebas, reduce el acoplamiento y aumenta la cohesión del código.

---

## 💾 Serialización

### Concepto

**Serialización:** Proceso de convertir un objeto o estructura de datos a un formato que puede ser almacenado o transmitido por red.

**Objetivo:** Recrear el mismo objeto a partir de la información almacenada, en la misma u otra computadora.

### Implementación en Java

**Requisito:** La clase debe implementar la interfaz `Serializable`

```java
import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String DNI;
    private int edad;
    private static final long serialVersionUID = 1L;
    
    public Persona(String n, String d, int e) {
        nombre = n;
        DNI = d;
        edad = e;
    }
}
```

### Escribir Objetos Serializados

```java
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

try {
    FileOutputStream fos = new FileOutputStream("personas.txt");
    ObjectOutputStream out = new ObjectOutputStream(fos);
    
    out.writeObject(p1);
    out.writeObject(p2);
    out.writeObject(p3);
    out.close();
} catch(Exception ex) {
    ex.printStackTrace();
}
```

### Leer Objetos Serializados

```java
try {
    FileInputStream fis = new FileInputStream("personas.txt");
    ObjectInputStream in = new ObjectInputStream(fis);
    
    p1 = (Persona) in.readObject();
    p2 = (Persona) in.readObject();
    p3 = (Persona) in.readObject();
    
    in.close();
} catch(Exception ex) { ... }
```

### Serialización de Estructuras

```java
public class Padron implements Serializable {
    private static final long serialVersionUID = 1L;
    private LinkedList<Persona> personas;
    
    public Padron() {
        personas = new LinkedList<Persona>();
    }
}
```

**Importante:** Para que una estructura sea serializable, todas las clases involucradas deben ser serializables.

### Palabra Clave transient

Para evitar que un miembro sea serializado:

```java
public class Persona implements Serializable {
    private String nombre;
    private String DNI;
    transient private int edad;  // No se serializa
    private static final long serialVersionUID = 1L;
}
```

Al leer los objetos, los campos `transient` tendrán sus valores por defecto (0 para números, null para objetos).

### JSON (JavaScript Object Notation)

Formato liviano para intercambio de datos:

**Características:**
- Formato de texto, similar a XML
- Fácil de generar, interpretar y parsear
- www.json.org

**Ejemplo:**
```json
{
  "nombre": "Juan Perez",
  "nacionalizado": true,
  "edad": 25,
  "direccion": {
    "calle": "J. M. Gutierrez",
    "numero": "1150"
  },
  "telefonos": [
    {
      "tipo": "fijo",
      "numero": "4675-4781"
    },
    {
      "tipo": "celular",
      "numero": "15-4535-7651"
    }
  ],
  "conyuge": null
}
```

**Generar JSON con Gson:**
```java
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public void generarJSON(String archivo) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(this);
    
    try {
        FileWriter writer = new FileWriter(archivo);
        writer.write(json);
        writer.close();
    } catch(Exception e) { ... }
}
```

**Leer JSON con Gson:**
```java
public static ArchivoJSON leerJSON(String archivo) {
    Gson gson = new Gson();
    ArchivoJSON ret = null;
    
    try {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        ret = gson.fromJson(br, ArchivoJSON.class);
    } catch(Exception e) { ... }
    
    return ret;
}
```

### Usos de la Serialización

1. **Persistencia de objetos:** Datos permanentes entre ejecuciones
   - Nota: Para concurrencia, es mejor usar bases de datos

2. **Comunicación entre procesos:** Enviar objetos de un proceso a otro

3. **Copias de seguridad:** Detectar cambios en los datos

---

## 📁 Manejo de Archivos en Java

### Escritura de Archivos de Texto

Para escribir en archivos de texto:

```java
try {
    FileOutputStream fos = new FileOutputStream("test.txt");
    OutputStreamWriter out = new OutputStreamWriter(fos);
    
    out.write("Escribiendo una línea\r\n");
    out.write("Escribiendo otra línea");
    out.close();
} catch(Exception e) { ... }
```

**Importante:** A diferencia de la serialización, OutputStreamWriter no es un ObjectOutputStream.

### Lectura de Archivos de Texto

Se utiliza la clase `Scanner` para simplificar el parsing:

```java
FileInputStream fis = new FileInputStream("test.txt");
Scanner scanner = new Scanner(fis);

String s1 = scanner.nextLine();
String s2 = scanner.nextLine();
scanner.close();
```

**Características de Scanner:**
- Contiene métodos para leer todos los tipos de datos primitivos
- `nextInt()` saltea espacios en blanco, saltos de línea y tabulaciones
- Permite leer cualquier conjunto de datos con formato predeterminado

### Lectura desde la Consola

```java
InputStreamReader stdin = new InputStreamReader(System.in);
BufferedReader console = new BufferedReader(stdin);

try {
    String str = console.readLine();
    System.out.println("El usuario ingresó: " + str);
} catch(IOException ex) { ... }
```

Para valores numéricos, realizar conversión explícita:
```java
String str = console.readLine();
double valor = Double.parseDouble(str);
```

### Lectura de Archivos XML

XML (Extensible Markup Language) permite guardar información estructurada:

```java
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

DocumentBuilder builder = 
    DocumentBuilderFactory.newInstance().newDocumentBuilder();
File f = new File(path);
Document documento = builder.parse(f);
recorrer(documento);
```

Recorrido recursivo del documento:
```java
public void recorrer(Node nodo) {
    if(nodo != null) {
        System.out.println(nodo.getNodeName() + " - " + 
                          nodo.getNodeValue());
        NodeList hijos = nodo.getChildNodes();
        
        for(int i = 0; i < hijos.getLength(); i++)
            recorrer(hijos.item(i));
    }
}
```

---

## 🎭 Clases Anónimas

### Concepto

Las clases anónimas permiten implementar una interfaz o heredar de otra clase sin darle un nombre a la nueva clase.

**Características:**
- Corresponde a declarar una clase local, pero sin nombre
- Se declara e instancia en un único comando
- Se debe usar solamente una vez, dentro del scope de la declaración
- Son expresiones, pueden usarse dentro de otra expresión

### Sintaxis

1. El operador `new`
2. El nombre de una interfaz a implementar o clase a heredar
3. Paréntesis que representan el constructor (sin parámetros)
4. El cuerpo de la declaración entre llaves

### Ejemplo con Comparator

Sin clase anónima:
```java
class Comparador implements Comparator<Objeto> {
    public boolean compare(Objeto uno, Objeto otro) {
        if(uno.getPeso() < otro.getPeso())
            return -1;
        else if(uno.getPeso() == otro.getPeso())
            return 0;
        else
            return 1;
    }
}

Collections.sort(lista, new Comparador());
```

Con clase anónima:
```java
Saludador s = new Saludador() {
    private String mundo = "mundo!";
    
    public void saludar() {
        saludar(mundo);
    }
    
    public void saludar(String alguien) {
        System.out.println("Hola, " + alguien);
    }
}
```

### Elementos Permitidos

- Variables de instancia
- Métodos adicionales (que no correspondan a la interfaz implementada)
- Inicializadores de instancia
- Clases locales
- **No se pueden declarar constructores**

### Captura de Variables

Una clase anónima tiene acceso a:
- Los miembros de la clase que la contiene
- Las variables locales definidas como `final`

---

## λ Expresiones Lambda

### Concepto

Las expresiones lambda (Java 1.8+) permiten definir clases anónimas de forma más sencilla, proporcionando un mecanismo claro para tratar funcionalidad como parámetros de métodos.

**Ventaja:** Simplifican la sintaxis cuando la implementación de una clase anónima es muy sencilla.

### Consumidores (Consumer)

Un consumidor realiza una acción sobre una instancia y no retorna resultados.

```java
private static void aplicar(ArrayList<Persona> personas,
                           Consumer<Persona> consumidor) {
    for(Persona persona: personas)
        consumidor.accept(persona);
}

// Uso
aplicar(personas, p -> p.mostrarNombre());
aplicar(personas, p -> { System.out.println(p.nombre); });
aplicar(personas, p -> { System.out.println(p.nombre + ", " + p.edad); });
```

### Predicados (Predicate)

Un predicado toma una instancia y retorna un `boolean`. Se usa principalmente para filtrar colecciones.

```java
private static void filtrar(ArrayList<Persona> personas,
                           Predicate<Persona> filtro) {
    for(Persona persona: personas) {
        if(filtro.test(persona) == true)
            persona.mostrarNombre();
    }
}

// Uso
filtrar(personas, p -> p.esMayor());
filtrar(personas, p -> { return p.edad > 30; });
```

### Funciones (Function)

Las funciones toman una instancia y retornan un resultado.

```java
private static void calcular(ArrayList<Persona> personas,
                            Function<Persona, Double> funcion) {
    for(Persona persona: personas)
        System.out.println(persona.nombre + " = " + funcion.apply(persona));
}

// Uso
calcular(personas, p -> p.mediaEdad());
calcular(personas, p -> { return p.edad / 3.0; });
```

### Implementando Comparator con Lambda

```java
Collections.sort(personas, (p,q) -> { 
    return p.edad < q.edad ? 1 : (p.edad == q.edad ? 0 : -1); 
});

Collections.sort(personas, (p,q) -> { 
    return p.nombre.compareTo(q.nombre); 
});
```

**Nota:** Si una expresión lambda tiene dos parámetros, deben definirse entre paréntesis.

---


## 🌊 Streams

### Concepto

**Stream:** Secuencia de objetos a partir de un origen que soporta operaciones agregadas.

**Características:**
1. Proporciona acceso secuencial a objetos obtenidos o computados por demanda
2. No almacena los objetos de la secuencia
3. El origen puede ser: colección, arreglo, dispositivos I/O, o cálculo iterativo
4. La mayoría de operaciones retorna el mismo stream (concatenación de operaciones)

### Creación de Streams

**Stream vacío:**
```java
Stream<String> streamEmpty = Stream.empty();
```

**Desde una colección:**
```java
ArrayList<String> collection = new ArrayList<String>();
collection.add(...);
Stream<String> streamOfCollection = collection.stream();
```

**Desde un arreglo:**
```java
String[] arreglo = new String[]{ "a", "b", "c" };
Stream<String> streamOfArray = Arrays.stream(arreglo);
```

**Con valores calculados:**
```java
Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
```

**Streams numéricos:**
```java
IntStream intStream = IntStream.range(1, 3);      // No incluye el 3
LongStream longStream = LongStream.rangeClosed(1, 3); // Incluye el 3
```

**Desde un archivo:**
```java
Path path = Paths.get("C:\\file.txt");
Stream<String> streamOfStrings = Files.lines(path);
```

### Operaciones Intermedias

Operan con el stream y retornan referencia al mismo stream:

**map():** Aplica un método a cada elemento
```java
IntStream.range(1, 10).map(x -> 2*x);
```

**filter():** Retorna elementos que cumplen la condición
```java
IntStream.range(1, 10).filter(x -> x%2 == 0);
```

**skip(n):** Saltea los n primeros elementos
```java
IntStream.range(1, 10).skip(3);
```

**limit(n):** Obtiene los n primeros elementos
```java
IntStream.range(1, 10).skip(3).limit(4);
```

### Operaciones Terminales

No retornan referencia al stream. Una vez aplicada, el stream no se puede volver a usar.

**forEach():** Aplica un método a cada elemento
```java
IntStream.range(1, 10).limit(3).forEach(System.out::println);
```

**count():** Retorna la cantidad de elementos
```java
long cant = IntStream.range(1, 10).filter(x -> x%2 == 0).count();
```

**Operaciones numéricas:** sum(), min(), max(), average()
```java
IntStream.range(1, 10).sum();
IntStream.range(1, 10).min();
IntStream.range(1, 10).max();
IntStream.range(1, 10).average();
```

**Conversión a stream numérico:**
```java
ArrayList<Empleado> empleados = new ArrayList<Empleado>();
double tot = empleados.stream()
    .filter(e -> e.getAntiguedad() > 2)
    .mapToDouble(Empleado::getSueldo)
    .sum();
```

**reduce():** Aplica operación binaria sobre todos los elementos
```java
IntStream.range(1, 4).reduce((a, b) -> a + b);        // 1+2+3
IntStream.range(1, 4).reduce(10, (a, b) -> a + b);    // 10+1+2+3
```

### Importante: Reutilización de Streams

```java
Stream<String> stream = Stream.of("aa", "ab", "cb").filter(e -> e.contains("b"));
Optional<String> elemento = stream.findFirst();  // OK
Optional<String> elemento = stream.findFirst();  // Error! Stream ya usado
```

### Evaluación Lazy y Orden de Ejecución

- Las operaciones se evalúan por demanda (lazy)
- Se evalúan de izquierda a derecha
- **Importante:** Filtrar primero antes de operaciones costosas

```java
// Ineficiente: map sobre todos los empleados
empleados.map(a -> operacionCostosa(a)).filter(a -> a.esPropio());

// Eficiente: map solo sobre empleados propios
empleados.filter(a -> a.esPropio()).map(a -> operacionCostosa(a));
```

### Cierre de Streams

- Lo habitual: aplicar operación terminal como última operación
- Si no se hace: cerrar el stream con `close()`
- Un stream no cerrado ocupa memoria durante toda la ejecución

---

## 🏛️ Arquitecturas para Interfaces de Usuario

### Principio: Separated Presentation

**Definición:** Mantener el código de presentación y el código de dominio en capas separadas, con el código de dominio sin conocimiento del código de presentación.

**Importancia:**
- Evitar incluir lógica de negocio en el código de interfaz
- Mantener separado el código de interfaz del código de negocio

### Arquitectura en Tres Capas

1. **Nivel de Presentación**
   - Contiene la interfaz de usuario
   - No realiza procesamiento de negocio
   - Solo procesa lo necesario para presentar información adecuadamente

2. **Nivel de Aplicación o Negocio**
   - Contiene la funcionalidad del sistema
   - En OOP: incluye las clases de negocio y su implementación

3. **Nivel de Datos**
   - Almacenamiento de información
   - Funcionalidad asociada con el acceso a datos

### Arquitectura Forms and Controls

**Funcionamiento:**
- Interfaces visuales (forms, frames) con controles visuales
- Las interfaces realizan llamados al código de negocio para:
  1. Ejecutar acciones solicitadas por el usuario
  2. Actualizar los controles visuales cuando cambia el estado

**Regla fundamental:** El código de negocio NUNCA debe llamar al código de interfaz.

**Ejemplo correcto:**
```java
Button crear = new Button("Crear");
crear.addActionListener(new ActionListener<ActionEvent>() {
    @Override
    public void actionPerformed(ActionEvent evt) {
        Date entrega = pickerEntrega.getDate();
        Cliente cliente = (Cliente) comboCliente.getSelectedItem();
        Producto producto = (Producto) comboProducto.getSelectedItem();
        double cantidad = Double.parseDouble(textCantidad.getText());
        
        pedidos.crearPedido(cliente, producto, entrega, cantidad);
    }
});
```

**Ventajas:**
- Arquitectura sencilla y fácil de implementar
- Toda la lógica GUI contenida en las clases de cada interfaz

**Desventajas:**
- El código de interfaz puede quedar recargado en interfaces complicadas
- La interfaz debe saber cuándo cambia el estado del sistema

### Arquitectura Model-View-Controller (MVC)

Separa la lógica de visualización de la lógica de actualización:

1. **Model:** Clases de negocio que representan las entidades del dominio
2. **View:** Código encargado de mostrar información y controles visuales
3. **Controller:** Toma el input del usuario y ejecuta acciones sobre el código de negocio

**Problema:** El modelo necesita actualizar la vista sin conocerla.

**Solución:** Patrón Observer

```java
public interface ObservadorPedidos {
    public void notificar(Pedido pedido);
}

public class Pedido {
    private ArrayList<ObservadorPedidos> observadores;
    
    public void registrar(ObservadorPedidos observador) {
        observadores.add(observador);
    }
    
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
        descuento = descuento(this);
        notificarObservadores();
    }
    
    private void notificarObservadores() {
        for(ObservadorPedidos observador: observadores)
            observador.notificar(this);
    }
}
```

**Ventajas:**
- El modelo no conoce los detalles de la interfaz
- Cuando el modelo cambia, la vista se actualiza automáticamente
- Se pueden tener múltiples pares view-controller sobre el mismo modelo

### Arquitectura Model-View-Presenter (MVP)

Combina MVC con Forms and Controls.

**Características:**
- La vista es pasiva: solo contiene controles visuales
- No contiene código para reaccionar ante acciones del usuario
- Cuando se genera un evento, se pasa al presenter
- El presenter decide qué hacer y ejecuta métodos del negocio
- El presenter actualiza la vista cuando el modelo se modifica

**Sincronización:**
- Observer synchronization: mediante observadores
- Flow synchronization: consultando métodos del modelo ante cada cambio

---

## 🔤 Expresiones Regulares

### Concepto

Una expresión regular describe un conjunto de strings en función de características comunes.

**Jerarquía de Chomsky:**
0. Tipo 0: Lenguajes reconocibles por un programa (más general)
1. Tipo 1: Gramáticas dependientes del contexto
2. Tipo 2: Gramáticas libres de contexto
3. Tipo 3: Lenguajes dados por expresiones regulares (más restringida, pero operaciones más eficientes)

### Clases en Java

Biblioteca `java.util.regex`:

1. **Pattern:** Representación compilada de una expresión regular
   - No tiene constructores públicos
   - Se crea con `Pattern.compile(regex)`

2. **Matcher:** Motor que interpreta el pattern y busca coincidencias
   - Se obtiene con `pattern.matcher(string)`

3. **PatternSyntaxException:** Excepción de error de sintaxis

### Ejemplo Básico

```java
Pattern pattern = Pattern.compile("foo");
Matcher matcher = pattern.matcher("A buscar foo aqui!");

if(matcher.find()) {
    System.out.println("Encontré " + matcher.group() + 
                      " comenzando en " + matcher.start() + 
                      " y terminando en " + matcher.end());
}
```

### Metacaracteres y Clases

**Metacaracter punto (.):** Representa cualquier caracter
```java
Pattern pattern = Pattern.compile("foo.");
// Reconoce: "fooa", "foob", "foo1", etc.
```

**Clases de caracteres:**
- `[bcr]at` → reconoce "bat", "cat", "rat"
- `[a-z]` → cualquier letra minúscula
- `[A-Z]` → cualquier letra mayúscula
- `[0-9]` → cualquier dígito

**Clases predefinidas:**
- `\d` → dígito [0-9]
- `\D` → no dígito
- `\s` → espacio en blanco
- `\S` → no espacio en blanco
- `\w` → caracter de palabra [a-zA-Z_0-9]
- `\W` → no caracter de palabra

**Nota:** En strings de Java, las barras invertidas se escriben como `\\`

### Cuantificadores

- `x?` → x cero o una vez
- `x*` → x cero o más veces
- `x+` → x una o más veces
- `x{n}` → x exactamente n veces
- `x{n,}` → x por lo menos n veces
- `x{n,m}` → x por lo menos n veces, pero no más de m veces

### Flags de Pattern.compile()

```java
Pattern.compile(regex, flags)
```

- `Pattern.CASE_INSENSITIVE` → No distingue mayúsculas/minúsculas
- `Pattern.COMMENTS` → Permite comentarios y espacios (comentarios con #)
- `Pattern.DOTALL` → El punto (.) también reconoce fin de línea
- `Pattern.LITERAL` → No reconoce metacaracteres ni comandos con barra

### Métodos Útiles

**Pattern:**
- `boolean matches(String regex, String input)` → Chequeo rápido de coincidencia
- `String[] split(String input)` → Divide el string según la regex
- `String toString()` → Retorna la expresión regular

**String:**
- `boolean matches(String regex)` → Verifica si el string coincide con la regex
- `String[] split(String regex)` → Divide el string
- `String replaceAll(CharSequence regex, CharSequence reemplazo)` → Reemplaza coincidencias

---

## 🌐 Sockets en Java

### Protocolo TCP/IP

**Internet Protocol Suite:** Conjunto de protocolos de comunicación usado en Internet.

**Protocolos principales:**
- **TCP:** Transmission Control Protocol
- **IP:** Internet Protocol

**Funcionalidad:** Conectividad punto a punto entre dos procesos, especificando formato, direccionamiento y transmisión de datos.

### Capas de Abstracción TCP/IP

1. **Capa de Aplicación:** Protocolos para servicios específicos (FTP, HTTP, etc.)
2. **Capa de Transporte (TCP):** Maneja comunicación entre equipos
3. **Capa de Red (IP):** Conecta redes locales (red de redes)
4. **Nivel de Enlace (Ethernet):** Comunicación dentro de redes locales

### Direccionamiento

- **Dirección IP:** Identifica cada computadora (ej: 65.125.25.1)
- **Redes locales:** Usan direcciones especiales, el router distribuye el tráfico
- **Puerto:** Cada proceso puede usar uno o varios puertos
- **Conexión:** Se establece especificando dirección IP del host y puerto del proceso

### Sockets

**Definición:** Extremo de una comunicación bidireccional entre dos procesos en la red.

**Características:**
- Cada socket asociado con dirección IP y puerto
- TCP identifica a qué equipo y proceso enviar datos
- El cliente solicita conexión con IP y puerto del servidor
- Se puede usar hostname en lugar de IP (ej: www.ungs.edu.ar)

**Funcionamiento:**
1. Cliente solicita conexión especificando IP y puerto del servidor
2. Sistema asigna puerto al socket del cliente para recibir respuestas
3. Servidor acepta conexión y obtiene nuevo socket para esa conexión
4. Socket original del servidor sigue escuchando nuevos pedidos
5. Servidor puede mantener muchos sockets (uno por cliente)

### Programando un Cliente

**Crear socket y obtener streams:**
```java
Socket client = new Socket("125.251.12.3", 27);

DataOutputStream streamOut = 
    new DataOutputStream(client.getOutputStream());
    
DataInputStream streamIn = 
    new DataInputStream(new BufferedInputStream(client.getInputStream()));
```

**Enviar mensaje al servidor:**
```java
streamOut.writeUTF("Hey hey!");
```

**Recibir respuesta del servidor:**
```java
String str = streamIn.readUTF();
System.out.println("El server dice: " + str);
```

**Codificación UTF:** Permite representar strings de modo independiente del hardware, indicando la cantidad de bytes transmitidos para saber cuándo se completó el mensaje.

---

## 🧵 Threads en Java

### Conceptos Básicos

**Dos unidades de ejecución:**

1. **Proceso:** Entorno de ejecución autocontenido
   - Tiene recursos privados completos
   - Incluye su propio espacio de memoria

2. **Thread (Hilo):** Entorno contenido dentro de un proceso
   - También llamado "lightweight process"
   - Comparte recursos del proceso (memoria, archivos abiertos)

**Importante:** Todo proceso Java tiene al menos un thread, pero puede tener muchos, cada uno dedicado a una tarea distinta.

### Creación de Threads

**Opción 1: Heredar de Thread**

```java
public class MiThread extends Thread {
    public void run() {
        System.out.println("Hola, desde el thread!");
        ...
    }
}

// Uso
MiThread thread = new MiThread();
thread.start();
```

**Opción 2: Implementar Runnable (Recomendada)**

```java
public class MiRunnable implements Runnable {
    public void run() {
        System.out.println("Hola, desde el thread!");
        ...
    }
}

// Uso
Thread thread = new Thread(new MiRunnable());
thread.start();
```

**Ventaja de Runnable:** Permite que la clase herede de otra clase (Java tiene herencia simple).

### Detención de un Thread

**sleep():** Detiene la ejecución por un tiempo determinado

```java
for(int i=0; i<10; ++i) {
    System.out.println("Iteracion " + i);
    Thread.sleep(4000); // En milisegundos
}
```

**Nota:** El tiempo de espera no es preciso (depende del reloj del procesador y el SO).

### Interrupción de un Thread

**Solicitar interrupción:**
```java
MiThread thread = new MiThread();
thread.start();
...
thread.interrupt();
```

**Requisito:** El thread interrumpido debe estar preparado para recibir interrupciones.

**Opción 1: Capturar InterruptedException**
```java
for(int i=0; i<10; ++i) {
    try {
        Thread.sleep(4000);
    } catch(InterruptedException e) {
        System.out.println("Nos interrumpieron. Thread terminado");
        return;
    }
}
```

**Opción 2: Consultar periódicamente**
```java
for(int i=0; i<n; i++) {
    // Tarea pesada
    
    if(Thread.interrupted()) {
        // Nos interrumpieron, salimos
        return;
    }
}
```

### Join con Otro Thread

Esperar a que otro thread termine su ejecución:

```java
MiThread thread = new MiThread();
thread.start();
...
thread.join(); // Esperamos a que termine
```

La llamada a `join()` pausa el thread llamador hasta que el thread llamado termine.

### Usos Habituales de Threads

1. **Cuadro de avance no bloqueado:**
   - Tarea pesada en thread secundario
   - Interfaz sigue respondiendo a mensajes del SO
   - Posibilidad de interrumpir la tarea

2. **Comunicación asincrónica:**
   - Thread que escucha a otro proceso
   - Avisa al thread principal cuando recibe mensajes

3. **Servidor multi-cliente:**
   - Cada cliente atendido en un thread separado
   - Permite atender varias peticiones simultáneamente

4. **Aprovechar procesadores multi-core:**
   - Cada thread de Java se ejecuta como thread del SO
   - Si el SO soporta multi-core, cada thread se ejecuta en un core distinto
   - Acelera ejecución de tareas pesadas

---

## 📚 Referencias

- Programación III - UNGS
- Martin Fowler - Separated Presentation (2006)
- Java Documentation - java.util.regex
- Java Documentation - java.io
- World Wide Web Consortium - XML
- www.json.org


