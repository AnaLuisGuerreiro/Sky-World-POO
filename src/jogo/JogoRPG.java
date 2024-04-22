package jogo;

import entidades.herois.Cavaleiro;
import itens.ArmaPrincipal;

import java.util.Scanner;

import static efeitos.escritaEfeito.escrever;

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
        Scanner input = new Scanner(System.in);

        // Objetos
        ArmaPrincipal espadaInicial = new ArmaPrincipal("Espada enferrujada",50,15,30);
        ArmaPrincipal espadaMedia = new ArmaPrincipal("Espada cintilante",200,50,90);
        ArmaPrincipal espadaAlta = new ArmaPrincipal("Espada trovão",450,100,150);

/*
            // ########################## INTRO ################################
            System.out.println(BLUE + "☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁");
            System.out.println(BOLD + BLUE + "       SKY WORLD");
            System.out.println(BLUE + "☁☁☁☁☁☁☁☁☁☁☁☁☁☁☁" + RESET);

            System.out.print("Carregando");
            for (int i = 0; i < 8; i++) { // Imprimir 8 pontos finais com delay
                Thread.sleep(300); // Pausa de 300 milissegundos
                System.out.print(".");
            }

            System.out.println();
            String introText1 = """
            \tSKY WORLD, no limite do céu onde residia o pacifismo, a felicidade e harmonia.
            Certo dia avizinhou-se uma enorme tempestade, trazendo junto com ela variadissimos perigos.
            Agora mais que nunca precisaremos da tua ajuda, precisamos de TI!
            """;
            escrever(introText1); // Efeito texto lento
*/
        // ###################### REGISTO #############################
        String nome;
        int heroi;

        System.out.print("Introduz um nick: ");
        nome = input.next();

        System.out.println("Bem-vindo(a) " + nome);
        System.out.println("Escolhe a tua classe:");
        System.out.println("1.Cavaleiro  |  2.Feiticeiro  |  3.Arqueiro  | 4.Assassino");
        heroi = input.nextInt();

        switch (heroi){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

    }
}

