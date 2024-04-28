package entidades.herois;

import efeitos.Efeitos;
import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import itens.ArmaPrincipal;

public class Arqueiro extends Heroi {

    /*
            Construtor de Arqueiro
    */
    public Arqueiro(String nome, int forca, int maxHp, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp, ouro, armaPrincipal);
    }

    @Override
    public Entidade atacar(NPC npc) {
        do {
            npc.mostrarDetalhes(); // Mostrar npc
            heroiEscolheAtaque(npc); // Escolha do ataque

            if (npc.getHp() <= 0) { // Verificar vida de npc apos ataque de heroi
                Efeitos.escrever(Efeitos.GREEN + "Derrotaste o " + npc.getNome() + ". Ganhaste " + npc.getOuro() + "🥮" + Efeitos.RESET);
                this.aposVitoria(npc.getOuro()); // Ganhos do heroi pela vitoria
                npc.restaurarVida(); // Restaura vida de npc para poder reutilizar
                this.mostrarDetalhes();
                return this; // Retorna heroi como vencedor
            }

            // Ataque do npc
            int danoNpc = npc.getForca();
            int danoRecebido = (int) (danoNpc * 1.1);
            this.receberDano(danoRecebido); // Vida heroi - força do npc com mais 10%

            if (this.hp <= 0) { // Verificar vida de heroi apos ataque de npc
                System.out.println(Efeitos.RED + this.nome + " foste derrotado por " + npc.getNome() + Efeitos.RESET);
                return npc; // Retorna o NPC como vencedor
            }
        } while (true);
    }

    @Override
    public void usarPocao() {
        super.usarPocao();
    }


    /**
     * Metodo para mostrar detalhes de Arqueiro
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("----------------------------------------------------");
        System.out.print(" 🧝🏽️️ ");
        super.mostrarDetalhes();
        System.out.println("----------------------------------------------------");
    }
}
