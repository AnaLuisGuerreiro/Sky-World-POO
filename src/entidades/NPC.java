package entidades;

public class NPC extends Entidade {
    private int ouro;

    public NPC(String nome, int maxHp, int forca, int ouro) {
        super(nome, maxHp, forca);
        this.ouro = ouro;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("-----------------------------------------------");
        System.out.print(" 👹 ");
        super.mostrarDetalhes();
        System.out.println("-----------------------------------------------");
    }

    public void restaurarVida(){
        hp = hpMax;
    }

    public int getOuro() {
        return ouro;
    }


}
