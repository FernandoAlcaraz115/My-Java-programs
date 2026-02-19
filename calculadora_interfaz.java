import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calculadora_interfaz extends JFrame implements ActionListener {
    // Componentes de la interfaz
    private JTextField pantalla;
    private JButton[] botonesNumeros;
    private JButton[] botonesOperaciones;
    private JButton botonIgual, botonLimpiar;

    // Variables para almacenar los números y la operación
    private double num1 = 0, num2 = 0, resultado = 0;
    private String operacion = "";

    public calculadora_interfaz() {
        // Configuración de la ventana
        setTitle("Calculadora Básica");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear la pantalla
        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.PLAIN, 24));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        add(pantalla, BorderLayout.NORTH);

        // Crear el panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 10, 10));

        // Crear los botones de números (0-9)
        botonesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            botonesNumeros[i].setFont(new Font("Arial", Font.PLAIN, 18));
            botonesNumeros[i].addActionListener(this);
            panelBotones.add(botonesNumeros[i]);
        }

        // Crear los botones de operaciones
        String[] operaciones = {"+", "-", "*", "/"};
        botonesOperaciones = new JButton[operaciones.length];
        for (int i = 0; i < operaciones.length; i++) {
            botonesOperaciones[i] = new JButton(operaciones[i]);
            botonesOperaciones[i].setFont(new Font("Arial", Font.PLAIN, 18));
            botonesOperaciones[i].addActionListener(this);
            panelBotones.add(botonesOperaciones[i]);
        }

        // Crear el botón de igual
        botonIgual = new JButton("=");
        botonIgual.setFont(new Font("Arial", Font.PLAIN, 18));
        botonIgual.addActionListener(this);
        panelBotones.add(botonIgual);

        // Crear el botón de limpiar
        botonLimpiar = new JButton("C");
        botonLimpiar.setFont(new Font("Arial", Font.PLAIN, 18));
        botonLimpiar.addActionListener(this);
        panelBotones.add(botonLimpiar);

        // Agregar el panel de botones a la ventana
        add(panelBotones, BorderLayout.CENTER);

        // Mostrar la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String textoBoton = e.getActionCommand();

        // Si es un número, agregarlo a la pantalla
        if (textoBoton.matches("[0-9]")) {
            pantalla.setText(pantalla.getText() + textoBoton);
        }
        // Si es una operación, guardar el primer número y la operación
        else if (textoBoton.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = textoBoton;
            pantalla.setText("");
        }
        // Si es el botón de igual, calcular el resultado
        else if (textoBoton.equals("=")) {
            num2 = Double.parseDouble(pantalla.getText());
            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        pantalla.setText("Error");
                        return;
                    }
                    break;
            }
            pantalla.setText(String.valueOf(resultado));
        }
        // Si es el botón de limpiar, reiniciar todo
        else if (textoBoton.equals("C")) {
            pantalla.setText("");
            num1 = 0;
            num2 = 0;
            resultado = 0;
            operacion = "";
        }
    }

    public static void main(String[] args) {
        new calculadora_interfaz();
    }
}