// Fig. 1.18: PruebaLista.java
// Selección de colores de un objeto JList.

import javax.swing.JFrame;

public class PruebaLista {

    public static void main(String[] args) {
        MarcoLista marcoLista = new MarcoLista(); // crea objeto MarcoLista
        marcoLista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoLista.setSize(320, 240); //Establce el tamaño de la ventana
        
        marcoLista.setVisible(true);
    }

} // fin de la clase PruebaLista