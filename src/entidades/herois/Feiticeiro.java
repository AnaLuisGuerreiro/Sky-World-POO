package entidades.herois;

import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import itens.ArmaPrincipal;
import itens.consumo.Consumivel;

import java.util.ArrayList;

public class Feiticeiro extends Heroi {


    /*
            Construtor Feiticeiro
        */
    public Feiticeiro(String nome, int forca, int maxHp, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp, ouro, armaPrincipal);
    }

    @Override
    public Entidade atacar(Entidade npc) {
        return null;
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
