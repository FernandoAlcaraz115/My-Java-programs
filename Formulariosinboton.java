import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulariosinboton extends JFrame {
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtNombres;
    private JTextField txtEdad;
    private JTextField txtCurp;
    private JTextField txtRfc;
    
    // Ingreso de los datos del formulario
    public Formulariosinboton() {
        setTitle("Formulario de Datos Personales");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Crear y agregar componentes al formulario
        add(new JLabel("Apellido Paterno:"));
        txtApellidoPaterno = new JTextField();
        add(txtApellidoPaterno);

        add(new JLabel("Apellido Materno:"));
        txtApellidoMaterno = new JTextField();
        add(txtApellidoMaterno);

        add(new JLabel("Nombres:"));
        txtNombres = new JTextField();
        add(txtNombres);

        add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        add(txtEdad);

        add(new JLabel("CURP:"));
        txtCurp = new JTextField();
        add(txtCurp);

        add(new JLabel("RFC:"));
        txtRfc = new JTextField();
        add(txtRfc);

        // Agregar ActionListener a los campos de texto para que funcione al presionar Enter
        ActionListener enviarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        };

        txtApellidoPaterno.addActionListener(enviarListener);
        txtApellidoMaterno.addActionListener(enviarListener);
        txtNombres.addActionListener(enviarListener);
        txtEdad.addActionListener(enviarListener);
        txtCurp.addActionListener(enviarListener);
        txtRfc.addActionListener(enviarListener);
    }

    // Impresión de los datos del formulario
    private void enviarDatos() {
        try {
            String apellidoPaterno = txtApellidoPaterno.getText();
            String apellidoMaterno = txtApellidoMaterno.getText();
            String nombres = txtNombres.getText();
            String edadStr = txtEdad.getText();
            String curp = txtCurp.getText();
            String rfc = txtRfc.getText();

            // Verificar si todos los campos del formulario están llenos
            if (apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || nombres.isEmpty() || edadStr.isEmpty() || curp.isEmpty() || rfc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, llena todos los campos del formulario.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int edad = Integer.parseInt(edadStr);

            if (edad < 18) {
                JOptionPane.showMessageDialog(this, "Solo los mayores de edad pueden llenar el formulario.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String mensaje = String.format(
                "Ficha Informativa:\n\nApellido Paterno: %s\nApellido Materno: %s\nNombres: %s\nEdad: %d\nCURP: %s\nRFC: %s",
                apellidoPaterno, apellidoMaterno, nombres, edad, curp, rfc
            );

            JOptionPane.showMessageDialog(this, mensaje, "Ficha informativa", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulariosinboton().setVisible(true);
            }
        });
    }
}