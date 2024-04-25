import efeitos.Efeitos;
import entidades.Heroi;
import entidades.NPC;
import entidades.Vendedor;
import itens.ArmaPrincipal;
import jogo.Jogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        // #################### OBJETOS #########################

        // Jogo
        Jogo jogo = new Jogo();

        // NPCS
        NPC bot = new NPC("Cupido Desesperado", 30, 10, 10);

        //          Armas

        // Armas Cavaleiro
        ArmaPrincipal espadaInicial = new ArmaPrincipal("Espada Enferrujada", 50, 25, 40);
        espadaInicial.addHeroi("Cavaleiro");
        ArmaPrincipal espadaIntermedia = new ArmaPrincipal("Espada Enterestrelar", 150, 50, 100);
        espadaIntermedia.addHeroi("Cavaleiro");
        ArmaPrincipal espadaAlta = new ArmaPrincipal("Espada Trovão", 300, 90, 140);
        espadaAlta.addHeroi("Cavaleiro");

        // Armas Feiticeiro
        ArmaPrincipal bastaoInicial = new ArmaPrincipal("Bastão Enferrujado", 40, 20, 30);
        bastaoInicial.addHeroi("Feiticeiro");
        ArmaPrincipal bastaoIntermedio = new ArmaPrincipal("Bastão Enterestrelar", 100, 45, 90);
        bastaoInicial.addHeroi("Feiticeiro");
        ArmaPrincipal bastaoAlto = new ArmaPrincipal("Bastão trovão", 400, 100, 200);
        bastaoInicial.addHeroi("Feiticeiro");

        // Armas Arqueiro
        ArmaPrincipal arcoInicial = new ArmaPrincipal("Arco Enferrujado", 50, 20, 40);
        arcoInicial.addHeroi("Arqueiro");
        ArmaPrincipal arcoIntermedio = new ArmaPrincipal("Arco Enterestrelar", 200, 90, 140);
        arcoIntermedio.addHeroi("Arqueiro");
        ArmaPrincipal arcoAlto = new ArmaPrincipal("Arco Trovão", 300, 100, 140);
        arcoAlto.addHeroi("Arqueiro");


        // Vendedor
        Vendedor vendedor = new Vendedor();
        // Loja - add items
        vendedor.addItem(espadaInicial);
        vendedor.addItem(espadaIntermedia);
        vendedor.addItem(espadaAlta);
        vendedor.addItem(bastaoInicial);
        vendedor.addItem(bastaoIntermedio);
        vendedor.addItem(bastaoAlto);
        vendedor.addItem(arcoInicial);
        vendedor.addItem(arcoIntermedio);
        vendedor.addItem(arcoAlto);


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

        // Tutorial
        Efeitos.escrever(Efeitos.YELLOW + "Tens o teu primeiro desafio! Ajuda-nos!");
        Efeitos.escrever("👹 👹 👹");
        jogador.atacar(bot);
        jogador.atacar(bot);
        jogador.atacar(bot);

    }
}
