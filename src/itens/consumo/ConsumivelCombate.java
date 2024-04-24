package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo,ArrayList<String> heroisPermitidos) {
        super(nome, preco,heroisPermitidos);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    public void mostrarDetalhes(){
        System.out.print(" | " + ataqueInstantaneo + "🎯" );
    }

}
