package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int preco, ArrayList<String> heroisPermitidos, int ataqueInstantaneo) {
        super(nome, preco, heroisPermitidos);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.print(" | " + ataqueInstantaneo + " |");
    }

}
