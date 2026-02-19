import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class U1P2_TiposEventos extends JFrame {

    public U1P2_TiposEventos() {

        setTitle("Eventos con Colores");
        setSize(500, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BOTÓN 1 - ActionListener
        JButton btnAccion = new JButton("Acción");
        btnAccion.addActionListener(e -> getContentPane().setBackground(Color.RED));

        // BOTÓN 2 - MouseListener
        JButton btnMouse = new JButton("Mouse");
        btnMouse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getContentPane().setBackground(Color.BLUE);
            }
        });

        // BOTÓN 3 - FocusListener
        JButton btnFoco = new JButton("Foco");
        btnFoco.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent e) {
                getContentPane().setBackground(Color.WHITE);
            }
        });

        // BOTÓN 4 - ChangeListener (JToggleButton)
        JToggleButton btnEstado = new JToggleButton("Estado");
        btnEstado.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (btnEstado.isSelected()) {
                    getContentPane().setBackground(Color.ORANGE);
                } else {
                    getContentPane().setBackground(Color.WHITE);
                }
            }
        });

        // BOTÓN 5 - ItemListener (JCheckBox)
        JCheckBox checkColor = new JCheckBox("Color");
        checkColor.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                getContentPane().setBackground(Color.MAGENTA);
            } else {
                getContentPane().setBackground(Color.WHITE);
            }
        });

        // Agregar componentes
        add(btnAccion);
        add(btnMouse);
        add(btnFoco);
        add(btnEstado);
        add(checkColor);

        setVisible(true);
    }

    public static void main(String[] args) {
        new U1P2_TiposEventos();
    }
}
