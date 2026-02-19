// Fig. 1.25: MarcoRastreadorRaton.java
// Prueba de MarcoRastreadorRaton.
import javax.swing.JFrame;

public class RastreadorRaton{
    public static void main(String[] args){
        MarcoRastreadorRaton marcoRastreadorRaton = new MarcoRastreadorRaton();
        marcoRastreadorRaton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoRastreadorRaton.setSize(300, 100);
        marcoRastreadorRaton.setVisible(true);
    }
} // fin de la clase RastreadorRaton