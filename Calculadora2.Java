import javax.swing.JOptionPane;

public class CalculadoraPropinas {
    public static void main(String[] args) {
        while (true) {
            // Mostrar el menú de opciones de propina
            String[] opciones = {"Propina 10%", "Propina 5%", "Propina 20%", "Otra propina", "Salir"};
            String opcion = (String) JOptionPane.showInputDialog(
                null, 
                "Selecciona una opción", 
                "Calculadora de Propinas", 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                opciones, 
                opciones[0]
            );

            // Validar que se haya seleccionado una opción
            if (opcion == null || opcion.equals("Salir")) {
                JOptionPane.showMessageDialog(
                    null, 
                    "Saliendo de la calculadora de propinas.", 
                    "Salir", 
                    JOptionPane.INFORMATION_MESSAGE
                );
                break;
            }

            // Pedir el monto total de consumo y validar la entrada
            double monto = 0;
            while (true) {
                String inputMonto = JOptionPane.showInputDialog(
                    null, 
                    "Ingresa el monto total de consumo", 
                    "Entrada de Datos", 
                    JOptionPane.QUESTION_MESSAGE
                );
                try {
                    monto = Double.parseDouble(inputMonto);
                    if (monto >= 0) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(
                            null, 
                            "El monto debe ser un número positivo.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                    //En dado caso de que la entrada sea un numero negativo, se le notificara al usuario
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                        null, 
                        "Entrada no válida. Por favor, ingresa un número.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }

            // Determinar el porcentaje de propina
            double porcentaje = 0;
            switch (opcion) {
                case "Propina 10%":
                    porcentaje = 10;
                    break;
                case "Propina 5%":
                    porcentaje = 5;
                    break;
                case "Propina 20%":
                    porcentaje = 20;
                    break;
                case "Otra propina":
                    while (true) {
                        String inputPorcentaje = JOptionPane.showInputDialog(
                            null, 
                            "Ingresa el porcentaje de propina", 
                            "Entrada de Datos", 
                            JOptionPane.QUESTION_MESSAGE
                        );
                        try {
                            porcentaje = Double.parseDouble(inputPorcentaje);
                            if (porcentaje >= 0) {
                                break;
                            } else {
                                JOptionPane.showMessageDialog(
                                    null, 
                                    "El porcentaje debe ser un número positivo.", 
                                    "Error", 
                                    JOptionPane.ERROR_MESSAGE
                                );
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(
                                null, 
                                "Entrada no válida. Por favor, ingresa un número.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE
                            );
                        }
                    }
                    break;
            }

            // Calcular el monto de la propina y el total a pagar
            double propina = monto * (porcentaje / 100);
            double total = monto + propina;

            // Mostrar el resultado
            JOptionPane.showMessageDialog(
                null, 
                "Resumen de la Propina\n" +
                "---------------------\n" +
                "Monto de consumo: $" + String.format("%.2f", monto) + "\n" +
                "Porcentaje de propina: " + porcentaje + "%\n" +
                "Monto de la propina: $" + String.format("%.2f", propina) + "\n" +
                "Total a pagar: $" + String.format("%.2f", total), 
                "Resultado", 
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
}