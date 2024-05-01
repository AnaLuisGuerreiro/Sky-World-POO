package entidades;

import efeitos.Efeitos;
import itens.ArmaPrincipal;
import itens.consumo.Consumivel;
import itens.consumo.ConsumivelCombate;
import itens.consumo.Pocao;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Heroi extends Entidade {
    private int nivel;
    protected int ouro;
    ArmaPrincipal armaPrincipal;

    private int ouroInicial;

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
    public Heroi(String nome, int forca, int maxHp,  int ouro,int maxHpInicial, int forcaInicial, int ouroInicial, ArmaPrincipal armaPrincipal) {
        super(nome, maxHp, forca, maxHpInicial, forcaInicial);
        this.nivel = 1;
        this.ouro = ouro;
        this.ouroInicial = ouroInicial;
        this.armaPrincipal = armaPrincipal;
        this.inventario = new ArrayList<>();
    }


    /**
     * Metodo para mostrar detalhes de um heroi
     */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println(" +" + armaPrincipal.getAtaque() + " 🗡 | " + ouro + " 🥮");
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

        System.out.println("=== 🧪 Inventário de Poções 🧪 ===");
        if (!this.getInventario().isEmpty()) { // Verificar se o inventário não está vazio
            for (Consumivel consumivel : this.getInventario()) {
                if (consumivel instanceof Pocao) { // Verificar os consumiveis que sejam poção
                    pocoes.add((Pocao) consumivel); // Adicionar ao novo array de poções
                }
            }

            // Ciclo para mostrar as poçoes
            for (int i = 0; i < pocoes.size(); i++) {
                System.out.print(i + 1 + " ");
                pocoes.get(i).mostrarDetalhes();
            }

            System.out.println("Seleciona a poçao que queres usar: (0.Sair)");
            int opcao = input.nextInt();

            int diferencaHpMaxHp = this.hpMax - pocoes.get(opcao-1).getVidaCurar() + this.hp;
            if(diferencaHpMaxHp >= 0){
                this.hp += pocoes.get(opcao-1).getVidaCurar(); // Curar vida de heroi
            } else{
                System.out.println("Serão desperdiçados " + diferencaHpMaxHp + " de vida da poção. Pretendes utilizar na mesma?(s/n)");
                String letra = input.next();
                if(letra.equalsIgnoreCase("s")){
                    this.hp = this.hpMax;
                }
            }

            this.forca += pocoes.get(opcao-1).getAumentoForca(); // Aumentar força de heroi
        } else {
            System.out.println("Sem poções no inventário.\n");
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
        System.out.println("=== 💊 Inventário de Consumiveis 💊 ===");


        if(!this.getInventario().isEmpty()) {
            for (Consumivel consumivel : this.getInventario()) {
                if (consumivel instanceof ConsumivelCombate) { // Buscar apenas os consumiveis de combate
                    consumiveisCombate.add((ConsumivelCombate) consumivel);
                }
            }
        } else{
            System.out.println("Não tens consumiveis de combate no inventário.\n");
            return;
        }

        int escolha, i=1;


        for (Consumivel consumivel : consumiveisCombate) {
            System.out.print(i + ".");
            consumivel.mostrarDetalhes();
            i++;
        }
        do {

            System.out.println("Escolha o número do consumível a usar (0.Sair):");
            escolha = input.nextInt();

            if (escolha > 0 && escolha <= this.getInventario().size()) { // Verificar se a escolha é valida
                ConsumivelCombate consumivelEscolhido = consumiveisCombate.get(escolha - 1); // Indice real do consumivel
                int dano = (consumivelEscolhido).getAtaqueInstantaneo(); // Dano do consumivel
                npc.receberDano(dano);
                this.removeConsumivel(consumivelEscolhido); // Remover o consumível do inventário
            } else if (escolha < 0 || escolha > this.getInventario().size()){
                System.out.println(Efeitos.RED + "Inválido, tenta de novo." + Efeitos.RESET);
            }
        }while (escolha != 0);
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

    public Entidade rondasInimigos(Heroi jogador, int numInimigos, NPC bot) {
        Entidade vencedor = null;

        for (int i = 0; i < numInimigos; i++) {
            System.out.println("Turno " + (i + 1) + ":");
            vencedor = jogador.atacar(bot); // Jogador ataca o bot
            System.out.println(); // Pular linha entre os turnos
        }

        return vencedor;
    }

    public Entidade resetStats(Heroi jogador){
        jogador.setHp(jogador.getHpInicial());
        jogador.setForca(jogador.getForcaInicial());
        jogador.setOuro(jogador.getOuroInicial());
        jogador.setHpMax(jogador.getHpMaxInicial());

        return jogador;
    }

    // --------------------------- Getters e setters dos atributos

    public int getOuroInicial() {
        return ouroInicial;
    }

    public void setOuroInicial(int ouroInicial) {
        this.ouroInicial = ouroInicial;
    }

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
     * @param ouro
     */
    public void setOuro(int ouro) {
        this.ouro = ouro;
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

