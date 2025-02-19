import java.util.Scanner;

public class LinealCongruencialGenerador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese los parámetros
        System.out.println("Ingrese el valor de la semilla (X0): ");
        long seed = scanner.nextLong();

        System.out.println("Ingrese el valor del multiplicador (a): ");
        long a = scanner.nextLong();

        System.out.println("Ingrese el valor del incremento (c): ");
        long c = scanner.nextLong();

        System.out.println("Ingrese el valor del módulo (m): ");
        long m = scanner.nextLong();

        System.out.println("¿Cuántos números pseudoaleatorios desea generar?: ");
        int cantidadNumeros = scanner.nextInt();

        // Generar y mostrar los números pseudoaleatorios
        System.out.println("\nNúmeros Pseudoaleatorios Generados:");
        for (int i = 0; i < cantidadNumeros; i++) {
            seed = (a * seed + c) % m;  // Fórmula del método congruencial lineal
            System.out.println((i + 1) + ": 0." + seed);
        }

        // Cerrar el scanner
        scanner.close();
    }
}
