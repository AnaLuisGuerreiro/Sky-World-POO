package efeitos;

public class escritaEfeito {
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
