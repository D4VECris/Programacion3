package primeraclase;
import java.util.Scanner;
/**
 * Primera clase
 * @author David Cristancho
 * 27/01/2025
 */
public class PrimeraClase {
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);
        
       int edad;
       float estatura;
       String nombre;
       char genero;
       
       System.out.println("Hola mundo");
       System.out.print("Como es tu nombre: ");
       nombre = leer.next();
       System.out.print("Cual es tu edad: ");
       edad = leer.nextInt();
       System.out.print("Cual es tu estatura: ");
       estatura = leer.nextFloat();
       System.out.print("Cual es tu genero (M, F): ");
       genero = leer.next().charAt(0);
       
       System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Estatura: " + ", Genero: " + genero + " ");      
    }
    
}
