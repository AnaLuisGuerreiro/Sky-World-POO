package entidades;

import efeitos.Efeitos;
import itens.ArmaPrincipal;
import itens.ItemHeroi;
import itens.consumo.Consumivel;
import itens.consumo.ConsumivelCombate;
import itens.consumo.Pocao;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi extends Entidade {
    private int nivel;
    protected int ouro;
    ArmaPrincipal armaPrincipal;
    protected ArrayList<Consumivel> inventario;
    Scanner input = new Scanner(System.in);


    public Heroi(String nome, int forca, int maxHp, int ouro,ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp);
        this.nivel = 1;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
    }

    public abstract Entidade atacar(NPC npc);

    public void heroiEscolherAtaque(NPC npc){
        int opcao, danoHeroi;

        // Escolher ataque
        System.out.println(Efeitos.YELLOW + Efeitos.BOLD + this.nome + Efeitos.RESET + " Escolhe o teu ataque!" + Efeitos.RESET);
        System.out.println("1.Ataque normal | 2.Ataque Especial |  3.Ataque consumivel");
        opcao = input.nextInt();

        switch (opcao) {
            case 1:
                // Ataque normal (força + ataque da arma)
                ataqueNormal(npc);
                break;
            case 2:
                // Ataque especial (força + ataque especial da arma)
                ataqueEspecial(npc);
                break;
            case 3:
                // Mostrar inventário de consumíveis para escolher e usar
                this.usarConsumivelCombate(npc);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
    }

    public void usarPocao(){
        ArrayList<Pocao> pocoes = new ArrayList<>();

        if(this.getInventario().size() > 0){
            for(Consumivel consumivel : this.getInventario()){
                if(consumivel instanceof Pocao){
                    pocoes.add((Pocao) consumivel);
                }
            }
        }
        for (int i = 0; i < pocoes.size(); i++) {
            System.out.print(i+1 + " ");
            pocoes.get(i).mostrarDetalhes();
        }

        System.out.println("Qual queres usar?");
        int opcao = input.nextInt();

       this.hp += pocoes.get(opcao).getVidaCurar();
    };

    public void addConsumivel(Consumivel item){
        this.getInventario().add(item);
    }
    public void usarConsumivelCombate(NPC npc) {
        // Mostrar os consumiveis disponiveis
        System.out.println("Inventário de Consumíveis:");
        int index = 1;
        for (Consumivel consumivel : this.getInventario()) {
            if (consumivel instanceof ConsumivelCombate) { // Buscar apenas os consumiveis de combate
                ConsumivelCombate consumivelCombate = (ConsumivelCombate) consumivel;
                System.out.println(index + ". " + consumivelCombate.getNome()); // Imprimir detalhes.
                index++;
            }
        }
        System.out.println("Escolha o número do consumível a usar:");
        int escolha = input.nextInt();

        if (escolha >= 1) { // Verificar se a escolha é valida
            Consumivel consumivelEscolhido = this.getInventario().get(escolha - 1); // Buscar ao inventario a escolha certa pelo indice
                ConsumivelCombate consumivelCombate = (ConsumivelCombate) consumivelEscolhido;
                int dano = consumivelCombate.getAtaqueInstantaneo(); // Dano do consumivel
                npc.receberDano(dano);
                this.removeConsumivel(consumivelEscolhido); // Remover o consumível do inventário
        } else {
            System.out.println(Efeitos.RED + "Inválido, tenta de novo." + Efeitos.RESET);
        }
    }
    public void ataqueNormal(NPC npc){
        // Forca + ataque normal da arma
        int danoHeroi = this.forca + this.getArmaPrincipal().getAtaque();
        npc.receberDano(danoHeroi); // Tirar dano à vida do npc
    }
    public void ataqueEspecial(NPC npc){
        // Forca + ataque especial da arma
        int danoHeroi = this.forca + this.getArmaPrincipal().getAtaqueEspecial();
        npc.receberDano(danoHeroi); // Causar dano ao npc
    }
    public void removeConsumivel(Consumivel removerConsumivel) {
        this.getInventario().remove(removerConsumivel);

    }

    public void aposVitoria(int ouroNpc){
        this.nivel++;
        this.hpMax += 10;
        this.forca++;
        this.ouro += ouroNpc;
    }

    // Getters e setters para os atributos
    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    public int getOuro() {
        return ouro;
    }

    public int setOuro(int i) {
        return ouro;
    }

    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }
}

