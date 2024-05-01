package entidades;

public abstract class Entidade {
    protected String nome;
    protected int hpMax;
    protected int hp;
    protected int forca;

    protected int hpMaxInicial;
    protected int hpInicial;
    protected int forcaInicial;

    public void setHpMaxInicial(int hpMaxInicial) {
        this.hpMaxInicial = hpMaxInicial;
    }

    public void setHpInicial(int hpInicial) {
        this.hpInicial = hpInicial;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setForcaInicial(int forcaInicial) {
        this.forcaInicial = forcaInicial;
    }

    public int getHpMaxInicial() {
        return hpMaxInicial;
    }

    public int getHpInicial() {
        return hpInicial;
    }

    public int getForcaInicial() {
        return forcaInicial;
    }

    /**
     * Construtor de uma entidade
     * @param nome da personagem
     * @param hpMax
     * @param forca
     */
    public Entidade(String nome, int hpMax, int forca, int hpMaxInicial, int forcaInicial) {
        this.nome = nome;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.forca = forca;
        this.hpMaxInicial = hpMaxInicial;
        this.hpInicial = hpMaxInicial;
        this.forcaInicial = forcaInicial;
    }

    public Entidade(String nome, int hpMax, int forca) {
        this.nome = nome;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.forca = forca;
        this.hpMaxInicial = hpMaxInicial;
        this.hpInicial = hpMaxInicial;
        this.forcaInicial = forcaInicial;
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
     * @param novoHp da entidade
     */
    public void setHp(int novoHp) {
        this.hp = novoHp;
    }
    public void setHpMax(int novoMax){
        this.hpMax = novoMax;
    }
}
