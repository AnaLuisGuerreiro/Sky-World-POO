package entidades;

public abstract class Entidade {
    protected String nome;
    protected int maxHp;
    protected int hp;
    protected int forca;

    // Construtor da entidade
    public Entidade(String nome, int maxHp, int hp, int forca) {
        this.nome = nome;
        this.maxHp = 100; // Max vida inicial (100)
        this.hp = maxHp;  // Hp inicial (100)
        this.forca = forca;
    }

    /**
     * Exibir detalhes da entidade
     */
    public void mostrarDetalhes(){
        System.out.println("--------------------------------------------");
        System.out.println("Nick: " + nome + " | " + "Força: " + forca + " | HP: " + hp + "/" + maxHp);
        System.out.println("--------------------------------------------");

    }

    public abstract void atacar(NPC inimigo); // Metodo abstrato para atacar um NPC

    public int getHp() {
        return hp;
    }

    public int getForca() {
        return forca;
    }
}
