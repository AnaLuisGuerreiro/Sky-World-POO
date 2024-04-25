package entidades;

import itens.ArmaPrincipal;
import itens.consumo.Consumivel;

import java.util.ArrayList;

public abstract class Heroi extends Entidade {
    private int nivel;
    protected int ouro;
    ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;


    public Heroi(String nome, int forca, int maxHp, int ouro,ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp);
        this.nivel = 1;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    public abstract Entidade atacar(Entidade npc);

    public abstract void usarPocao();

    public abstract void usarConsumivel();

    public void removeConsumivel(Consumivel removerConsumivel) {
        this.getInventario().remove(removerConsumivel);

    }

    public void aposVitoria(int ouroNpc){
        this.nivel++;
        this.ouro += ouroNpc;
        this.forca++;
        this.hp += 10;
    }

    // Getters e setters para os atributos
    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public int setOuro(int i) {
        return ouro;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }
}
