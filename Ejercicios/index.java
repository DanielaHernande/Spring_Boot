import java.util.Arrays;
import java.util.Scanner;

public class index {
    
    public static void main(String[] args) {
        
        // 1. Escribe un programa en Java que imprima "Hola, Mundo!".
        //System.out.println("Hola Mundo!");

        // 2. Escribe un programa en Java que sume dos números y muestre el resultado.
       /*  Scanner objScann = new Scanner(System.in);

        System.out.println("Ingrese un primer numero");
        int num1 = objScann.nextInt();

        System.out.println("Ingrese un segundo numero");
        int num2 = objScann.nextInt();

        System.out.println("La suma de los numeros " + num1 + " y " + num2 + " es: " + (num1 + num2));*/

        // 3. Escribe un programa en Java que determine si un número es par o impar.
        /*int num = 11;

        if (num % 2 == 0) {
            System.out.println("EL numero " + num + " es par");

        } else {
            System.out.println("EL numero " + num + " impar");
        }*/

        // 4. Escribe un programa en Java que calcule el factorial de un número dado.

        /*Scanner objScann = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int num = objScann.nextInt();

        int factorial = 1;

        for(int i = 1; i <= num; i++) {

            factorial *= i;
        }

        System.out.println("El factorial de " + num + " es: " + factorial);*/

        // 5. Escribe un programa en Java que invierta una cadena de texto.
        /*String texto = "Hola";

        StringBuilder cadena = new StringBuilder(texto);

        System.out.println("La cadena '" + texto + "'' invertida es: " + cadena.reverse());*/

        // 6. Escribe un programa en Java que determine si un número es primo.
        /*Scanner objScann = new Scanner(System.in);

        System.out.println("Ingrese un numero: ");
        int num = objScann.nextInt();

        boolean esPrimo = true;

        if (num < 1) {
            esPrimo = false;

        } else {
            for(int i = 2; i <= Math.sqrt(num); i++) {
                esPrimo = false;
                break;
            }
        }

        if (esPrimo) {
            System.out.println("EL numero " + num + " es primo");

        } else {
            System.out.println("EL numero " + num + " no es primo");
        }*/

        // 7. Escribe un programa en Java que genere la serie de Fibonacci hasta un número dado.
        /*int num = 10;

        int a = 0, b = 1;

        System.out.println( a +"  " + b);
        for(int i = 2; i < num; i++) {

            int c = a + b;
            //System.out.println( a +"  " + b);

            System.out.println(a + " " + c  + " " + b);
            a = b;
            b = c;
        }*/

        // 8. Escribe un programa en Java que calcule la media de los elementos de un array.
        /*int[] numeros = {1,2,3,7,78};

        int suma = 0;

        for (int num : numeros) {

            suma += num;
        }

        double media = (double) suma / numeros.length;

        System.out.println("La media de el array es: " + media);*/

        // 9. Escribe un programa en Java que ordene los elementos de un array en orden ascendente.
        /*int[] numeros = {1,8,1,9,6,5,558,45};

        Arrays.sort(numeros);

        System.out.println("Elementos ordenados: " + Arrays.toString(numeros));*/

        // 10. Escribe un programa en Java que multiplique dos matrices.
       /*  int[][] matriz1 = {
            {1,5,8,6},
            {4,7,8,52}
        };

        int[][] matriz2 = {
            {1,5,8,6},
            {4,7,8,52}
        };*/


        // Preguntas Teóricas sobre Programación Orientada a Objetos (POO) en Java

        // Pregunta 1: ¿Qué es la Programación Orientada a Objetos (POO)?
        // b) Un paradigma de programación que utiliza objetos y sus interacciones.

        // Pregunta 2: ¿Qué es una clase en Java?
        // a) Una plantilla o modelo que define un tipo de objeto

        //Pregunta 3: ¿Qué es un objeto en Java?
        // b) Una instancia de una clase.

        // Pregunta 4: ¿Qué es la encapsulación en POO?
        // b) La ocultación de los detalles internos de un objeto y la exposición de solo lo necesario.

        // Pregunta 5: ¿Qué es la herencia en Java?
        // b) La capacidad de una clase de heredar métodos y propiedades de otra clase.

        // Pregunta 6: ¿Qué es el polimorfismo en POO?
        // b) La capacidad de un objeto de tomar muchas formas.

        // Pregunta 7: ¿Qué es una interfaz en Java?
        // b) Un tipo de clase que define métodos que deben ser implementados por las clases que la heredan.

        // Pregunta 8: ¿Qué es la sobrecarga de métodos?
        // b) La creación de múltiples métodos con el mismo nombre pero diferentes parámetros en una clase.

        // Pregunta 9: ¿Qué es un constructor en Java?
        // b) Un método especial que se invoca cuando se crea una instancia de una clase.

        // Pregunta 10: ¿Qué significa que una clase sea abstracta?
        // b) Que no puede ser instanciada directamente y puede contener métodos abstractos.

        // Pregunta 11: ¿Cuál es la diferencia entre una interfaz y una clase abstracta en Java?
        // b) Una clase abstracta puede tener métodos abstractos y concretos, mientras que una interfaz solo puede tener métodos abstractos (en versiones anteriores a Java 8).

        // Pregunta 12: ¿Qué es la sobreescritura de métodos (overriding) en Java?
        // b) La capacidad de una subclase de proporcionar una implementación específica de un método que ya está definido en su superclase.

        // Pregunta 13: ¿Qué es el principio de sustitución de Liskov (LSP)?
        // Era la a) Una subclase debe ser sustituible por su superclase sin alterar el comportamiento correcto del programa.

        // Pregunta 14: ¿Qué es el polimorfismo dinámico en Java?
        // a) La capacidad de una función de tener múltiples formas en tiempo de ejecucion.

        // Pregunta 15: ¿Qué es la inyección de dependencias?
        // b) Un patrón de diseño que permite la creación de dependencias fuera de una clase y proporcionarlas a través del constructor, un método setter, o una interfaz.

        // Pregunta 16: ¿Qué es la serialización en Java?
        // a) El proceso de convertir un objeto en una secuencia de bytes para que pueda ser almacenado o transmitido.

        // Pregunta 17: ¿Cuál es la finalidad del método equals en Java?
        // b) Comparar si dos objetos son iguales en contenido.

        // Pregunta 18: ¿Qué es el patrón de diseño Singleton?
        // Era la a) Un patrón que asegura que una clase solo tenga una instancia y proporciona un punto de acceso global a ella.

        // Pregunta 19: ¿Qué es la reflexión en Java?
        // b) El proceso de obtener información sobre las clases, interfaces, campos y métodos en tiempo de ejecución.

        // Pregunta 20: ¿Qué es una clase anidada en Java?
        // a) Una clase que se define dentro de otra clase y tiene acceso a sus miembros.



    }

}
