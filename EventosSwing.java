import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EventosSwing extends JFrame {

    private JLabel lbl1, lbl2;
    private JTextField txt1, txt2;
    private JTextArea txtArea;
    private JButton btn1, btn2, btn3, btn4, btnRestaurar;

    // Fuentes originales
    private Font fuenteOriginalLbl1;
    private Font fuenteOriginalLbl2;

    public EventosSwing() {

        setTitle("Práctica de Eventos");
        setSize(650, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // ===== JLabel 1 =====
        lbl1 = new JLabel("Label 1");
        lbl1.setBounds(30, 20, 200, 25);
        add(lbl1);

        // Guardar fuente original
        fuenteOriginalLbl1 = lbl1.getFont();

        // Evento JLabel1 → Negrita + tamaño mayor
        lbl1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Font fuenteNueva = new Font(
                        fuenteOriginalLbl1.getName(),
                        Font.BOLD,
                        fuenteOriginalLbl1.getSize() + 3);
                lbl1.setFont(fuenteNueva);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl1.setFont(fuenteOriginalLbl1);
            }
        });

        // ===== JLabel 2 =====
        lbl2 = new JLabel("Label 2");
        lbl2.setBounds(30, 50, 200, 25);
        add(lbl2);

        // Guardar fuente original
        fuenteOriginalLbl2 = lbl2.getFont();

        // Evento JLabel2 → Fuente diferente + Cursiva
        lbl2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {

                // Cambiamos a SansSerif, cursiva, tamaño +2
                Font fuenteNueva = new Font(
                        "SansSerif",
                        Font.ITALIC,
                        fuenteOriginalLbl2.getSize() + 2);

                lbl2.setFont(fuenteNueva);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl2.setFont(fuenteOriginalLbl2);
            }
        });

        // ===== TextFields =====
        txt1 = new JTextField();
        txt1.setBounds(30, 100, 150, 25);
        add(txt1);

        txt2 = new JTextField();
        txt2.setBounds(30, 130, 150, 25);
        add(txt2);

        // ===== TextArea =====
        txtArea = new JTextArea();
        txtArea.setBounds(220, 20, 380, 200);
        add(txtArea);

        // ===== Botones =====
        btn1 = new JButton("Cambia color T.F");
        btn1.setBounds(30, 180, 200, 30);
        add(btn1);

        btn2 = new JButton("Cambia color a todos");
        btn2.setBounds(30, 220, 200, 30);
        add(btn2);

        btn3 = new JButton("Cambia color JLabel");
        btn3.setBounds(30, 260, 200, 30);
        add(btn3);

        btn4 = new JButton("Cambia color T.A y T.F");
        btn4.setBounds(30, 300, 200, 30);
        add(btn4);

        btnRestaurar = new JButton("Restaurar colores");
        btnRestaurar.setBounds(30, 340, 200, 30);
        add(btnRestaurar);

        // ===== Eventos de botones =====
        btn1.addActionListener(e -> {
            txt1.setBackground(Color.YELLOW);
            txt2.setBackground(Color.YELLOW);
        });

        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbl1.setForeground(Color.BLUE);
                lbl2.setForeground(Color.BLUE);
                txt1.setBackground(Color.CYAN);
                txt2.setBackground(Color.CYAN);
                txtArea.setBackground(Color.LIGHT_GRAY);
            }
        });

        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lbl1.setForeground(Color.RED);
                lbl2.setForeground(Color.RED);
            }
        });

        btn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                txtArea.setBackground(Color.PINK);
                txt1.setBackground(Color.WHITE);
                txt2.setBackground(Color.WHITE);
            }
        });

        btnRestaurar.addActionListener(e -> {
            txt1.setBackground(Color.WHITE);
            txt2.setBackground(Color.WHITE);
            txtArea.setBackground(Color.WHITE);

            lbl1.setForeground(Color.BLACK);
            lbl2.setForeground(Color.BLACK);

            lbl1.setFont(fuenteOriginalLbl1);
            lbl2.setFont(fuenteOriginalLbl2);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EventosSwing().setVisible(true);
        });
    }
}