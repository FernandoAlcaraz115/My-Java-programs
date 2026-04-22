import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 🔹 Clase del hilo (NO es pública)
class TAP_HiloThread extends Thread {

    private String nombre;
    private int iteraciones;

    // Constructor
    public TAP_HiloThread(String nombre, int iteraciones) {
        this.nombre = nombre;
        this.iteraciones = iteraciones;
    }

    @Override
    public void run() {

        // Formato con milisegundos
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        for (int i = 1; i <= iteraciones; i++) {

            // Obtener hora actual
            String hora = LocalTime.now().format(formato);

            // Mostrar datos del hilo
            System.out.println(nombre + 
                               " - Iteración " + i + 
                               " - Hora: " + hora);

            try {
                // Pausa de 1 segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(nombre + " - FINALIZADO\n");
    }
}

// 🔹 Clase principal (ÚNICA pública)
public class MainThread {

    public static void main(String[] args) {

        System.out.println("=== PRÁCTICA DE HILOS (UN SOLO ARCHIVO) ===\n");

        // Crear hilos
        TAP_HiloThread hilo1 = new TAP_HiloThread("Hilo 1", 5);
        TAP_HiloThread hilo2 = new TAP_HiloThread("Hilo 2", 7);
        TAP_HiloThread hilo3 = new TAP_HiloThread("Hilo 3", 6);

        // Iniciar hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        System.out.println("Todos los hilos iniciados...\n");
    }
}
