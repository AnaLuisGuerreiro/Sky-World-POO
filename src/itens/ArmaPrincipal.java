package itens;

import entidades.Heroi;

import java.util.ArrayList;

public class ArmaPrincipal extends ItemHeroi {
    private int ataque;
    private int ataqueEspecial;

    public ArmaPrincipal(String nome, int preco, int ataque, int ataqueEspecial) {
        super(nome, preco);
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
    }


    @Override
    public void mostrarDetalhes() {
        System.out.println("| " + nome + " | " + preco + "🥮" + " | +" + ataque + "🗡" + " | +" + ataqueEspecial + "💥" + " | " + heroisPermitidos);
        System.out.println("--------------------------------------------------");
    }

    public void addHeroi(String heroisPermitidos){
        this.heroisPermitidos.add(heroisPermitidos);
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }
}
