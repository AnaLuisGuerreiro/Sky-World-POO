package entidades.herois;

import efeitos.Efeitos;
import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import itens.ArmaPrincipal;
import itens.consumo.Consumivel;

import java.util.ArrayList;

public class Feiticeiro extends Heroi {


    /**
     * Construtor de um Feiticeiro
     * @param nome
     * @param forca
     * @param maxHp
     * @param ouro
     * @param armaPrincipal
     */
    public Feiticeiro(String nome, int forca, int maxHp, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp, ouro, forca, maxHp, ouro, armaPrincipal);
    }

    /**
     * Metodo de combate
     * @param npc - inimigo
     * @return um vencedor (npc ou heroi)
     */
    @Override
    public Entidade atacar(NPC npc) {
        do {
            npc.mostrarDetalhes(); // Detalhes do npc
            heroiEscolheAtaque(npc); // Heroi escolhe ataque

            if (npc.getHp() <= 0) { // Verificar vida de npc apos ataque de heroi
                Efeitos.escrever(Efeitos.GREEN + "Derrotaste o " + npc.getNome() + ". Ganhaste " + npc.getOuro() + "🥮" + Efeitos.RESET);
                this.aposVitoria(npc.getOuro()); // Ganhos do heroi pela vitoria
                npc.restaurarVida(); // Restaura vida de npc para poder reutilizar
                this.mostrarDetalhes();
                return this; // Retorna heroi como vencedor
            }

            // Ataque do npc
            Efeitos.escrever(Efeitos.RED + "O " + npc.getNome() + " atacou-te." + Efeitos.RESET);
            int danoNpc = npc.getForca();
            this.receberDano(danoNpc); // Vida heroi - ataque
            this.mostrarDetalhes();

            if (this.hp <= 0) { // Verificar vida de heroi apos ataque de npc
                System.out.println(Efeitos.RED + this.nome + " foste derrotado por " + npc.getNome() + Efeitos.RESET);
                return npc; // Retorna o NPC como vencedor
            }
        } while (true);
    }

    /**
     * Metodo para usar poção para aumentar vida ou força
     */
    @Override
    public void usarPocao() {
        super.usarPocao();
    }

    /**
     * Metodo para mostrar detalhes da personagem
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("--------------------------------------------------------------");
        System.out.print(" 🧙🏽‍♂️️ ");
        super.mostrarDetalhes();
        System.out.println("--------------------------------------------------------------");
    }
}
