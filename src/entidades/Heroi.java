package entidades;

import itens.ArmaPrincipal;
import itens.consumo.Consumivel;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    private int nivel ;
    protected int ouro;
    ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;


    public Heroi(String nome, int forca, int maxHp) {
        super(nome, forca, maxHp);
        this.nivel = 1;
        this.ouro = 0;
        this.inventario = new ArrayList<>();
    }

    public abstract Entidade atacar(Entidade npc);

    public void mostrarInventario() {
    }

    public void usarPocao() {
    }

    // Getters e setters para os atributos

    public int setOuro(int i) {
        return ouro;
    }


    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }

    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }
}
