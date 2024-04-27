import efeitos.Efeitos;
import entidades.Heroi;
import entidades.NPC;
import entidades.Vendedor;
import itens.ArmaPrincipal;
import itens.consumo.Pocao;
import jogo.Jogo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        // #################### OBJETOS #########################

        // Jogo
        Jogo jogo = new Jogo();



        // ########################## INTRO ################################
        System.out.println(Efeitos.BLUE + "☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁");
        System.out.println(Efeitos.BOLD + Efeitos.BLUE + "       SKY WORLD");
        System.out.println(Efeitos.BLUE + "☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁" + Efeitos.RESET);

        System.out.print("Carregando");
        for (int i = 0; i < 8; i++) { // Imprimir 8 pontos finais com delay
            Thread.sleep(300); // Pausa de 300 milissegundos
            System.out.print(".");
        }

        System.out.println();
        String introText1 = Efeitos.YELLOW + """
                \tSKY WORLD, no limite do céu onde residia o pacifismo, a felicidade e harmonia.
                Certo dia avizinhou-se uma enorme tempestade, trazendo junto com ela variadissimos perigos.
                Agora mais que nunca precisaremos da tua ajuda, precisamos de TI!
                """ + Efeitos.RESET;
        Efeitos.escrever(introText1); // Efeito texto lento

        Heroi jogador = jogo.criarPersonagem();

        if (jogador != null) {
            System.out.println("Personagem criado com sucesso!");
            System.out.println("\nDetalhes da personagem:");
            jogador.mostrarDetalhes();
        } else {
            System.out.println("Erro ao criar personagem.");
        }

        jogo.skyWorld(jogador);



    }
}
