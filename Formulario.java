import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {
    private JTextField txtApellidoPaterno;
    private JTextField txtApellidoMaterno;
    private JTextField txtNombres;
    private JTextField txtEdad;
    private JTextField txtCurp;
    private JTextField txtRfc;

    public Formulario() {
        setTitle("Formulario de Datos Personales");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        // Agregar los datos al formulario
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

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enviarDatos();
            }
        });
        add(btnEnviar);
    }

    // Imprimir datos
    private void enviarDatos() {
        try {
            String apellidoPaterno = txtApellidoPaterno.getText();
            String apellidoMaterno = txtApellidoMaterno.getText();
            String nombres = txtNombres.getText();
            String edadStr = txtEdad.getText();
            String curp = txtCurp.getText();
            String rfc = txtRfc.getText();

            // Verificar si todos los campos están llenos
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

            JOptionPane.showMessageDialog(this, mensaje, "Ficha Informativa", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa una edad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }
}