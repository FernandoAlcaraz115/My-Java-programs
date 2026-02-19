// Archivo: CalculadoraB.java
import javax.swing.JOptionPane;
import libreriaCalculadora.Calculadora;

public class CalculadoraB {
    public static void main(String[] args) {
        // Pedir datos al usuario usando JOptionPane
        String input1 = JOptionPane.showInputDialog(null, "Ingrese el primer número:", "CALCULADORA BÁSICA", JOptionPane.QUESTION_MESSAGE);
        String input2 = JOptionPane.showInputDialog(null, "Ingrese el segundo número:", "CALCULADORA BÁSICA", JOptionPane.QUESTION_MESSAGE);

        try {
            // Convertir las entradas a números
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);

            // Realizar operaciones usando la librería
            StringBuilder resultados = new StringBuilder();
            resultados.append("RESULTADOS:\n");
            resultados.append("Suma: ").append(Calculadora.sumar(num1, num2)).append("\n");
            resultados.append("Resta: ").append(Calculadora.restar(num1, num2)).append("\n");
            resultados.append("Multiplicación: ").append(Calculadora.multiplicar(num1, num2)).append("\n");

            try {
                resultados.append("División: ").append(Calculadora.dividir(num1, num2)).append("\n");
            } catch (ArithmeticException e) {
                resultados.append("División: Error - ").append(e.getMessage()).append("\n");
            }

            // Mostrar los resultados en un cuadro de diálogo
            JOptionPane.showMessageDialog(null, resultados.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            // Manejar errores de formato de número
            JOptionPane.showMessageDialog(null, "Error: Entrada no válida. Por favor, ingrese números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}