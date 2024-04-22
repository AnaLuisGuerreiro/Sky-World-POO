package itens;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<String> heroisPermitidos;

    public ItemHeroi(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = new ArrayList<String>();
    }

    public void mostrarDetalhes() {
        System.out.println("|  " + nome + "  |  " + preco + "  |  " + heroisPermitidos + "  |");
    }

    public int getPreco() {
        return preco;
    }

    public ArrayList<String> getHeroisPermitidos() {
        return heroisPermitidos;
    }
}
