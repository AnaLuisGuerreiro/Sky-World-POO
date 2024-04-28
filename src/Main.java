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
        // Criação da personagem
        Heroi jogador = jogo.criarPersonagem();

        if (jogador != null) { // Verificar se foi feita a criação corretamente
            System.out.println(Efeitos.GREEN + "Personagem criado com sucesso!" + Efeitos.RESET);
            System.out.println("\nDetalhes da nova personagem: ");
            jogador.mostrarDetalhes();
        } else {
            System.out.println("Erro ao criar personagem.");
        }

        // História e fluxo do jogo
        jogo.skyWorld(jogador);

        input.close(); // Fechar scanner

    }
}
