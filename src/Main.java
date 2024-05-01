import efeitos.Efeitos;
import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import entidades.Vendedor;
import itens.ArmaPrincipal;
import itens.consumo.Pocao;
import jogo.Jogo;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Instanciar o Jogo
        Jogo jogo = new Jogo();

        // ###### INICIO JOGO ######
       // jogo.intro();

        // Criação da personagem
        Heroi jogador = jogo.criarPersonagem();

        // História e fluxo do jogo
        Entidade vencedor = jogo.skyWorld(jogador);

        if(vencedor instanceof NPC){
            System.out.println(Efeitos.RED + """
                    Fim do jogo.
                    1.Desejas jogar com a mesma personagem
                    2.Criar nova personagem
                    3.Sair
                    """ + Efeitos.RESET);
            int opcao = input.nextInt();

            if(opcao == 1){

                jogador.resetStats(jogador);
                jogador.mostrarDetalhes();
                jogo.skyWorld(jogador);
            } else if(opcao ==2){
                jogo.skyWorld(jogo.criarPersonagem());
            } else if(opcao ==3){
                return;
            }
        } else {
            System.out.println("""
                      ____    _    _   _ _   _    _    ____ _____ _____\s
                     / ___|  / \\  | \\ | | | | |  / \\  / ___|_   _| ____|
                    | |  _  / _ \\ |  \\| | |_| | / _ \\ \\___ \\ | | |  _| \s
                    | |_| |/ ___ \\| |\\  |  _  |/ ___ \\ ___) || | | |___\s
                     \\____/_/   \\_\\_| \\_|_| |_/_/   \\_\\____/ |_| |_____|
                    """);
        }

        input.close(); // Fechar scanner

    }
}
