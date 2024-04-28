package entidades;

public abstract class Entidade {
    protected String nome;
    protected int hpMax;
    protected int hp;
    protected int forca;

    /**
     * Construtor de uma entidade
     * @param nome da personagem
     * @param hpMax
     * @param forca
     */
    public Entidade(String nome, int hpMax, int forca) {
        this.nome = nome;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.forca = forca;
    }

    /**
     * Metodo para mostrar os detalhes de uma entidade
     */
    public void mostrarDetalhes(){
        System.out.print("| Nick: " + nome + " | Hp: " + hp + "/" + hpMax + " 🩸 | Força: " + forca + " 💪🏽");
    }

    /**
     * Metodo retirar dano à vida de uma entidade
     * @param dano a ser recebido
     * @return vida total depois do dano
     */
    public int receberDano(int dano){
        return this.hp -= dano;
    }

    // --------------------------- Getters e setters dos atributos

    /**
     * @return a força da entidade
     */
    public int getForca() {
        return this.forca;
    }

    /**
     * @return a vida da entidade
     */
    public int getHp() {
        return hp;
    }
    public int getHpMax(){
        return this.hpMax;
    }

    /**
     * Metodo para restabelecer a vida
     * @param hp da entidade
     */
    public void setHp(int novoHp) {
        this.hp = novoHp;
    }
    public void setHpMax(int novoMax){
        this.hpMax = novoMax;
    }
}
