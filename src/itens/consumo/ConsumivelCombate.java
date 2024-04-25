package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class ConsumivelCombate extends Consumivel {
    private int ataqueInstantaneo;

    public ConsumivelCombate(String nome, int preco, int ataqueInstantaneo) {
        super(nome, preco);
        this.ataqueInstantaneo = ataqueInstantaneo;
    }

    public void mostrarDetalhes(){
        System.out.print(" | " + ataqueInstantaneo + "🎯" );
    }

    public int getAtaqueInstantaneo(){
        return this.ataqueInstantaneo;
    }
    public String getNome(){
        return this.nome;
    }
}
