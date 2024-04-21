package itens.consumo;

import itens.consumo.Consumivel;

import java.util.ArrayList;

public class Pocao extends Consumivel {
    private int vidaCurar;
    private int aumentoForca;

    public Pocao(String nome, int preco, ArrayList<String> heroisPermitidos, int vidaCurar, int aumentoForca) {
        super(nome, preco, heroisPermitidos);
        this.vidaCurar = vidaCurar;
        this.aumentoForca = aumentoForca;
    }

    public void mostrarDetalhes(){
        super.mostrarDetalhes();
        System.out.print(" | " + "+" + vidaCurar + "🩸 | " + "+" + aumentoForca +"💪🏽");
    }
}
