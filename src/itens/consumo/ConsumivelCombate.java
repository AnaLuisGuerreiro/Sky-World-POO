package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    /**
     * Construtor de um consumivel de combate
     * @param nome
     * @param preco
     * @param ataqueInstantaneo
     */
    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo) {
        super(nome, preco);
        this.ataqueInstantaneo = ataqueInstantaneo;
        this.heroisPermitidos = null;
    }

    /**
     * Metodo para mostrar os detalhes do consumivel de combate
     */
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.println(" 💊| +" + ataqueInstantaneo + " 🎯" );
        System.out.println("🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫🌫");
    }

    // --------------------------- Getters e setters dos atributos

    /**
     * @return ataque instantaneo do consumivel
     */
    public int getAtaqueInstantaneo(){
        return this.ataqueInstantaneo;
    }


}
