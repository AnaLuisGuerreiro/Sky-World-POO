public class JogoRPG {

        // Códigos ANSI para cores
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String BOLD = "\u001B[1m";
        public static final String UNDERLINE = "\u001B[4m";

        public static void main(String[] args) throws InterruptedException {


            // Inicio do Jogo
            System.out.println(BLUE + "☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁");
            System.out.println(BOLD + BLUE + "       SKY WORLD");
            System.out.println(BLUE + "☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁" + RESET);

            System.out.print("Loading");
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300); // Pausa de 300 milissegundos
                System.out.print(".");
            }
        }
    }

