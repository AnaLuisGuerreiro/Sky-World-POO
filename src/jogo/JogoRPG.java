package jogo;

import entidades.Heroi;
import entidades.NPC;
import entidades.Vendedor;
import entidades.herois.Arqueiro;
import entidades.herois.Cavaleiro;
import entidades.herois.Feiticeiro;
import itens.ArmaPrincipal;
import efeitos.Efeitos;
import itens.ItemHeroi;
import itens.consumo.Consumivel;
import itens.consumo.Pocao;

import java.util.ArrayList;
import java.util.Scanner;


public class JogoRPG {


    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);

        // Objetos
        NPC bot = new NPC("Fantasma Desesperado",30,10,10);

/*
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
            String introText1 = """
            \tSKY WORLD, no limite do céu onde residia o pacifismo, a felicidade e harmonia.
            Certo dia avizinhou-se uma enorme tempestade, trazendo junto com ela variadissimos perigos.
            Agora mais que nunca precisaremos da tua ajuda, precisamos de TI!
            """;
            Efeitos.escrever(introText1); // Efeito texto lento
*/
        // ###################### REGISTO #############################
        String nome;
        int opcao;

        System.out.print("Introduz um nick: ");
        nome = input.next();

        System.out.println("Bem-vindo(a) " + nome);
        System.out.println("Escolhe a tua classe:");
        System.out.println("1.Cavaleiro  |  2.Feiticeiro  |  3.Arqueiro ");
        opcao = input.nextInt();

        switch (opcao){
            case 1:
                Cavaleiro cavaleiroJogador = new Cavaleiro(nome,20,120);
                break;
            case 2:
                Feiticeiro feiticeiroJogador = new Feiticeiro(nome,30,110);
                Efeitos.escrever("Tens o teu primeiro desafio, prepara-te!");
                System.out.println("👹 👹 👹");
                feiticeiroJogador.atacar(bot);
                feiticeiroJogador.atacar(bot);
                feiticeiroJogador.atacar(bot);

                break;
            case 3:
                Arqueiro arqueiroJogador = new Arqueiro(nome,40,100);
                break;
            default:
                System.out.println("Opcao inválida.");
        }


    }






    }

