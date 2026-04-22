
class HiloThread extends Thread {

    public void run() {

        System.out.println("Estado: RUNNABLE (Ejecutándose)");

        try {
            System.out.println("Estado: TIMED_WAITING (sleep)");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Estado: TERMINATED (Finalizado)");
    }
}

public class MainThread {

    public static void main(String[] args) {

        HiloThread hilo = new HiloThread();

        System.out.println("Estado: NEW (Creado)");

        hilo.start(); // pasa a RUNNABLE
    }
}
