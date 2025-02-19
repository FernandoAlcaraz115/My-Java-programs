import java.util.Random;

public class CarreraBuses {

    public static final String GREEN = "\033[32m";
    public static final String END = "\033[0m";

    public static String buses(int n1, int n2) {
        StringBuilder output = new StringBuilder();
        
        // Asegurarse de que los valores no excedan los límites para evitar negativos
        n1 = Math.min(n1, 95);
        n2 = Math.min(n2, 95);
        
        output.append("-".repeat(115)).append("\n");
        output.append(" ".repeat(n1)).append("_______________  ").append(" ".repeat(100 - n1)).append("|").append("\n");
        output.append(" ".repeat(n1)).append("|__|__|__|__|__|___ ").append(" ".repeat(97 - n1)).append("|").append("\n");
        output.append(" ".repeat(n1)).append("|    Fernando     |)").append(" ".repeat(96 - n1)).append("|").append("\n");
        output.append(" ".repeat(n1)).append("|~~~@~~~~~~~~~@~~~|)").append(" ".repeat(95 - n1)).append("|").append("\n");
        output.append("_".repeat(115)).append("\n");
        output.append(" ".repeat(n2)).append("_______________  ").append(" ".repeat(100 - n2)).append("|").append("\n");
        output.append(" ".repeat(n2)).append("|__|__|__|__|__|___ ").append(" ".repeat(97 - n2)).append("|").append("\n");
        output.append(" ".repeat(n2)).append("|     Corredor 2  |)").append(" ".repeat(96 - n2)).append("|").append("\n");
        output.append(" ".repeat(n2)).append("|~~~@~~~~~~~~~@~~~|)").append(" ".repeat(95 - n2)).append("|").append("\n");
        output.append("_".repeat(115));
        return output.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        int a = 0;
        int b = 0;
        String gano = null;

        System.out.println("<<<<<<<<<<<<< Carrera de buses de Fernando :D >>>>>>>>>>>>");
        System.out.println("        Fernando vs Corredor 2");
        Thread.sleep(3000);

        Random random = new Random();

        while (a < 97 && b < 97) {
            int c = random.nextInt(2) + 1;
            if (c == 1) {
                a++;
            }
            else if (c == 2) {
                b++;
            }

            // Clear console in Java (ANSI escape code)
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(buses(a, b));
            Thread.sleep(70);
        }

        if (a >= 97) {
            gano = "Fernando";
        }
        else if (b >= 97) {
            gano = "Corredor 2";
        }

        System.out.println(GREEN + "GANÓ LA CARRERA: " + gano + END);
    }
}
