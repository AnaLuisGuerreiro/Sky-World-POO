package itens;

import java.util.ArrayList;

public abstract class ItemHeroi {
    protected String nome;
    protected int preco;
    protected ArrayList<String> heroisPermitidos;

    /**
     * Construtor de um item heroi
     * @param nome
     * @param preco
     */
    public ItemHeroi(String nome, int preco) {
        this.nome = nome;
        this.preco = preco;
        this.heroisPermitidos = new ArrayList<>();
    }

    /**
     * Metodo que mostra detalhes de um item heroi
     */
    public void mostrarDetalhes(){
        System.out.print("| " + preco + "🥮 | " + nome);
    };

    // --------------------------- Getters e setters dos atributos

    /**
     * @return nome do item do heroi
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return preço do item
     */
    public int getPreco() {
        return preco;
    }

    /**
     * @return a lista de herois permitidos a utilizar um determinado item
     */
    public ArrayList<String> getHeroisPermitidos() {
        return heroisPermitidos;
    }

}
