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

    /**
     * Construtor de vendedor
     */
    public Vendedor() {
        this.loja = new ArrayList<>();
    }

    /**
     * Metodo para imprimir loja (apenas 10 itens)
     */
    public void imprimirLoja() {
        System.out.println("          === 🌟🌌 Mercador Celestial 🌌🌟 ===");

        int numItens = loja.size(); // Quantidade de itens disponiveis

        // Verificar se loja tem itens
        if (numItens == 0) {
            System.out.println("Ups...sem stock de itens. Tenta numa proxima!");
            return;
        }

        // Mostrar máximo 10 itens senão mostra número de itens da loja
        int numItensMostrar = Math.min(10, numItens);

        Collections.shuffle(loja); // Baralhar a lista de itens

        // Ciclo para mostrar os 10 itens
        for (int i = 0; i < numItensMostrar; i++) {
            ItemHeroi item = loja.get(i); // Guardar item por id
            System.out.print(i+1 + " ");
            item.mostrarDetalhes();
        }
    }

    /**
     * Metodo para vender um item (consumiveis ou armas)
     * @param heroi jogador que quer comprar
     * @param item e item escolhido pelo index
     */
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

        String classeDoHeroi = heroi.getClass().getName(); // Guardar classe do heroi que quer comprar
        // Herois a null é consumivel
        if(itemSelecionado.getHeroisPermitidos() == null){
            heroi.addConsumivel((Consumivel) itemSelecionado);
            // Verificar uso permitido por tipo de classe(heroi)
        } else if(!itemSelecionado.getHeroisPermitidos().contains(classeDoHeroi)){
            System.out.println("Esse item não é para ti.");
            return;
        }

        // Compra com sucesso
        if(itemSelecionado instanceof ArmaPrincipal){
            heroi.setArmaPrincipal((ArmaPrincipal) itemSelecionado); // Tornar arma a ArmaPrincipal do heroi
            System.out.println("Parabéns " + Efeitos.BOLD + itemSelecionado.getNome());
        } else{
            heroi.getInventario().add((Consumivel) itemSelecionado); // Adicionar item ao inventário do heroi
            System.out.println("Parabéns, compraste o consumivel " + Efeitos.BOLD + itemSelecionado.getNome());
        }

        // Retirar valor do item ao ouro do heroi
        heroi.setOuro(heroi.ouro - itemSelecionado.getPreco());

        // Remover item da loja
        loja.remove(itemSelecionado);
    }

    /**
     * Metodo para adicionar um item à loja
     * @param itemNovo (consumiveis ou armas)
     */
    public void addItem(ItemHeroi itemNovo){
        loja.add(itemNovo);
    }

    // --------------------------- Getters e setters dos atributos

    /**
     * Metodo para retornar a loja
     * @return a loja (os seus itens)
     */
    public ArrayList<ItemHeroi> getLoja() {
        return loja;
    }
}

