package itens;

import entidades.Heroi;

import java.util.ArrayList;

public class ArmaPrincipal extends ItemHeroi {
    private int ataque;
    private int ataqueEspecial;

    /**
     * Construtor para uma Arma
     * @param nome
     * @param preco
     * @param ataque
     * @param ataqueEspecial
     */
    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }

    /**
     * Metodo para mostrar os detalhes de cada arma
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println(" ⚔ | +" + ataque + " 🗡" + " | +" + ataqueEspecial + " 💥" + " | " + heroisPermitidos);
        System.out.println("🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫");
    }

    /**
     * Metodo para adicionar os herois permitidos a utilizar cada arma
     * @param heroisPermitidos (classes de herois)
     */
    public void addHeroi(String heroisPermitidos){
        this.heroisPermitidos.add(heroisPermitidos);
    }

    // --------------------------- Getters e setters dos atributos

    /**
     * @return o dano de um ataque normal
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * @return o dano de um ataque especial
     */
    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
}
