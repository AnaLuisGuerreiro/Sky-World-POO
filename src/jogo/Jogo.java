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
import itens.consumo.ConsumivelCombate;
import itens.consumo.Pocao;

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
        System.out.println("Bem vindo(a) " + Efeitos.BOLD + Efeitos.YELLOW + nick + Efeitos.RESET);

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
            System.out.println("\nQuantos pontos para vida 🩸 ?");
            int vida = input.nextInt();
            if (vida <= pontosCriacao) { // Verificar se tem pontos suficientes para adicionar
                pontosVida += vida;    // Adicionar à vida
                pontosCriacao -= vida; // Retirar ao pontos de criaçao
            } else {
                System.out.println("Pontos insuficientes! Tenta novamente.");
            }

            System.out.println("Pontos de criação restantes: " + pontosCriacao + "🦠"); // Apresentaçao dos pontos que ainda tem
            System.out.println("Quantos pontos para força 💪🏽 ?");
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

        Efeitos.escrever(Efeitos.YELLOW + "Foi-te atribuida uma arma para os desafios iniciais. " + Efeitos.RESET + Efeitos.GREEN + "[" + primeiraArma.getNome() + "]"+ Efeitos.RESET);
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

        if (heroi != null) { // Verificar se foi feita a criação corretamente
            System.out.println(Efeitos.GREEN + "Personagem criado com sucesso!" + Efeitos.RESET);
            System.out.println("\nDetalhes da nova personagem: ");
            heroi.mostrarDetalhes();
        } else {
            System.out.println("Erro ao criar personagem.");
        }

        return heroi;

    }

    public void tutorial(Heroi jogador) {
        Vendedor vendedor = criarVendedor();

        // Bot
        NPC bot = new NPC("Cupido Desesperado", 30, 10, 10);

        // Tutorial
        Efeitos.escrever(Efeitos.YELLOW + "Tens o teu primeiro desafio! Ajuda-nos!" + Efeitos.RESET);
        Efeitos.escrever("👹 👹 ");

        // Repetir o ataque do jogador três vezes
        jogador.rondasInimigos(jogador, 2, bot);

        vendedor.imprimirLoja(jogador);
    }

    public void intro() throws InterruptedException {
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
    }

    public Entidade skyWorld(Heroi jogador) {
        // tutorial(jogador);

        Entidade vencedor = null;
        Vendedor vendedor = criarVendedor();
        String className = jogador.getClass().getName();
        String nomeHeroi = className.substring(className.lastIndexOf('.') + 1); // Extrair apenas nome da classe do heroi
        String simNao;

        vendedor.imprimirLoja(jogador);

        int escolha;
        System.out.println("     Escolhe o teu proximo desafio.");
        System.out.println("1.Torre da Lua | 2.Gruta Celestial");
        escolha = input.nextInt();

        // Primeira escolha
        if (escolha == 1) {
            Efeitos.estrada();
            torreDaLua(jogador); // Primeira sala
            Efeitos.estrada();
            nuvemMistica(jogador); // Segunda sala
            Efeitos.estrada();
            Efeitos.escrever(Efeitos.YELLOW + "Vagueaste pelas núvens e deparaste-te com duas opções."+ Efeitos.RESET);
            System.out.println("1.Caverna da Estrela Cadente | 2.Vale das Estrelas");
            escolha = input.nextInt();

            // Primeira escolha / Primeira escolha
            if (escolha == 1) {
                Efeitos.estrada();
                vencedor = cavernaDaEstrelaCadente(jogador); // Primeira opção /
                if(vencedor instanceof NPC){
                    return vencedor;
                }
                vendedor.imprimirLoja(jogador);
                vencedor = cemiterioDosAnjos(jogador);

            // Segunda escolha / Primeira escolha
            } else if (escolha == 2) {
                valeDasEstrelas(jogador);
                Efeitos.estrada();
                vencedor = grutaCelestial(jogador);
            }


        // Segunda escolha
        } else {
            Efeitos.estrada();
            // Jogar primeira sala escolhida
            vencedor = grutaCelestial(jogador);
            if(vencedor instanceof Heroi){
                jogador.usarPocao();
                System.out.println();
            }

            // Vendedor aparece
            System.out.print(Efeitos.UNDERLINE + "👳🏽‍♂️ Vendedor :" + Efeitos.RESET);
            Efeitos.escrever(Efeitos.YELLOW + " " + nomeHeroi + ", será que não precisas de comprar nada?!\n" +
                    "Dá um vista de olhos aos meus itens!" + Efeitos.RESET);

            // Ciclo para se quiser ver ou nao os itens do mercador
            do {
                System.out.println("Queres ver os itens? (s/n)");
                simNao = input.next().toLowerCase();

                if (!simNao.equals("s") && !simNao.equals("n")) {
                    System.out.println("Opção inválida, só s(sim) ou n(nao).");
                }

            } while (!simNao.equals("n") && !simNao.equals("s"));

            // Se heroi quiser ver itens do mercador
            if (simNao.equalsIgnoreCase("s")) {
                System.out.println();
                vendedor.imprimirLoja(jogador); // Mostrar loja

            } else { // Senão entra direto numa sala
                Efeitos.escrever("CUIDADOOOO!!");
                nimbusCitadel(jogador);
            }

            Efeitos.estrada();
            Efeitos.escrever(Efeitos.YELLOW + "Viste sinais de fumo ao longe, queres descobrir o que se passa?(s/n)" + Efeitos.RESET);
            simNao = input.next();

            if (simNao.equalsIgnoreCase("s")) {
                Efeitos.estrada();
                vencedor = santuarioDasAurias(jogador);
            } else {
                Efeitos.estrada();
                labirintoDosVentos(jogador);
            }
        }

        return vencedor;
    }

    private void nuvemMistica(Heroi jogador) {
        Efeitos.escrever(Efeitos.YELLOW + "Deparaste-te com uma nuvem densa, à medida que se foi dissipando, encontras-te uma bau cheio de ouro." + Efeitos.RESET);
        System.out.println("[50🥮 adicionado à tua bolsa]\n");
        jogador.setOuro(jogador.getOuro() + 50);
        jogador.mostrarDetalhes();
    }

    private void nimbusCitadel(Heroi jogador) {
        Efeitos.escrever("Enquanto caminhavas caiste num buraco, deixas-te cair as tuas moedas todas de ouro..." +
                "ao apanha-las percebeste que perdeste 30🥮.");
        jogador.setOuro(jogador.getOuro() - 30);
        System.out.println("Carteira: " + jogador.getOuro() + "🥮");
    }

    private void torreDaLua(Heroi jogador) {
        Efeitos.escrever(Efeitos.YELLOW + "Tropeçaste e ao bater contra um ramo de uma árvore perdeste um pouco de hp." + Efeitos.RESET);
        System.out.println("[Perdeste -5🩸]\n");
        jogador.setHp(jogador.getHp() - 5);
        jogador.mostrarDetalhes();
        System.out.println();
    }

    private void valeDasEstrelas(Heroi jogador) {

        Efeitos.escrever(Efeitos.YELLOW + "Surgiu uma fada pelo caminho que te encantou e encheu de alegria." + Efeitos.RESET);
        System.out.println("[Ganhaste 30🩸 HP Máximo e recuperaste a vida toda]");
        jogador.setHpMax(jogador.getHpMax() + 30); // Adicionar 30 ao hpMax
        jogador.setHp(jogador.getHpMax()); // Vida igual ao hpMax
        jogador.mostrarDetalhes();
        System.out.println();

    }

    private void labirintoDosVentos(Heroi jogador) {

        String letra1, letra2;
        ArmaPrincipal arcoIntermedio = new ArmaPrincipal("Arco Enterestrelar", 200, 90, 140);

        Efeitos.escrever(Efeitos.YELLOW + "Os caminhos começam a se assemelhar bastante, a velocidade do vento é inimaginavel," +
                "\ne não se encontra mais niguem... quando já não havia esperança de nada, algo reluziu ao longe!" +
                "\nNão só encontraste a saída como também um bau!" + Efeitos.RESET);

        do { // Opção de abrir ou não o bau
            System.out.println("Queres abrir? (s/n)");
            letra1 = input.next().toLowerCase();
            if (!letra1.equals("s") && !letra1.equals("n")) {
                System.out.println(Efeitos.RED + "Opção inválida. Insere de novo (s/n)" + Efeitos.RESET);
            }
        } while (!letra1.equals("s") && !letra1.equals("n"));


        if (letra1.equals("s")) { // Entrar apenas quando é selecionado "s"
            System.out.println("WOOW! Encontras-te o " + Efeitos.YELLOW + Efeitos.BOLD + "[Arco Enterestrelar]" + Efeitos.RESET);

            if (jogador.getClass().getName().contains("Arqueiro")) { // Verificar se é da classe heroi que pode usar a arma
                System.out.println("Queres trocar com a tua arma atual? (s/n)");
                letra2 = input.next();
                if (letra2.equalsIgnoreCase("s")) {
                    // Calcular a diferença de ataque de uma arma para a outra
                    int maisAtaque = arcoIntermedio.getAtaque() - jogador.getArmaPrincipal().getAtaque();
                    // Calcular a diferença de ataque especial de uma arma para a outra
                    int maisEspecial = arcoIntermedio.getAtaqueEspecial() - jogador.getArmaPrincipal().getAtaqueEspecial();

                    Efeitos.escrever("Boa! Equipaste uma nova arma!" + Efeitos.GREEN + " +" + maisAtaque + "🗡 | +" + maisEspecial + "💥\n" + Efeitos.RESET);
                    jogador.setArmaPrincipal(arcoIntermedio); // Atribuir arma como arma principal
                }
            } else {
                System.out.println(Efeitos.RED + "Não podes utilizar esta arma. Terás mais sorte numa proxima!" + Efeitos.RESET);
            }
        }

        jogador.mostrarDetalhes();
        System.out.println();
    }

    private Entidade grutaCelestial(Heroi jogador) {

        Entidade vencedor;
        boolean val = rand.nextInt(2) == 0;
        NPC unicornio = new NPC("Unicornio preto", 55, 20, 10);
        NPC duende = new NPC("Duende", 70, 20, 10);


        if (val) {
            // 3 inimigos
            Efeitos.escrever(Efeitos.YELLOW + "Ups... tiveste azar... encontraste 3 inimigos!" + Efeitos.RESET);
            vencedor = jogador.rondasInimigos(jogador, 3, unicornio);
        } else {
            // 2 inimigos
            Efeitos.escrever(Efeitos.YELLOW + "Encontraste apenas 2 inimigos. Derrota-os!" + Efeitos.RESET);
            jogador.rondasInimigos(jogador, 1, unicornio);
            vencedor = jogador.rondasInimigos(jogador, 1, duende);
        }

        return vencedor;
    }

    private Entidade santuarioDasAurias(Heroi jogador) {
        Efeitos.escrever(Efeitos.YELLOW + "Aproximando cada vez mais, o fumo que viste ao longe não eram sinais" +
                "mas sim vindo de um local de dragões." + Efeitos.RESET);
        double probabilidade = rand.nextDouble(100.0);
        int numeroInimigos;
        NPC bot = new NPC("Dragão Água", 150, 100, 1000);

        if (probabilidade < 50) {
            numeroInimigos = 1;
        } else if (probabilidade < 70) {
            numeroInimigos = 2;
        } else {
            numeroInimigos = 3;
        }

        // Ronda inimigos consoante as probabilidades
        Efeitos.escrever(numeroInimigos + " inimigo(s) a enfrentar.");

       return jogador.rondasInimigos(jogador, numeroInimigos, bot);
    }

    private Entidade cemiterioDosAnjos(Heroi jogador) {
        Efeitos.escrever(Efeitos.YELLOW + "Num cenário sombrio aproximas-te por curiosidade." +
                "Deparas-te com o adversário final." + Efeitos.RESET);
        NPC bot = new NPC("Boss Final", 200, 30, 1000);

        Efeitos.escrever(Efeitos.UNDERLINE + "👹 Boss final: " + Efeitos.RESET + Efeitos.RED + "Julgaste que a tua jornada já estava no final, mas agora vou-te mostrar o verdadeiro terror.\n Prepara-te para conhecer o teu tumulo!" + Efeitos.RESET);

        return jogador.atacar(bot);
    }

    private Entidade cavernaDaEstrelaCadente(Heroi jogador) {

        NPC totemGloria = new NPC("Totem", 3000, 3000, 0);
        String letra;
        Efeitos.escrever(Efeitos.YELLOW + "Encontraste um totem!" + Efeitos.RESET);
        System.out.println("          === 💰 Totem da Glória 💀 ===");

       Efeitos.escrever(Efeitos.YELLOW + "Tens 50% de probabilidade de ganhar ouro ou... por outro lado, morte." + Efeitos.RESET);

        do {
            boolean cinquenta50 = rand.nextInt(2) == 0;

            System.out.println("Queres arriscar? (s/n)");
            letra = input.next();

            if(letra.equalsIgnoreCase("s")) {

                if (cinquenta50) {
                    Efeitos.escrever("PARABENS! Ganhas-te 150🥮");
                    jogador.setOuro(jogador.getOuro() + 150);
                    jogador.mostrarDetalhes();
                } else {
                    Efeitos.escrever(Efeitos.RED + "Morreste.\n" + Efeitos.RESET);
                    jogador.setHp(0);
                    return totemGloria;
                }
            }
        } while (letra.equalsIgnoreCase("s"));


        return jogador;
    }

    private Vendedor criarVendedor() {
        // Armas Cavaleiro
        ArmaPrincipal espadaInicial = new ArmaPrincipal("Espada Enferrujada", 50, 55, 80);
        espadaInicial.addHeroi("Cavaleiro");
        ArmaPrincipal espadaIntermedia = new ArmaPrincipal("Espada Interestelar", 100, 75, 110);
        espadaIntermedia.addHeroi("Cavaleiro");
        ArmaPrincipal espadaAlta = new ArmaPrincipal("Espada Trovão", 200, 90, 150);
        espadaAlta.addHeroi("Cavaleiro");

        // Armas Feiticeiro
        ArmaPrincipal bastaoInicial = new ArmaPrincipal("Bastão Enferrujado", 40, 50, 70);
        bastaoInicial.addHeroi("Feiticeiro");
        ArmaPrincipal bastaoIntermedio = new ArmaPrincipal("Bastão Interestelar", 100, 75, 95);
        bastaoIntermedio.addHeroi("Feiticeiro");
        ArmaPrincipal bastaoAlto = new ArmaPrincipal("Bastão trovão", 250, 100, 125);
        bastaoAlto.addHeroi("Feiticeiro");

        // Armas Arqueiro
        ArmaPrincipal arcoInicial = new ArmaPrincipal("Arco Enferrujado", 50, 50, 75);
        arcoInicial.addHeroi("Arqueiro");
        ArmaPrincipal arcoIntermedio = new ArmaPrincipal("Arco Interestelar", 100, 75, 90);
        arcoIntermedio.addHeroi("Arqueiro");
        ArmaPrincipal arcoAlto = new ArmaPrincipal("Arco Trovão", 200, 100, 140);
        arcoAlto.addHeroi("Arqueiro");

        // Faca para todos os heróis
        ArmaPrincipal faca = new ArmaPrincipal("Faca", 20, 25, 40);
        faca.addHeroi("Cavaleiro");
        faca.addHeroi("Feiticeiro");
        faca.addHeroi("Arqueiro");

        // Poções
        Pocao pocaoVida = new Pocao("Poção vida", 25, 25, 0);
        Pocao pocaoForca = new Pocao("Poção força", 15, 0, 25);

        // Consumiveis combate
        ConsumivelCombate consumivelCombateLigeiro = new ConsumivelCombate("Consumivel ataque ligeiro", 20, 20);
        ConsumivelCombate consumivelCombatePesado = new ConsumivelCombate("Consumivel ataque pesado", 50, 75);


        // Vendedor
        Vendedor vendedor = new Vendedor();

        // Loja - add items
        vendedor.addItem(faca);
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
        vendedor.addItem(consumivelCombateLigeiro);
        vendedor.addItem(consumivelCombatePesado);


        return vendedor;
    }

}






