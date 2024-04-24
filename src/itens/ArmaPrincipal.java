package itens;

import entidades.Heroi;

import java.util.ArrayList;

public class ArmaPrincipal extends ItemHeroi {
    private int ataque;
    private int ataqueEspecial;

    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial, ArrayList<String> heroisPermitidos) {
        super(nome, preco, heroisPermitidos);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }


    @Override
    public void mostrarDetalhes() {
        System.out.println("| " + nome + " | " + preco + "🥮" + " | +" + ataque + "🗡" + " | +" + ataqueEspecial + "💥" + " | " + heroisPermitidos);
        System.out.println("--------------------------------------------------");
    }
}
