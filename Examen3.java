//Ejercicio3
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Examen3 extends JFrame {
    private final JCheckBox wifiCheckBox;        
    private final JCheckBox desayunoCheckBox;    
    private final JCheckBox estacionamientoCheckBox;
    private final JButton confirmarButton;       
    public Examen3() {
        super("Selección de Servicios");
        setLayout(new FlowLayout());

        
        JLabel etiqueta = new JLabel("Seleccione los servicios adicionales:");
        add(etiqueta);

        // Crear casillas de verificación
        wifiCheckBox = new JCheckBox("Wi-Fi");
        desayunoCheckBox = new JCheckBox("Desayuno");
        estacionamientoCheckBox = new JCheckBox("Estacionamiento");

        // Agregar las casillas de verificación al marco
        add(wifiCheckBox);
        add(desayunoCheckBox);
        add(estacionamientoCheckBox);

        // Botón para confirmar los servicios seleccionados
        confirmarButton = new JButton("Confirmar Servicios");
        add(confirmarButton);

        // Manejador de eventos para el botón "Confirmar Servicios"
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                StringBuilder serviciosSeleccionados = new StringBuilder("Servicios seleccionados:\n");

                // Verificar cuáles casillas están seleccionadas
                if (wifiCheckBox.isSelected()) {
                    serviciosSeleccionados.append("- Wi-Fi\n");
                }
                if (desayunoCheckBox.isSelected()) {
                    serviciosSeleccionados.append("- Desayuno\n");
                }
                if (estacionamientoCheckBox.isSelected()) {
                    serviciosSeleccionados.append("- Estacionamiento\n");
                }

                // Mostrar un cuadro de diálogo con los servicios seleccionados
                if (serviciosSeleccionados.toString().equals("Servicios seleccionados:\n")) {
                    JOptionPane.showMessageDialog(
                        Examen3.this,
                        "No se seleccionó ningún servicio.",
                        "Sin Selección",
                        JOptionPane.WARNING_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        Examen3.this,
                        serviciosSeleccionados.toString(),
                        "Confirmación de Servicios",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });
    }

    // Método principal
    public static void main(String[] args) {
        //Mostrar Ventana
        SwingUtilities.invokeLater(() -> {
            Examen3 ventana = new Examen3();
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(300, 200); // Tamaño de la ventana
            ventana.setVisible(true); // Mostrar la ventana
        });
    }
}
