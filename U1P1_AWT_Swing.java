import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class U1P1_AWT_Swing {
    public static void main(String[] args) {
        Frame Ventana = new Frame("Ventana AWT");
        Ventana.setSize(500, 500);
        Ventana.setVisible(true);
        Ventana.setLocation(300, 200);
        Ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}