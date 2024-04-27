package jogo;

import efeitos.Efeitos;
import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import entidades.Vendedor;
import entidades.herois.Arqueiro;
import entidades.herois.Cavaleiro;
import entidades.herois.Feiticeiro;
import itens.ArmaPrincipal;
import itens.ItemHeroi;
import itens.consumo.Consumivel;
import itens.consumo.ConsumivelCombate;
import itens.consumo.Pocao;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;


public class Jogo {

    Scanner input = new Scanner(System.in);
    Random rand = new Random();

    public Heroi criarPersonagem() {
        Scanner input = new Scanner(System.in);
        String nick;
        int classe, dificuldade;

        // Escolhas do utilizador
        System.out.print("Introduz o teu nick: ");
        nick = input.next();
        System.out.println("Bem vindo(a) " + Efeitos.BOLD + nick + Efeitos.RESET);

        System.out.println("        Escolhe a tua classe: ");
        System.out.println("1.Arqueiro | 2.Cavaleiro | 3.Feiticeiro");
        classe = input.nextInt();
        System.out.println("        Escolhe a dificuldade: ");
        System.out.println("1.Fácil | 2.Difícil");
        dificuldade = input.nextInt();

        int pontosCriacao, ouroInicial;

        if (dificuldade == 1) {
            pontosCriacao = 300;
            ouroInicial = 20;
        } else if (dificuldade == 2) {
            pontosCriacao = 220;
            ouroInicial = 15;
        } else {
            System.out.println("Dificuldade inválida.");
            return null;
        }

        System.out.println(Efeitos.GREEN + "Distribua pontos de criação entre vida e força:");
        System.out.println("Sabendo que cada ponto de vida vale 1 ponto de criação e cada ponto de força vale 5 pontos de criação." + Efeitos.RESET);

        int pontosVida = 0;
        int pontosForca = 0;

        // Loop para distribuir os pontos
        while (pontosCriacao > 0) {
            System.out.println("Pontos de criação disponiveis: " + pontosCriacao + "🦠"); // Apresentaçao dos pontos que tem
            System.out.println("\nQuantos pontos para vida🩸 ?");
            int vida = input.nextInt();
            if (vida <= pontosCriacao) { // Verificar se tem pontos suficientes para adicionar
                pontosVida += vida;    // Adicionar à vida
                pontosCriacao -= vida; // Retirar ao pontos de criaçao
            } else {
                System.out.println("Pontos insuficientes! Tenta novamente.");
            }

            System.out.println("Pontos de criação restantes: " + pontosCriacao + "🦠"); // Apresentaçao dos pontos que ainda tem
            System.out.println("Quantos pontos para força💪🏽 ?");
            int forca = input.nextInt();
            if (forca * 5 <= pontosCriacao) { // Verificar se tem pontos suficientes para adicionar (5* mais o custo)
                pontosForca += forca;       // Adicionar à força
                pontosCriacao -= forca * 5; // Retirar ao pontos de criaçao
            }
        }

        Heroi heroi = null;
        ArmaPrincipal primeiraArma = new ArmaPrincipal("Faca pequena", 20, 15, 30);
        primeiraArma.addHeroi("Cavaleiro");
        primeiraArma.addHeroi("Arqueiro");
        primeiraArma.addHeroi("Feiticeiro");

        // Instanciar o heroi selecionado com os dados corretos iniciais
        switch (classe) {
            case 1:
                heroi = new Arqueiro(nick, pontosForca, pontosVida, ouroInicial, primeiraArma);
                break;
            case 2:
                heroi = new Cavaleiro(nick, pontosForca, pontosVida, ouroInicial, primeiraArma);
                break;
            case 3:
                heroi = new Feiticeiro(nick, pontosForca, pontosVida, ouroInicial, primeiraArma);
                break;
            default:
                System.out.println("Classe inválida.");
                break;
        }

        return heroi;

    }

    public void tutorial(Heroi jogador) {
        Vendedor vendedor = criarVendedor();

        // Bot
        NPC bot = new NPC("Cupido Desesperado", 30, 10, 10);

        // Tutorial
        Efeitos.escrever(Efeitos.YELLOW + "Tens o teu primeiro desafio! Ajuda-nos!" + Efeitos.RESET);
        Efeitos.escrever("👹 👹 👹");

        // Repetir o ataque do jogador três vezes
        for (int i = 0; i < 3; i++) {
            System.out.println("Turno " + (i + 1) + ":");
            jogador.atacar(bot); // Jogador ataca o bot
            System.out.println(); // Pular linha entre os turnos
        }


        // Ciclo para mostrar os itens
        for (int i = 0; i < vendedor.getLoja().size(); i++) {
            ItemHeroi item = vendedor.getLoja().get(i);
            System.out.print(i + 1 + " ");
            item.mostrarDetalhes();
        }

        int comprado;
        System.out.print("Qual comprar:");
        comprado = input.nextInt();

        vendedor.getLoja().remove(comprado);
        ItemHeroi itemComprado = vendedor.getLoja().get(comprado - 1);

        jogador.getInventario().add((Consumivel) itemComprado);
        jogador.usarPocao();
        jogador.mostrarDetalhes();
    }

    public void skyWorld(Heroi jogador) {
        Vendedor vendedor = criarVendedor();
        String nomeHeroi = jogador.getClass().getName();
        String simNao = "";

        int escolha;
        System.out.println("     Escolhe o teu proximo desafio.");
        System.out.println("1.Torre da Lua | 2.Labirinto dos Ventos");
        escolha = input.nextInt();

        if (escolha == 1) {
            torreDaLua(jogador);
            vendedor.imprimirLoja();
            nuvemMistica(jogador);
            vendedor.imprimirLoja();
            cavernaDaEstrelaCadente(jogador);
            vendedor.imprimirLoja();
            valeDasEstrelas(jogador);
        } else {
            // Primeira sala
            labirintoDosVentos(jogador);

            // Vendedor aparece
            System.out.print(Efeitos.UNDERLINE + "Vendedor :" + Efeitos.RESET);
            Efeitos.escrever(Efeitos.YELLOW + nomeHeroi + ", será que não precisas de comprar nada?! Dá um vista aos meus itens!" + Efeitos.RESET);

            // Ciclo para se quiser ver ou nao os itens do mercador
            do {
               System.out.print("Queres ver os itens?");
               simNao = input.next().toLowerCase();

               if(!simNao.equals("s") && !simNao.equals("n")){
                   System.out.println("Opção inválida, só s(sim) ou n (nao).");
               }

           } while (!simNao.equals("n"));

            // Se heroi quiser ver itens do mercador
            if(simNao.equalsIgnoreCase("s")){
                vendedor.imprimirLoja(); // Mostrar loja
            } else{ // Senão entra direto numa sala
                Efeitos.escrever("CUIDADOOOO!!");
                nimbusCitadel(jogador);
            }

            vendedor.imprimirLoja();
            santuarioDasAurias(jogador);
            vendedor.imprimirLoja();
            grutaCelestial(jogador);
        }


    }

    public void nuvemMistica(Heroi jogador) {
        System.out.println("Deparaste-te com uma nuvem densa, à medida que se foi dissipando, encontras-te uma bau cheio de ouro.");
        System.out.println("[50🥮 adicionado à tua bolsa]");

        jogador.setOuro(jogador.getOuro() + 50);
    }

    public void nimbusCitadel(Heroi jogador) {
        System.out.println("Azar perdeste 30");
        jogador.setOuro(jogador.getOuro() - 30);
    }

    public void torreDaLua(Entidade jogador) {
        System.out.println("Perdeste 20vida");
        jogador.setHp(jogador.getHp() - 20);
    }

    public void valeDasEstrelas(Entidade jogador) {
        System.out.println("Ganhaste 30vida");
        jogador.setHp(jogador.getHp() + 30);
    }

    public void labirintoDosVentos(Heroi jogador) {

        String letra1, letra2;
        ArmaPrincipal arcoIntermedio = new ArmaPrincipal("Arco Enterestrelar", 200, 90, 140);

        Efeitos.escrever(Efeitos.YELLOW + "Os caminhos começam a se assemelhar bastante, a velocidade do vento é inimaginavel," +
                " e não se encontra mais niguem... quando já não havia esperança de nada, algo reluziu ao longe!" +
                "Não só foi encontrada a saida como também um bau!" + Efeitos.RESET);
        System.out.println("Queres abrir? (s/n)");
        letra1 = input.next();

        if(letra1.equalsIgnoreCase("s")) {
            System.out.println("WOOW! Encontras-te o " + Efeitos.YELLOW + Efeitos.BOLD + "[Arco Enterestrelar]" + Efeitos.RESET);
        }
        if (jogador.getClass().getName().contains("Arqueiro")) {
            System.out.println("Queres trocar?");
            letra2 = input.next();
            if (letra2.equalsIgnoreCase("s")) {
                jogador.setArmaPrincipal(arcoIntermedio);
            }
        } else {
            System.out.println(Efeitos.RED + "Não podes utilizar esta arma. Terás mais sorte numa proxima!" + Efeitos.RESET);
        }

    }

    public void grutaCelestial(Heroi jogador) {
        boolean val = rand.nextInt(2) == 0;
        NPC bot = new NPC("Unicornio preto", 50, 20, 10);

        if (val) {
            System.out.println("3 inimigos");
            // 3 inimigos
            for (int i = 0; i < 3; i++) {
                System.out.println("Turno " + (i + 1) + ":");
                jogador.atacar(bot); // Jogador ataca o bot
                System.out.println(); // Pular linha entre os turnos
            }
        } else {
            System.out.println("2 inimigos");
            // 2 inimigos
            for (int i = 0; i < 2; i++) {
                System.out.println("Turno " + (i + 1) + ":");
                jogador.atacar(bot); // Jogador ataca o bot
                System.out.println(); // Pular linha entre os turnos
            }
        }

    }

    public void santuarioDasAurias(Heroi jogador) {
        double probabilidade = rand.nextDouble(100.0);
        int numeroInimigos;
        NPC bot = new NPC("fkfk preto", 50, 20, 10);

        if (probabilidade < 50) {
            numeroInimigos = 1;
        } else if (probabilidade < 70) {
            numeroInimigos = 2;
        } else {
            numeroInimigos = 3;
        }

        // Ronda inimigos
        System.out.println(numeroInimigos + "a enfrentar");
        for (int i = 0; i < numeroInimigos; i++) {
            System.out.println("Turno " + (i + 1) + ":");
            jogador.atacar(bot); // Jogador ataca o bot
            System.out.println(); // Pular linha entre os turnos
        }

    }

    public void cavernaDaEstrelaCadente(Heroi jogador) {
        String letra;

        System.out.println("Totem da gloria");
        System.out.println("Tens 50% de probabilidade de ganhar ouro ou de morte!");

        do {
            boolean cinquenta50 = rand.nextInt(2) == 0;

            System.out.println("Queres arriscar? (s/n)");
            letra = input.next();

            if (cinquenta50) {
                System.out.println("Ganhaste");
                jogador.setOuro(jogador.getOuro() + 150);
            } else {
                System.out.println("Game over");
                jogador.setHp(0);
                return;
            }

        } while (letra.equalsIgnoreCase("s"));
    }

    private Vendedor criarVendedor() {
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
        bastaoIntermedio.addHeroi("Feiticeiro");
        ArmaPrincipal bastaoAlto = new ArmaPrincipal("Bastão trovão", 400, 100, 200);
        bastaoAlto.addHeroi("Feiticeiro");

        // Armas Arqueiro
        ArmaPrincipal arcoInicial = new ArmaPrincipal("Arco Enferrujado", 50, 20, 40);
        arcoInicial.addHeroi("Arqueiro");
        ArmaPrincipal arcoIntermedio = new ArmaPrincipal("Arco Enterestrelar", 200, 90, 140);
        arcoIntermedio.addHeroi("Arqueiro");
        ArmaPrincipal arcoAlto = new ArmaPrincipal("Arco Trovão", 300, 100, 140);
        arcoAlto.addHeroi("Arqueiro");

        // Poções
        Pocao pocaoVida = new Pocao("Poçao vida", 25, 25, 0);
        Pocao pocaoForca = new Pocao("Poçao força", 15, 0, 25);

        // Consumiveis combate
        ConsumivelCombate ataque = new ConsumivelCombate("ya", 20, 20);

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
        vendedor.addItem(pocaoForca);
        vendedor.addItem(pocaoVida);
        vendedor.addItem(pocaoForca);
        vendedor.addItem(pocaoVida);
        vendedor.addItem(ataque);

        return vendedor;
    }

}






