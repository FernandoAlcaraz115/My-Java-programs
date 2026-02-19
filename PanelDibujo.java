// Fig. 1.30: PanelDibujo.java
// Clase adaptadora que se usa para implementar manejadores de eventos.
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelDibujo extends JPanel{
    // lista de referencias Point
    private final ArrayList<Point> puntos = new ArrayList<>();

    // establece la GUI y registra el manejador de eventos del ratón
    public PanelDibujo(){
        // maneja evento de movimiento del ratón en el marco
        addMouseMotionListener(new MouseMotionAdapter(){ // clase interna anónima
            // almacena las coordenadas de arrastre y vuelve a dibujar
            @Override
            public void mouseDragged(MouseEvent evento){
                puntos.add(evento.getPoint());
                repaint(); // vuelve a dibujar JFrame
            }
        });
        setOpaque(true);
    }

    // dibuja óvalos en un cuadro delimitador de 6 x 6, en las ubicaciones especificadas en la ventana
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); // borra el área de dibujo
        // dibuja todos los puntos
        for (Point punto : puntos) {
            g.fillOval(punto.x, punto.y, 6, 6);
        }
    }
} // fin de la clase PanelDibujo