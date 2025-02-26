import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MarcoSeleccionMultiple2 extends JFrame {
    private final JList<String> listaJListColores; // lista para guardar los nombres de los colores
    private final JList<String> listaJListCopia; // lista en la que se van a copiar los nombres seleccionados
    private final JButton botonJButtonCopiar; // botón para copiar los nombres seleccionados
    private static final String[] nombresColores = {"Negro", "Azul", "Cyan",
        "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta", "Naranja",
        "Rosa", "Rojo", "Blanco", "Amarillo"};
    private final DefaultListModel<String> modeloListaCopia; // modelo para la lista de copias

    // Constructor de MarcoSeleccionMultiple2
    public MarcoSeleccionMultiple2() {
        super("Listas de seleccion multiple");
        setLayout(new FlowLayout());

        listaJListColores = new JList<>(nombresColores); // lista de nombres de colores
        listaJListColores.setVisibleRowCount(5); // muestra cinco filas
        listaJListColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListColores)); // agrega lista con panel de desplazamiento

        botonJButtonCopiar = new JButton("Copiar >>>");
        botonJButtonCopiar.addActionListener(
            new ActionListener() {
                // maneja evento de botón
                @Override
                public void actionPerformed(ActionEvent evento) {
                    // agrega los valores seleccionados al modelo de lista de copias
                    for (String valor : listaJListColores.getSelectedValuesList()) {
                        modeloListaCopia.addElement(valor);
                    }
                }
            }
        );

        add(botonJButtonCopiar); // agrega el botón copiar a JFrame

        modeloListaCopia = new DefaultListModel<>(); // modelo para la lista de copias
        listaJListCopia = new JList<>(modeloListaCopia); // lista para guardar nombres de colores copiados
        listaJListCopia.setVisibleRowCount(5); // muestra 5 filas
        listaJListCopia.setFixedCellWidth(100); // establece la anchura
        listaJListCopia.setFixedCellHeight(15); // establece la altura
        listaJListCopia.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaJListCopia)); // agrega lista con panel de desplazamiento
    }

    public static void main(String[] args) {
        MarcoSeleccionMultiple2 marcoSeleccionMultiple = new MarcoSeleccionMultiple2();
        marcoSeleccionMultiple.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoSeleccionMultiple.setSize(350, 150); // establece el tamaño del marco
        marcoSeleccionMultiple.setVisible(true); // muestra el marco
    }
} // fin de la clase MarcoSeleccionMultiple2