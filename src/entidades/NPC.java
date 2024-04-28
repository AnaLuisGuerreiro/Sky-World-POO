package entidades;

public class NPC extends Entidade {
    private int ouro;

    /**
     * Construtor de um npc
     * @param nome
     * @param maxHp
     * @param forca
     * @param ouro
     */
    public NPC(String nome, int maxHp, int forca, int ouro) {
        super(nome, maxHp, forca);
        this.ouro = ouro;
    }

    /**
     * Metodo para mostrar detalhes do npc
     */
    @Override
    public void mostrarDetalhes() {
        System.out.println("---------------------------------------------------");
        System.out.println(" 👹 | " + nome + " | Força: " + forca + " 💪🏽 | Hp: " + hp + "/" + hpMax + " 🩸");
        System.out.println("---------------------------------------------------");
    }

    /**
     * Metodo para restaurar a vida do npc para poder reutilizar noutras lutas
     * ou em vagas de inimigos
     */
    public void restaurarVida(){
        hp = hpMax;
    }

    // --------------------------- Getters e setters dos atributos

    /**
     * @return ouro que o npc dropa
     */
    public int getOuro() {
        return ouro;
    }

    public String  getNome() {
        return nome;
    }

}
