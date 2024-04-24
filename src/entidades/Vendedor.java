package entidades;

import efeitos.Efeitos;
import itens.ArmaPrincipal;
import itens.ItemHeroi;
import itens.consumo.Consumivel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Vendedor {
    private ArrayList<ItemHeroi> loja;

    public Vendedor() {
        this.loja = new ArrayList<>();
    }

    /**
     * Metodo para imprimir 10 items da loja
     */
    public void imprimirLoja() {
        System.out.println("=== Mercado Celestial ===");

        int numItens = loja.size(); // Quantidade de itens disponiveis

        // Verificar se loja tem itens
        if (numItens == 0) {
            System.out.println("Ups...sem stock de itens. Tenta numa proxima!");
            return;
        }

        // Mostrar máximo 10 itens senão mostra número de itens da loja
        int numItensMostrar = Math.min(10, numItens);

        Collections.shuffle(loja); // Baralhar a lista de itens

        // Ciclo para mostrar os itens
        for (int i = 0; i < numItensMostrar; i++) {
            ItemHeroi item = loja.get(i);
            System.out.print(i+1 + " ");
            item.mostrarDetalhes();
        }
    }


    public void vender(Heroi heroi, int item) {
        ItemHeroi itemSelecionado = loja.get(item - 1); // Indice real do item

        // Erro de seleção
        if(item < 1 || item > loja.size()){
            System.out.println("Esse item não existe guerreiro...");
            return;
        }

        // Heroi sem dinheiro
        if(heroi.ouro < itemSelecionado.getPreco()){
            System.out.println("Hahaha... não fazemos caridade " + heroi.getClass().getName());
            return;
        }

        // Verificar uso permitido por tipo de classe(heroi)
        if(!itemSelecionado.getHeroisPermitidos().contains(heroi.getClass().getName())){
            System.out.println("Esse item não é para ti.");
            return;
        }

        // Compra com sucesso
        if(itemSelecionado instanceof ArmaPrincipal){
            heroi.setArmaPrincipal((ArmaPrincipal) itemSelecionado); // Tornar arma a ArmaPrincipal do heroi
            System.out.println("Parabéns " + Efeitos.BOLD + itemSelecionado.getNome());
        } else{
            heroi.getInventario().add((Consumivel) itemSelecionado); // Adicionar item ao inventário
            System.out.println("Parabéns, compraste o consumivel " + Efeitos.BOLD + itemSelecionado.getNome());
        }

        // Retirar valor do item ao ouro do heroi
        heroi.setOuro(heroi.ouro - itemSelecionado.getPreco());

        // Remover item da loja
        loja.remove(itemSelecionado);
    }

    public void addItem(ItemHeroi itemNovo){
        loja.add(itemNovo);
    }

    public ArrayList<ItemHeroi> getLoja() {
        return loja;
    }
}

