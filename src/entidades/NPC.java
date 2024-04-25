package entidades;

public class NPC extends Entidade {
    private int ouro;

    public NPC(String nome, int maxHp, int forca, int ouro) {
        super(nome, maxHp, forca);
        this.ouro = ouro;
    }

    public Entidade atacar(Entidade heroi) {
        return null;
    }


    @Override
    public void mostrarDetalhes() {

    }

    // Getter para o atributo ouro
    public int getOuro() {
        return ouro;
    }


}
