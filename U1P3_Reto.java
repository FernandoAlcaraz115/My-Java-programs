
// Importa todas las clases de Swing (JFrame, JButton, JLabel, etc.)
import javax.swing.*;

// Importa clases de AWT (Color, Layouts, etc.)
import java.awt.*;

// Importa las clases para manejar eventos (ActionListener, ActionEvent)
import java.awt.event.*;

public class U1P3_Reto {

    // Método principal: punto de entrada del programa
    public static void main(String[] args) {

        // Crea una ventana (JFrame) con un título
        JFrame ventana = new JFrame("Ejemplo GUI en Java");

        // Define el tamaño de la ventana (ancho, alto)
        ventana.setSize(400, 200);

        // Indica que el programa termine cuando se cierre la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establece el diseño de la ventana (FlowLayout: componentes en fila)
        ventana.setLayout(new FlowLayout());

        // Crea una etiqueta de texto
        JLabel etiqueta = new JLabel("Presiona el botón");

        // Crea un botón con texto
        JButton boton = new JButton("Haz clic aquí");

        // Se agrega un ActionListener al botón
        // ActionListener detecta cuando el botón es presionado
        boton.addActionListener(new ActionListener() {

            // Método obligatorio que se ejecuta al hacer clic
            @Override
            public void actionPerformed(ActionEvent e) {

                // Cambia el texto de la etiqueta
                etiqueta.setText("¡Has presionado el botón!");

                // Cambia el color del fondo de la ventana
                ventana.getContentPane().setBackground(Color.CYAN);
            }
        });

        // Agrega la etiqueta a la ventana
        ventana.add(etiqueta);

        // Agrega el botón a la ventana
        ventana.add(boton);

        // Hace visible la ventana en pantalla
        ventana.setVisible(true);
    }
}