// Fig. 1.16: MarcoCuadroCombinado.java
// Objeto JComboBox que muestra una lista de nombres de imágenes.
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoCuadroCombinado extends JFrame{
    private final JComboBox<String> imagenesJComboBox; // contiene los nombres de los iconos
    private final JLabel etiqueta; // muestra el icono seleccionado

    private static final String nombres[] = {
        "ejemplosEventos\\images\\adjunto.png",
        "ejemplosEventos\\images\\adjunto_azul.png",
        "ejemplosEventos\\images\\adjunto_verde.png",
        "ejemplosEventos\\images\\adjunto_rojo.png"
    };
    /*ImageIcon icono1 = new ImageIcon("images/adjunto.png");
    ImageIcon icono1Escala = new ImageIcon(icono1.getImage()
            .getScaledInstance(//ancho 30, //alto(-1 conserva proporcion) -1, java.awt.Image.SCALE_DEFAULT));*/
    private final Icon[] iconos = {
        /*iconoEscala*/
        new ImageIcon(nombres[0]),
        new ImageIcon(nombres[1]),
        new ImageIcon(nombres[2]),
        new ImageIcon(nombres[3])
    };

    // El constructor de MarcoCuadroCombinado agrega un objeto JComboBox a JFrame
    public MarcoCuadroCombinado(){
        super("Prueba de JComboBox");
        setLayout(new FlowLayout()); // establece el esquema del marco

        imagenesJComboBox = new JComboBox<String>(nombres); // establece JComboBox
        imagenesJComboBox.setMaximumRowCount(3); // muestra tres filas

        // clase interna anónima
        imagenesJComboBox.addItemListener(new ItemListener(){
            // maneja evento de JComboBox
            @Override
            public void   itemStateChanged(ItemEvent evento){
                // determina está seleccionado el elemento
                if (evento.getStateChange() == ItemEvent.SELECTED)
                    etiqueta.setIcon(iconos[imagenesJComboBox.getSelectedIndex()]);
            }
        } /* fin de la clase interna anónima*/ ); // fin de la llamada a addItemListener

        add(imagenesJComboBox); // agrega cuadro combinado a JFrame
        etiqueta = new JLabel(iconos[0]); // muestra el primer icono
        add(etiqueta); // agrega etiqueta a JFrame
    }
} // fin de la clase MarcoCuadroCombinado
