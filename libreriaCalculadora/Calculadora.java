// Archivo: libreriaCalculadora/Calculadora.java
package libreriaCalculadora;

public class Calculadora {
    
    // Suma de dos números
    public static double sumar(double a, double b) {
        return a + b;
    }
    
    // Resta de dos números
    public static double restar(double a, double b) {
        return a - b;
    }
    
    // Multiplica de dos números
    public static double multiplicar(double a, double b) {
        return a * b;
    }
    
    // Divide de dos números
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return a / b;
    }
}
