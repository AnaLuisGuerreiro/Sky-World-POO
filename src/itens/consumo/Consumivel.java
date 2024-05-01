package itens.consumo;

import itens.ItemHeroi;

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
