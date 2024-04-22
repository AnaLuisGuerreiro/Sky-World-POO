package entidades;

import itens.ArmaPrincipal;
import itens.ItemHeroi;
import itens.consumo.Consumivel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Vendedor {
    private ArrayList<ItemHeroi> loja;
    private Random random;

    public Vendedor(ArrayList<ItemHeroi> loja) {
        this.loja = new ArrayList<>();
        this.random = new Random();
    }

    /**
     * Metodo para imprimir 10 items da loja
     */
    public void imprimirLoja() {
        System.out.println("=== Mercado Celestial ===");

        int totalItens = loja.size();
        int itensParaMostrar = Math.min(10, totalItens);

        for (int i = 0; i < itensParaMostrar; i++) {
            int indexAleatorio = random.nextInt(totalItens);
            ItemHeroi item = loja.get(indexAleatorio);
            item.mostrarDetalhes();
        }
    }


    public void vender(Heroi heroi, ItemHeroi item){
        if (loja.contains(item) && heroi.ouro >= item.getPreco()) {
            loja.remove(item);
            heroi.ouro -= item.getPreco();
            if (item instanceof ArmaPrincipal) {
                heroi.setArmaPrincipal((ArmaPrincipal) item);
            } else {
                heroi.inventario.add((Consumivel) item);
            }
            System.out.println("Aqui tens o teu item, dá-lhe bom uso!");
        } else {
            System.out.println("Bem... aconcelho-te a arranjar ouro antes que esgote.");
        }

    }
}

