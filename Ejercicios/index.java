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

        int[] numeros = {1,8,1,9,6,5,558,45};

        Arrays.sort(numeros);

        System.out.println("Elementos ordenados: " + Arrays.toString(numeros));


    }

}
