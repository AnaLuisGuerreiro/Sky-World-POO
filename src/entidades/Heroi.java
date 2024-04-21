package entidades;

import itens.ArmaPrincipal;
import itens.consumo.Consumivel;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    private int nivel ;
    private int ouro;
    private ArmaPrincipal armaPrincipal;
    private ArrayList<Consumivel> inventario;

    public Heroi(String nome, int maxHp, int hp, int forca, int nivel, int ouro, ArmaPrincipal armaPrincipal, ArrayList<Consumivel> inventario) {
        super(nome, maxHp, hp, forca);
        this.nivel = 1; // Nivel inicial
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    public abstract void atacar(NPC inimigo);
}
