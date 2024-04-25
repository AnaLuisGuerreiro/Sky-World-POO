package itens.consumo;

import efeitos.Efeitos;
import itens.ItemHeroi;

import java.util.ArrayList;

public abstract class Consumivel extends ItemHeroi {

    public Consumivel(String nome, int preco) {
        super(nome, preco);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.print("| " + nome + "  |  " + preco + "🥮 |");
    }
}
