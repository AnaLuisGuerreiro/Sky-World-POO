package entidades;

public abstract class Entidade {
    protected String nome;
    protected int hpMax;
    protected int hp;
    protected int forca;

    /*
       Construtor de Entidade
     */
    public Entidade(String nome, int hpMax, int forca) {
        this.nome = nome;
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.forca = forca;
    }

    public void mostrarDetalhes(){
        System.out.println("| Nick: " + nome + " | Força " + forca + " | Hp: " + hp + "/" + hpMax);
    }

    public int receberDano(int dano){
        return this.hp -= dano;
    }

    // Getters e setters para os atributos
    public String getNome() {
        return nome;
    }

    public int getForca() {
        return this.forca;
    }

    public int getHp() {
        return hp;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }
}
