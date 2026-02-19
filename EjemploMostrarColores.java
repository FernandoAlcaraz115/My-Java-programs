// Fig. 2.27: EjemploMostrarColores.java
// Demostración de objetos Color.
import javax.swing.JFrame;

public class EjemploMostrarColores {
    // ejecuta la aplicación
    public static void main(String[] args){
        // crea marco para objeto JPanelColor
        JFrame frame = new JFrame("Uso de colores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        AppJPanelColor jPanelColor = new AppJPanelColor();
        frame.add(jPanelColor);
        frame.setSize(400, 180);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
} // fin de la clase MostrarColores
