import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class HelloWorld {
    public static void main(String[] args) {
        // Configurar el color de fondo del cuadro de diálogo
        UIManager.put("Panel.background", new ColorUIResource(255, 255, 255));

        // Mostrar un cuadro de diálogo con un mensaje de bienvenida
        JOptionPane.showMessageDialog(
            null, 
            "Bienvenido al programa", 
            "Mensaje de Bienvenida", 
            JOptionPane.INFORMATION_MESSAGE
        );

        // Preguntar el nombre del usuario
        String nombre = JOptionPane.showInputDialog(
            null, 
            "¿Cuál es tu nombre?", 
            "Pregunta de Nombre", 
            JOptionPane.QUESTION_MESSAGE
        );

        // Preguntar la edad del usuario
        String edad = JOptionPane.showInputDialog(
            null, 
            "¿Cuál es tu edad?", 
            "Pregunta de Edad", 
            JOptionPane.QUESTION_MESSAGE
        );

        // Mostrar el nombre y la edad ingresados por el usuario
        JOptionPane.showMessageDialog(
            null, 
            "Hola, " + nombre + ". Tienes " + edad + " años.", 
            "Datos del Usuario", 
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}