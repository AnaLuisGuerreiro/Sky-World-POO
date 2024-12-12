# Java RPG Console Game - Sky World 

## Descrição
Este projeto é um RPG baseado em texto, desenvolvido em Java, que simula uma aventura em um ambiente de fantasia. O jogador pode explorar o mundo, enfrentar inimigos e melhorar o personagem ao longo do jogo.

## Funcionalidades
- Criação de personagens com diferentes atributos (força, agilidade, inteligência, etc.).
- Escolha entre três personagens principais: Arqueiro, Cavaleiro e Feiticeiro.
- Sistema de combate baseado em turnos.
- Inventário para gestão de itens adquiridos durante a aventura.
- Evolução de nível ao acumular experiência.
- Eventos aleatórios que adicionam dinamismo ao jogo.
- Aparência visual aprimorada com efeitos gráficos, como desenho da estrada, texto animado e cores.

## Como Jogar
1. Certifique-se de ter o Java instalado no seu computador.
2. Faça o download ou clone o repositório do projeto.
3. Compile o código com o seguinte comando:
   ```bash
   javac Main.java
   ```
4. Execute o jogo com:
   ```bash
   java Main
   ```
5. Siga as instruções no terminal para jogar.

## Estrutura do Código
O código está organizado da seguinte forma:
- `efeitos/Efeitos.java`: Implementa gráficos como desenho da estrada, texto animado e uso de cores.
- `entidades/herois/Entidade.java`: Classe base para os heróis.
- `entidades/herois/Heroi.java`: Define atributos e comportamentos gerais dos heróis.
- `entidades/herois/NPC.java`: Define NPCs do jogo.
- `entidades/herois/Vendedor.java`: Lógica para NPCs que vendem itens.
- `itens/consumo/ArmaPrincipal.java`: Representa as armas principais utilizadas pelos heróis.
- `itens/consumo/ItemHeroi.java`: Gerencia itens consumíveis.
- `jogo/Jogo.java`: Gerencia a lógica geral do jogo.
- `Main.java`: Ponto de entrada do programa.

## Tecnologias Utilizadas
- **Java**: Linguagem principal utilizada no desenvolvimento.
- **IntelliJ IDEA**: Ambiente de desenvolvimento usado para programar.

## Aprendizados e Desafios
Durante o desenvolvimento, foram aplicados conceitos de algoritmia como:
- Estruturas condicionais e laços de repetição.
- Manipulação de arrays e coleções.
- Modularização de código para facilitar a leitura e manutenção.

Um dos maiores desafios foi implementar o sistema de combate, especialmente ao equilibrar a dificuldade dos inimigos para proporcionar uma boa experiência de jogo.

