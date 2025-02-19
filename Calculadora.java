import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.*;

public class Calculadora {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CalculatorFrame frame = new CalculatorFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });//Cierre de evento
    }//Cierre de main
}//Cierre de class

class CalculatorFrame extends JFrame {

    public CalculatorFrame() {
        setTitle("Calculadora javadesdecero.es");
        CalculatorPanel panel = new CalculatorPanel();
        Component add = add(panel);
        pack();
        int width = 350;
        int height = 350;
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();
        setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);
    }//Cierre de public
}//cierre de class

class CalculatorPanel extends JPanel {

    private final JButton display;
    private final JPanel panel;
    private BigDecimal result;
    private String lastCommand;
    private boolean start;

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        result = BigDecimal.ZERO;
        lastCommand = "=";
        start = true;
        display = new JButton("0");
        display.setEnabled(false);
        display.setFont(display.getFont().deriveFont(50f));
        add(display, BorderLayout.NORTH);
        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
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
        add(panel, BorderLayout.CENTER);
    }//Cierre de class

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setFont(button.getFont().deriveFont(20f));
        button.addActionListener(listener);
        panel.add(button);
    }//Cierre de void

    private class InsertAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }//Cierre de if
            display.setText(display.getText() + input);
        }//Cierre de void
    }//Cierre de class

    private class CommandAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                }//Cierre de if 
                else {
                    lastCommand = command;
                }//Cierre de else
            } //Cierre de if
            else {
                calculate(new BigDecimal(display.getText()));
                lastCommand = command;
                start = true;
            }//Cierre de else
        }//Cierre de void
    }//Cierre de class
 
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
        }//Cierre de Switch
        if (result.compareTo(BigDecimal.ZERO) == 0) {
            result = BigDecimal.ZERO;
        }//Cierre de if
        display.setText(result.toString());
    }//Cierre de void
}//Cierre de programa
 