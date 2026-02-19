import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class AppJPanelColor extends JFrame{
    private final JButton cambiarColorJButton;
    private Color color = Color.LIGHT_GRAY;
    private final JPanel coloresJPanel;

    // establece la GUI
    public AppJPanelColor(){
        super("Uso de JColorChooser");

        // crea objeto JPanel para mostrar color
        coloresJPanel = new JPanel();
        coloresJPanel.setBackground(color);

        // establece cambiarColorJButton y registra su manejador de eventos
        cambiarColorJButton = new JButton("Cambiar color");
        cambiarColorJButton.addActionListener(
        new ActionListener(){ // clase interna anónima
            // muestra JColorChooser cuando el usuario hace clic con el botón
            @Override
            public void actionPerformed(ActionEvent evento){
                color = .showDialog(AppJColorChooser.this, "Seleccione un color", color);

                // establece el color predeterminado, si no se devuelve un color
                if (color == null)
                    color = Color.LIGHT_GRAY;

                // cambia el color de fondo del panel de contenido
                coloresJPanel.setBackground(color);
            } // fin del método actionPerformed
        }); // fin de la clase interna anónima 
        add(coloresJPanel, BorderLayout.CENTER);
        add(cambiarColorJButton, BorderLayout.SOUTH);
    } // fin del constructor de AppJColorChooser
} // fin de la clase AppJColorChooser