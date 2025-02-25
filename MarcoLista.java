//Programa que muestra una lista de colores y cambia el color de fondo del marco según el color seleccionado en la lista.
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
//Inicio de la clase MarcoLista
public class MarcoLista extends JFrame {
    private final JList<String> listaJListColores; //Lista para mostrar los colores disponibles 
    private static final String[] nombresColores = {"Negro", "Azul", "Cyan",
        "Gris oscuro", "Gris", "Verde", "Gris claro", "Magenta",
        "Naranja", "Rosa", "Rojo", "Blanco", "Amarillo"};
    private static final Color[] colores = {Color.BLACK, Color.BLUE,
        Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
        Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
        Color.RED, Color.WHITE, Color.YELLOW};

    // El constructor de MarcoLista agrega a JFrame el JScrollPane que contiene a JList
    public MarcoLista() {
        super("Prueba de JList");
        setLayout(new FlowLayout());

        listaJListColores = new JList<String>(nombresColores); // Lista con los nombres de los colores 
        listaJListColores.setVisibleRowCount(5); // muestra cinco filas a la vez

        // no permite selecciones múltiples
        listaJListColores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // agrega al marco un objeto JScrollPane que contiene a JList
        add(new JScrollPane(listaJListColores));

        listaJListColores.addListSelectionListener(new ListSelectionListener() { // clase interna anónima
            // maneja los eventos de selección de la lista
            @Override
            public void valueChanged(ListSelectionEvent evento) {
                getContentPane().setBackground(colores[listaJListColores.getSelectedIndex()]);
            }
        });
    }

    public static void main(String[] args) {
        MarcoLista marcoLista = new MarcoLista();
        marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoLista.setSize(720, 400); // establece el tamaño del marco
        marcoLista.setVisible(true); // muestra el marco
    }
} //Fin de la clase MarcoLista
