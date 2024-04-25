package entidades.herois;

import efeitos.Efeitos;
import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import itens.ArmaPrincipal;
import itens.consumo.Consumivel;
import itens.consumo.ConsumivelCombate;

import java.util.Scanner;

public class Cavaleiro extends Heroi {

    /*
        Construtor de Cavaleiro
    */

    public Cavaleiro(String nome, int forca, int maxHp, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp, ouro, armaPrincipal);
    }

    @Override
    public Entidade atacar(Entidade npc) {
        Scanner input = new Scanner(System.in);
        int opcao, danoHeroi, danoNpc;

        // Inimigo ataca primeiro
        danoNpc = (int) (npc.getForca() * 0.8); // Primeiro ataque apenas 80% da força inicial
        this.receberDano(danoNpc); // Retirar dano à vida do heroi

        // Heroi derrotado
        if (this.hp <= 0) {
            System.out.println(this.nome + " foste derrotado por " + npc.getNome());
            return npc; // Retorna objeto inimigo
        }

        do {
            System.out.println(Efeitos.BOLD + this.nome + Efeitos.RESET + " Escolhe o teu ataque!");
            System.out.println("1.Ataque normal | 2.Ataque Especial | + 3.Ataque consumivel");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    // Ataque do heroi (força + ataque da arma)
                    danoHeroi = this.forca + this.getArmaPrincipal().getAtaque();
                    npc.receberDano(danoHeroi); // Tirar dano à vida do npc
                    break;
                case 2:
                    // Ataque do heroi (força + ataque especial da arma)
                    danoHeroi = this.forca + this.getArmaPrincipal().getAtaqueEspecial();
                    npc.receberDano(danoHeroi);
                    break;
                case 3:
                    // Mostrar inventário de consumíveis para escolher
                    System.out.println("Inventário de Consumíveis:");
                    int index = 1;
                    for (Consumivel consumivel : this.getInventario()) {
                        if(consumivel instanceof ConsumivelCombate) {
                            ConsumivelCombate consumivelCombate = (ConsumivelCombate) consumivel;
                            System.out.println(index + ". " + consumivelCombate.getNome());
                            index++;
                        }
                    }
                    System.out.println("Escolha o número do consumível a usar:");
                    int escolha = input.nextInt();

                    // Ataque do heroi (força + ataque especial da arma)
                    Consumivel consumivelEscolhido = this.getInventario().get(escolha);
                    this.usarConsumivel();
            }

            // Ataque do heroi (força + ataque da arma)
            danoHeroi = this.forca + this.getArmaPrincipal().getAtaque();
            npc.receberDano(danoHeroi); // Tirar dano à vida do npc

            if(npc.getHp() <= 0){
                System.out.println();
            }
        } while (true);



    }

    private void usarConsumivel(Consumivel consumivel, Entidade alvo) {
        if (consumivel instanceof ConsumivelCombate) {
            ConsumivelCombate consumivelCombate = (ConsumivelCombate) consumivel;
            int dano = consumivelCombate.getAtaqueInstantaneo();
            alvo.receberDano(dano); // Aplicar o efeito do consumível no alvo
            // Remover o consumível usado do inventário
            this.removeConsumivel(consumivel);
        } else {
            System.out.println("Este consumível não pode ser usado em combate.");
        }
    }


    @Override
    public void usarPocao() {

    }

    @Override
    public void usarConsumivel() {

    }

    @Override
    public void mostrarDetalhes() {

    }
}
