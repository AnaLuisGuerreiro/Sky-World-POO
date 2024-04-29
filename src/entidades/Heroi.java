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

    /**
     * Construtor de um Heroi
     *
     * @param nome
     * @param forca
     * @param maxHp
     * @param ouro
     * @param armaPrincipal
     */
    public Heroi(String nome, int forca, int maxHp, int ouro, ArmaPrincipal armaPrincipal) {
        super(nome, forca, maxHp);
        this.nivel = 1;
        this.ouro = ouro;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }

    /**
     * Metodo para mostrar detalhes de um heroi
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println(" | " + ouro + " 🥮");
    }

    /**
     * Metodo de combate entre heroi e npc, diferente em cada heroi
     *
     * @param npc inimigo
     * @return vencedor (heroi/npc)
     */
    public abstract Entidade atacar(NPC npc);

    /**
     * Metodo para escolher um dos 3 ataques possiveis
     *
     * @param npc inimigo para retirar vida
     */
    public void heroiEscolheAtaque(NPC npc) {
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

    /**
     * Metodo para mostrar e poder selecionar uma poção para usar
     */
    public void usarPocao() {
        ArrayList<Pocao> pocoes = new ArrayList<>(); // Guardar apenas as poções
        ArrayList<ConsumivelCombate> consumiveisCombate = new ArrayList<>(); // Guardar apenas as poções


        System.out.println("=== 🎒 Inventário consumiveis 🎒 ===");
        if (!this.getInventario().isEmpty()) { // Verificar se o inventário não está vazio
            for (Consumivel consumivel : this.getInventario()) {
                if (consumivel instanceof Pocao) { // Verificar os consumiveis que sejam poção
                    pocoes.add((Pocao) consumivel); // Adicionar ao novo array de poções
                }
            }
            for (Consumivel consumivelCombate : this.getInventario()) {
                if (consumivelCombate instanceof ConsumivelCombate) { // Buscar apenas os consumiveis de combate
                    consumiveisCombate.add((ConsumivelCombate) consumivelCombate);
                }
            }

            // Ciclo para mostrar as poçoes
            for (int i = 0; i < pocoes.size(); i++) {
                System.out.print(i + 1 + " ");
                pocoes.get(i).mostrarDetalhes();
            }

            System.out.println("Seleciona a poçao que queres usar:");
            int opcao = input.nextInt();

            this.hp += pocoes.get(opcao).getVidaCurar(); // Curar vida de heroi
            this.forca += pocoes.get(opcao).getAumentoForca(); // Aumentar força de heroi
        } else {
            System.out.println("Sem poções no inventário.");
        }

    }

    /**
     * Metodo para executar um ataque normal contra um npc
     *
     * @param npc a qual vai dar o dano
     */
    public void ataqueNormal(NPC npc) {
        // Forca + ataque normal da arma
        int danoHeroi = this.forca + this.getArmaPrincipal().getAtaque();
        npc.receberDano(danoHeroi); // Tirar dano à vida do npc
    }

    /**
     * Metodo para executar um ataque especial contra um npc
     *
     * @param npc a qual vai dar o dano
     */
    public void ataqueEspecial(NPC npc) {
        // Forca + ataque especial da arma
        int danoHeroi = this.forca + this.getArmaPrincipal().getAtaqueEspecial();
        npc.receberDano(danoHeroi); // Causar dano ao npc
    }

    /**
     * Metodo para atacar com um consumivel, mostra o inventario desses mesmos itens
     * e pode selecionar um para atacar
     *
     * @param npc a qual vai ser retirada vida
     */
    private void usarConsumivelCombate(NPC npc) {
        ArrayList<ConsumivelCombate> consumiveisCombate = new ArrayList<>(); // Guardar apenas as poções

        // Mostrar os consumiveis disponiveis
        System.out.println("Inventário de Consumíveis:");

        if(!this.getInventario().isEmpty()) {
            for (Consumivel consumivelCombate : this.getInventario()) {
                if (consumivelCombate instanceof ConsumivelCombate) { // Buscar apenas os consumiveis de combate
                    consumiveisCombate.add((ConsumivelCombate) consumivelCombate);
                }
            }
        } else{
            System.out.println("Não tens consumiveis de combate no inventário.");
            return;
        }

        int escolha;

        do {
            System.out.println("Escolha o número do consumível a usar (0.Sair):");
            escolha = input.nextInt();

            if (escolha >= 1 && escolha <= this.getInventario().size()) { // Verificar se a escolha é valida
                ConsumivelCombate consumivelEscolhido = consumiveisCombate.get(escolha - 1); // Indice real do consumivel
                int dano = (consumivelEscolhido).getAtaqueInstantaneo(); // Dano do consumivel
                npc.receberDano(dano);
                this.removeConsumivel(consumivelEscolhido); // Remover o consumível do inventário
            } else {
                System.out.println(Efeitos.RED + "Inválido, tenta de novo." + Efeitos.RESET);
            }
        }while (escolha < 1 );
    }

    /**
     * Adiciona um consumivel ao inventario do heroi
     *
     * @param consumivel a ser adicionado
     */
    public void addConsumivel(Consumivel consumivel) {
        this.getInventario().add(consumivel);
    }

    /**
     * Metodo para remover consumivel do inventário
     *
     * @param consumivel
     */
    public void removeConsumivel(Consumivel consumivel) {
        this.getInventario().remove(consumivel);
    }

    /**
     * Metodo para adicionar todos os ganhos por derrotar um npc
     *
     * @param ouroNpc
     */
    public void aposVitoria(int ouroNpc) {
        this.nivel++;
        this.hpMax += 10;
        this.forca++;
        this.ouro += ouroNpc;
    }

    public void rondasInimigos(Heroi jogador, int numInimigos, NPC bot) {
        for (int i = 0; i < numInimigos; i++) {
            System.out.println("Turno " + (i + 1) + ":");
            jogador.atacar(bot); // Jogador ataca o bot
            System.out.println(); // Pular linha entre os turnos
        }
    }

    // --------------------------- Getters e setters dos atributos

    /**
     * @return inventário do heroi
     */
    public ArrayList<Consumivel> getInventario() {
        return inventario;
    }

    /**
     * @return arma principal do heroi
     */
    public ArmaPrincipal getArmaPrincipal() {
        return armaPrincipal;
    }

    /**
     * @return ouro do heroi
     */
    public int getOuro() {
        return ouro;
    }

    public String getNome() {
        return this.nome;
    }

    /**
     * Metodo para atualizar o ouro do heroi com ouro ganho
     *
     * @param ganhos
     * @return total de ouro
     */
    public int setOuro(int ganhos) {
        return this.ouro;
    }

    /**
     * Metodo para tornar uma arma na arma principal do heroi
     *
     * @param armaPrincipal
     */
    public void setArmaPrincipal(ArmaPrincipal armaPrincipal) {
        this.armaPrincipal = armaPrincipal;
    }
}

