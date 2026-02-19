import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;

public class Calculadora {

    public static void main(String[] args) {
        // Ejecuta el programa en el hilo de despacho de eventos
        EventQueue.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

// Clase que define el marco de la calculadora
class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        // Configura el título del marco
        setTitle("Calculadora");

        // Crea un panel de la calculadora y lo agrega al marco
        CalculatorPanel panel = new CalculatorPanel();
        add(panel);

        // Ajusta el tamaño del marco para que se ajuste al contenido
        pack();

        // Configura el tamaño y la posición del marco en la pantalla
        int width = 350;
        int height = 350;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);
    }
}

// Clase que define el panel de la calculadora
class CalculatorPanel extends JPanel {

    private final JButton display; // Botón que muestra el resultado
    private final JPanel panel; // Panel que contiene los botones de la calculadora
    private BigDecimal result; // Resultado de la operación
    private String lastCommand; // Último comando ingresado
    private boolean start; // Indica si se está iniciando una nueva operación

    public CalculatorPanel() {
        // Configura el diseño del panel
        setLayout(new BorderLayout());

        // Inicializa las variables
        result = BigDecimal.ZERO;
        lastCommand = "=";
        start = true;

        // Configura el botón de visualización del resultado
        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);

        // Crea los oyentes de acción para los botones
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        // Configura el panel de botones de la calculadora
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        // Agrega los botones la interfaz de la calculadora (panel)
        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);
        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);
        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);
        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        // Agrega el panel de botones al panel principal
        add(panel, BorderLayout.CENTER);
    }

    // Método para agregar un botón al panel
    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        panel.add(button);
    }

    // Clase interna para manejar la inserción de números y el punto decimal
    private class InsertAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    } 
    // Clase interna para manejar los comandos de operación
    private class CommandAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else {
                    lastCommand = command;
                }
            } else {
                calculate(new BigDecimal(display.getText()));
                lastCommand = command;
                start = true;
            }
        }
    }

    // Método para realizar los cálculos
    public void calculate(BigDecimal x) {
        switch (lastCommand) {
            case "+":
                result = result.add(x);
                break;
            case "-":
                result = result.subtract(x);
                break;
            case "*":
                result = result.multiply(x);
                break;
            case "/":
                result = result.divide(x);
                break;
            case "=":
                result = x;
                break;
            default:
                break;
        }
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }
        display.setText(result.toString());
    }
}//Fin de la clase Calculadora 