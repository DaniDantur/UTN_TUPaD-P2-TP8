package tupad.danieldantur.tp8.ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n1. División segura ---");
            try {
                System.out.print("Ingrese el primer dividendo: ");
                double dividendo = scanner.nextDouble();
    
                System.out.print("Ingrese el segundo divisor: ");
                double divisor = scanner.nextDouble();
    
                double resultado = dividendo / divisor;
                System.out.println("El resultado de la división es: " + resultado);
    
            } catch (ArithmeticException e) {
                System.out.println("Error: No se puede dividir por cero.");
            }
    
            System.out.println("\n2.Conversión de cadena a número ---");
            try {
                System.out.print("Ingrese un número: ");
                String numero = scanner.next();
                int numeroEntero = Integer.parseInt(numero);
                System.out.println("El número es: " + numeroEntero);
            } catch (NumberFormatException e) {
                System.out.println("Error: El valor ingresado no es un número válido.");
            }
    
            System.out.println("\n3. Lectura de archivo ---");
            try (BufferedReader reader = new BufferedReader(new FileReader("archivo.txt"))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: El archivo no fue encontrado.");
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
    
            System.out.println("\n4. Excepción personalizada ---");
            try {
                System.out.print("Ingrese una edad: ");
                int edad = scanner.nextInt();
                if (edad < 0 || edad > 120) {
                    throw new EdadInvalidaException("La edad ingresada (" + edad + ") está fuera del rango permitido (0-120).");
                }
                System.out.println("La edad ingresada es: " + edad);
            } catch (EdadInvalidaException e) {
                System.out.println("Error de edad: " + e.getMessage());
            } 
    
            System.out.println("\n5. Uso de try-with-resources ---");
            try (BufferedReader reader = new BufferedReader(new FileReader("otro_archivo.txt"))) {
                String linea;
                System.out.println("Contenido de 'otro_archivo.txt':");
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }
    }
}
