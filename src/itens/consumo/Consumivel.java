package itens.consumo;

import efeitos.Efeitos;
import itens.ItemHeroi;

import java.util.ArrayList;

public abstract class Consumivel extends ItemHeroi {

    /**
     * Construtor de um consumivel
     * @param nome
     * @param preco
     */
    public Consumivel(String nome, int preco) {
        super(nome, preco);
    }
}
