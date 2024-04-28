package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class Pocao extends Consumivel {
    private int vidaCurar;
    private int aumentoForca;

    /**
     * Construtor de uma poção
     * @param nome
     * @param preco
     * @param vidaCurar
     * @param aumentoForca
     */
    public Pocao(String nome, int preco, int vidaCurar, int aumentoForca) {
        super(nome, preco);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
        this.heroisPermitidos = null;
    }

    /**
     * Metodo para mostrar os detalhes da poção
     */
    @Override
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.print(" 🧪| +" + vidaCurar + " 🩸 | " + "+" + aumentoForca +" 💪🏽\n");
        System.out.println("🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫");

    }

    // --------------------------- Getters e setters dos atributos

    /**
     * @return quantidade de vida para recuperar
     */
    public int getVidaCurar() {
        return vidaCurar;
    }
}
