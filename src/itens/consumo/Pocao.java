package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class Pocao extends Consumivel {
    private int vidaCurar;
    private int aumentoForca;

    public Pocao(String nome, int preco, int vidaCurar, int aumentoForca, ArrayList<String> heroisPermitidos) {
        super(nome, preco, heroisPermitidos);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    @Override
    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.print(" " + vidaCurar + "🩸 | " + "+" + aumentoForca +"💪🏽\n");
        System.out.println("-------------------------------------------------");

    }

}
