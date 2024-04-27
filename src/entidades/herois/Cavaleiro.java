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

    /**
     * Construtor de um Cavaleiro
     * @param nome
     * @param forca
     * @param maxHp
     * @param ouro
     * @param armaPrincipal
     */
    public Cavaleiro(String nome, int forca, int maxHp, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp, ouro, armaPrincipal);
    }

    /**
     * Metodo para combater um npc, em que o npc ataca primeiro
     * @param npc inimigo
     * @return vencedor (npc/heroi)
     */
    @Override
    public Entidade atacar(NPC npc) {
        int danoNpc; // Guardar força do npc

        npc.mostrarDetalhes();
        Efeitos.escrever(Efeitos.YELLOW + "👹 vai atacar! Cuidado!!" + Efeitos.RESET);

        // Inimigo ataca primeiro
        danoNpc = (int) (npc.getForca() * 0.8); // Primeiro ataque apenas 80% da força inicial
        this.receberDano(danoNpc); // Retirar dano à vida do heroi
        this.mostrarDetalhes(); // Mostrar detalhes de heroi

        // Heroi derrotado pelo primeiro ataque
        if (this.hp <= 0) {
            System.out.println(this.nome + " foste derrotado por " + npc.getNome());
            return npc; // Retorna inimigo (vencedor)
        }

        do {
            heroiEscolheAtaque(npc);

            if (npc.getHp() <= 0) { // Verificar vida de npc apos ataque de heroi
                Efeitos.escrever(Efeitos.GREEN + "Derrotaste o " + npc.getNome() + ". Ganhaste " + npc.getOuro() + "🥮" + Efeitos.RESET);
                this.aposVitoria(npc.getOuro()); // Ganhos do heroi pela vitoria
                npc.restaurarVida(); // Restaura vida de npc para poder reutilizar
                this.mostrarDetalhes();
                return this; // Retorna heroi como vencedor
            }

            // Ataque do npc
            danoNpc = npc.getForca();
            this.receberDano(danoNpc); // Vida heroi - ataque

            if (this.hp <= 0) { // Verificar vida de heroi apos ataque de npc
                System.out.println(Efeitos.RED + this.nome + " foste derrotado por " + npc.getNome() + Efeitos.RESET);
                return npc; // Retorna o NPC como vencedor
            }
        } while (true);

    }

    /**
     * Metodo para usar pocao (vida ou força)
     */
    @Override
    public void usarPocao() {
        super.usarPocao();
    }

    /**
     * Metodo para mostrar detalhes do cavaleiro
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("-----------------------------------------------");
        System.out.print(" 🏇🏽 ");
        super.mostrarDetalhes();
        System.out.println("-----------------------------------------------");

    }


}
