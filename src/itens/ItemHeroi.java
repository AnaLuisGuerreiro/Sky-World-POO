package itens;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<String> heroisPermitidos;

    public ItemHeroi(String nome, int preco, ArrayList<String> heroisPermitidos) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = heroisPermitidos;
    }


    public abstract void mostrarDetalhes();



    // Getters do item
    public String getNome() {
        return nome;
    }

    public int getPreco() {
        return preco;
    }

    public ArrayList<String> getHeroisPermitidos() {
        return heroisPermitidos;
    }

}
