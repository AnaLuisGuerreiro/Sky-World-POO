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
    public Feiticeiro(String nome, int forca, int maxHp) {
        super(nome, forca, maxHp);
    }

    @Override
    public Entidade atacar(Entidade inimigo) {
        return null;
    }

    @Override
    public void usarPocao() {

    }

    @Override
    public void mostrarDetalhes() {

    }
}
