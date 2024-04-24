package efeitos;

public class Efeitos {

    // Códigos ANSI para cores
    public static  String RESET = "\u001B[0m";
    public static  String RED = "\u001B[31m";
    public static  String GREEN = "\u001B[32m";
    public static  String YELLOW = "\u001B[33m";
    public static  String BLUE = "\u001B[34m";
    public static  String BOLD = "\u001B[1m";
    public static  String UNDERLINE = "\u001B[4m";

    public static void escrever(String text) {
        try {
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(50); // Atraso de 50 milissegundos entre cada caractere
            }
            System.out.println(); // Nova linha após exibir o texto completo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
