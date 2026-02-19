//Ejercicio 2
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Examen2P extends JFrame {
    private final JRadioButton opcionMalo;      // Botón de opción "Malo"
    private final JRadioButton opcionRegular;  // Botón de opción "Regular"
    private final JRadioButton opcionExcelente; // Botón de opción "Excelente"
    private final JButton botonEnviar;       // Botón para enviar la opinión
    private final ButtonGroup grupoOpciones;   // Grupo de botones de opción

    public Examen2P() {
        super("Encuesta de Satisfacción");
        setLayout(new FlowLayout());

        // Etiqueta para la encuesta
        JLabel etiqueta = new JLabel("¿Cómo calificaría nuestro servicio?");
        add(etiqueta);

        // Crear botones de opción
        opcionMalo = new JRadioButton("Malo");
        opcionRegular = new JRadioButton("Regular");
        opcionExcelente = new JRadioButton("Excelente");

        // Agregar los botones de opción al grupo
        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(opcionMalo);
        grupoOpciones.add(opcionRegular);
        grupoOpciones.add(opcionExcelente);

        // Agregar los botones de opción al marco
        add(opcionMalo);
        add(opcionRegular);
        add(opcionExcelente);

        // Botón para enviar la opinión
        botonEnviar = new JButton("Enviar Opinión");
        add(botonEnviar);

        // Manejador de eventos para el botón "Enviar Opinión"
        botonEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String seleccion = null;

                // Verificar cuál botón de opción está seleccionado
                if (opcionMalo.isSelected()) {
                    seleccion = "Malo";
                } else if (opcionRegular.isSelected()) {
                    seleccion = "Regular";
                } else if (opcionExcelente.isSelected()) {
                    seleccion = "Excelente";
                }

                // Mostrar un cuadro de diálogo con la opción seleccionada
                if (seleccion != null) {
                    JOptionPane.showMessageDialog(
                        Examen2P.this,
                        "Usted seleccionó: " + seleccion,
                        "Opinión Enviada",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        Examen2P.this,
                        "Por favor, seleccione una opción antes de enviar.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    // Método principal
    public static void main(String[] args) {
        // Crear y mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            Examen2P ventana = new Examen2P();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(300, 200); // Tamaño de la ventana
            ventana.setVisible(true); // Mostrar la ventana
        });
    }
}