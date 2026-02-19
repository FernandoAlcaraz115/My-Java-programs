import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * Clase principal que crea una ventana con múltiples eventos
 * en JLabel, JTextField, JTextArea y JButton.
 */
public class U1_Examen extends JFrame {

    // Fuente inicial para todos los componentes
    private Font fuenteInicial;

    // Declaración global de componentes
    private JLabel lblNombre, lblApellido, lblSemestre, lblMatricula, lblEdad;
    private JTextField txtNombre, txtApellido, txtSemestre, txtMatricula, txtEdad;
    private JTextArea areaClick, areaSalir, areaTerminar;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btnRestaurar;

    // Constructor
    public U1_Examen() {

        setTitle("Fernando Isai Alcaraz Méndez");
        setSize(950, 700);
        setLayout(null); // Layout absoluto
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Fuente inicial: Monospaced, Bold, tamaño 13
        fuenteInicial = new Font("Monospaced", Font.BOLD, 13);

        // ==============================
        // CREACIÓN DE LABELS (Textos)
        // ==============================

        lblNombre = crearLabel("Nombre:", 50, 100);
        lblApellido = crearLabel("Apellido:", 50, 140);
        lblSemestre = crearLabel("Semestre:", 50, 180);
        lblMatricula = crearLabel("Matricula:", 50, 220);
        lblEdad = crearLabel("Edad:", 50, 260);

        // ==============================
        // CREACIÓN DE TEXTFIELDS
        // ==============================

        txtNombre = crearTextField(150, 100);
        txtApellido = crearTextField(150, 140);
        txtSemestre = crearTextField(150, 180);
        txtMatricula = crearTextField(150, 220);
        txtEdad = crearTextField(150, 260);

        // Evento: MouseListener (mouseEntered / mouseExited)
        // Cambian de color al pasar el mouse
        eventoColor(txtNombre, Color.RED);
        eventoColor(txtApellido, Color.YELLOW);
        eventoColor(txtSemestre, new Color(0, 128, 0));
        eventoColor(txtMatricula, new Color(0, 0, 139));
        eventoColor(txtEdad, new Color(128, 0, 128));

        // ==============================
        // EVENTOS EN LABELS
        // ==============================

        // Evento: MouseListener (mouseEntered / mouseExited)
        // Cambian fuente y tamaño a 15 al pasar el mouse
        eventoFuente(lblNombre);
        eventoFuente(lblApellido);

        // Evento: MouseListener (mousePressed / mouseReleased)
        // Cambian color al presionar
        eventoColorLabel(lblSemestre);
        eventoColorLabel(lblMatricula);
        eventoColorLabel(lblEdad);

        // ==============================
        // CREACIÓN DE TEXTAREAS
        // ==============================

        areaClick = crearArea(500, 100);
        areaSalir = crearArea(500, 250);
        areaTerminar = crearArea(500, 400);

        // Evento: MouseListener (mouseClicked)
        // Cambia a negro al hacer click
        areaClick.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                areaClick.setBackground(Color.BLACK);
            }
        });

        // Evento: MouseListener (mouseExited)
        // Cambia a morado al salir del área
        areaSalir.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                areaSalir.setBackground(Color.pink);
            }
        });

        // Evento: MouseListener (mouseReleased)
        // Cambia a azul oscuro al terminar de presionar
        areaTerminar.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                areaTerminar.setBackground(Color.blue);
            }
        });

        // ==============================
        // CREACIÓN DE BOTONES
        // ==============================

        btn1 = crearBoton("Boton 1", 150, 450);
        btn2 = crearBoton("Boton 2", 270, 450);
        btn3 = crearBoton("Boton 3", 390, 450);
        btn4 = crearBoton("Boton 4", 150, 520);
        btn5 = crearBoton("Boton 5", 270, 520);
        btn6 = crearBoton("Boton 6", 390, 520);

        btnRestaurar = crearBoton("Restaurar", 270, 600);

        // Botón 1
        // Evento: MouseListener (mousePressed)
        btn1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                btn1.setBackground(Color.RED);
            }
        });

        // Botón 2
        // Evento: ActionListener (click tradicional)
        btn2.addActionListener(e -> btn2.setBackground(Color.GREEN));

        // Botón 3
        // Evento: MouseListener (mouseExited)
        btn3.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                btn3.setBackground(Color.PINK);
            }
        });

        // Botón 4
        // Evento: MouseListener (mouseReleased)
        btn4.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                btn4.setBackground(Color.YELLOW);
            }
        });

        // Botón 5
        // Evento: ActionListener (click)
        btn5.addActionListener(e -> btn5.setBackground(Color.ORANGE));

        // Botón 6
        // Evento: MouseListener (mouseEntered)
        btn6.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                btn6.setBackground(Color.CYAN);
            }
        });

        // Botón Restaurar
        // Evento: ActionListener
        btnRestaurar.addActionListener(e -> restaurarTodo());

        setVisible(true);
    }

    // ==============================
    // MÉTODOS AUXILIARES
    // ==============================

    // Crea un JLabel con fuente inicial
    private JLabel crearLabel(String texto, int x, int y) {
        JLabel lbl = new JLabel(texto);
        lbl.setBounds(x, y, 120, 30);
        lbl.setFont(fuenteInicial);
        add(lbl);
        return lbl;
    }

    // Crea un JTextField con fuente inicial
    private JTextField crearTextField(int x, int y) {
        JTextField txt = new JTextField();
        txt.setBounds(x, y, 200, 30);
        txt.setFont(fuenteInicial);
        add(txt);
        return txt;
    }

    // Crea un JTextArea
    private JTextArea crearArea(int x, int y) {
        JTextArea area = new JTextArea();
        area.setBounds(x, y, 300, 100);
        add(area);
        return area;
    }

    // Crea un JButton
    private JButton crearBoton(String texto, int x, int y) {
        JButton btn = new JButton(texto);
        btn.setBounds(x, y, 120, 40);
        add(btn);
        return btn;
    }

    // Evento MouseListener:
    // Cambia color al pasar el mouse
    private void eventoColor(JTextField txt, Color color) {
        txt.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                txt.setBackground(color);
            }

            public void mouseExited(MouseEvent e) {
                txt.setBackground(Color.WHITE);
            }
        });
    }

    // Evento MouseListener:
    // Cambia fuente y tamaño al pasar el mouse
    private void eventoFuente(JLabel lbl) {
        lbl.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                lbl.setFont(new Font("Serif", Font.ITALIC, 15));
            }

            public void mouseExited(MouseEvent e) {
                lbl.setFont(fuenteInicial);
            }
        });
    }

    // Evento MouseListener:
    // Cambia color al presionar
    private void eventoColorLabel(JLabel lbl) {
        lbl.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lbl.setForeground(Color.BLUE);
            }

            public void mouseReleased(MouseEvent e) {
                lbl.setForeground(Color.BLACK);
            }
        });
    }

    // Método que restaura todos los componentes a su estado original
    private void restaurarTodo() {

        // Restaurar TextFields
        txtNombre.setBackground(Color.WHITE);
        txtApellido.setBackground(Color.WHITE);
        txtSemestre.setBackground(Color.WHITE);
        txtMatricula.setBackground(Color.WHITE);
        txtEdad.setBackground(Color.WHITE);

        // Restaurar TextAreas
        areaClick.setBackground(Color.WHITE);
        areaSalir.setBackground(Color.WHITE);
        areaTerminar.setBackground(Color.WHITE);

        // Restaurar Labels
        lblNombre.setFont(fuenteInicial);
        lblApellido.setFont(fuenteInicial);
        lblSemestre.setForeground(Color.BLACK);
        lblMatricula.setForeground(Color.BLACK);
        lblEdad.setForeground(Color.BLACK);

        // Restaurar Botones
        btn1.setBackground(null);
        btn2.setBackground(null);
        btn3.setBackground(null);
        btn4.setBackground(null);
        btn5.setBackground(null);
        btn6.setBackground(null);
    }

    // Método principal
    public static void main(String[] args) {
        new U1_Examen();
    }
}