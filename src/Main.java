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

        // Instanciar o Jogo
        Jogo jogo = new Jogo();

        // ###### INICIO JOGO ######
       // jogo.intro();

        // Criação da personagem
        Heroi jogador = jogo.criarPersonagem();

        // História e fluxo do jogo
        jogo.skyWorld(jogador);

        input.close(); // Fechar scanner

    }
}
