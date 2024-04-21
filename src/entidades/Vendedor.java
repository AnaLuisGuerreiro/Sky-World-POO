package entidades;

import itens.ItemHeroi;

import java.util.ArrayList;
import java.util.Collections;

public class Vendedor {
    private ArrayList<ItemHeroi> loja;

    public Vendedor(ArrayList<ItemHeroi> loja) {
        this.loja = new ArrayList<>();
    }

    public void imprimirLoja() {
        System.out.println("=== Mercado Celestial ===");

        // Baralhar os itens para apresentar
        Collections.shuffle(loja);

        int itens10 = Math.min(10, loja.size());

        for (int i = 0; i < itens10; i++) {
            ItemHeroi item = loja.get(i);
            item.mostrarDetalhes();
        }
    }
}

