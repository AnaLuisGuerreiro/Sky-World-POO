package itens;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<String> heroisPermitidos;

    public ItemHeroi(String nome, int preco, ArrayList<String> heroisPermitidos) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = new ArrayList<>();
    }

    public void mostrarDetalhes() {
        System.out.println("|  " + nome + "  |  " + preco + "  |  " + heroisPermitidos + "  |");
    }
}
