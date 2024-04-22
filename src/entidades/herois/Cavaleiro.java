package entidades.herois;

import entidades.Heroi;
import entidades.NPC;
import itens.ArmaPrincipal;
import itens.consumo.Consumivel;

import java.util.ArrayList;

public class Cavaleiro extends Heroi {


    public Cavaleiro(String nome, int maxHp, int hp, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario) {
        super(nome, maxHp, hp, forca, nivel, ouro, armaPrincipal, inventario);
    }


    @Override
    public void atacar(NPC inimigo) {
        if (inimigo.getHp() > this.forca){
            this.hp -= (int) (inimigo.getForca() - 0.8);
        }

        if(this.hp > inimigo.getForca()){
        }
    }
}
