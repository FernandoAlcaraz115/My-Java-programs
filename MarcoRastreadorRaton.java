// Fig. 1.24: MarcoRastreadorRaton.java
// Manejo de eventos de ratón.
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MarcoRastreadorRaton extends JFrame{
    private final JPanel panelRaton; // panel en el que ocurrirán los eventos de ratón
    private final JLabel barraEstado; // muestra información de los eventos

    // El constructor de MarcoRastreadorRaton establece la GUI y
    // registra los manejadores de eventos de ratón
    public MarcoRastreadorRaton(){
        super("Demostracion de los eventos de raton");

        panelRaton = new JPanel();
        panelRaton.setBackground(Color.WHITE);
        add(panelRaton, BorderLayout.CENTER); // agrega el panel a JFrame

        barraEstado = new JLabel("Raton fuera de JPanel");
        add(barraEstado, BorderLayout.SOUTH); // agrega etiqueta a JFrame

        // crea y registra un componente de escucha para los eventos de ratón y de su movimiento
        ManejadorRaton manejador = new ManejadorRaton();
        panelRaton.addMouseListener(manejador);
        panelRaton.addMouseMotionListener(manejador);
    }

    private class ManejadorRaton implements MouseListener, MouseMotionListener{
        // Los manejadores de eventos de MouseListener
        // maneja el evento cuando se suelta el ratón justo después de oprimir el botón
        @Override
        public void mouseClicked(MouseEvent evento){
            barraEstado.setText(String.format("Se hizo clic en [%d, %d]",evento.getX(), evento.getY()));
        }

        // maneja evento cuando se oprime el ratón
        @Override
        public void mousePressed(MouseEvent evento){
            barraEstado.setText(String.format("Se oprimio en [%d, %d]",evento.getX(), evento.getY()));
        }

        // maneja evento cuando se suelta el botón del ratón
        @Override
        public void mouseReleased(MouseEvent evento){
            barraEstado.setText(String.format("Se solto en [%d, %d]",evento.getX(), evento.getY()));
        }

        // maneja evento cuando el ratón entra al área
        @Override
        public void mouseEntered(MouseEvent evento){
            barraEstado.setText(String.format("Raton entro en [%d, %d]",evento.getX(), evento.getY()));
            panelRaton.setBackground(Color.GREEN);
        }

        // maneja evento cuando el ratón sale del área
        @Override
        public void mouseExited(MouseEvent evento){
            barraEstado.setText("Raton fuera de JPanel");
            panelRaton.setBackground(Color.WHITE);
        }

        // Los manejadores de eventos de MouseMotionListener manejan
        // el evento cuando el usuario arrastra el ratón con el botón oprimido
        @Override
        public void mouseDragged(MouseEvent evento){
            barraEstado.setText(String.format("Se arrastro en [%d, %d]",evento.getX(), evento.getY()));
        }

        // maneja evento cuando el usuario mueve el ratón
        @Override
        public void mouseMoved(MouseEvent evento){
            barraEstado.setText(String.format("Se movio en [%d, %d]",evento.getX(), evento.getY()));
        }
    } // fin de la clase interna ManejadorRaton
} // fin de la clase MarcoRastreadorRaton
