# Its Bluff - Backend

## Visão Geral

Its Bluff é um jogo interativo onde os jogadores podem aprimorar o vocabulário em inglês. Este repositório contém o frontend da aplicação,
responsável pela interface do usuário e pela interação com o backend. 

![Diagrama de Caso de uso](https://github.com/antonycafisso/itsbluff-game/assets/75596780/d03484f2-03e2-4632-8a65-e7f31f76c697)

## Regras do Jogo

Assim que iniciado, o jogo disponibilizará aos jogadores uma letra gerada aleatoriamente.

O jogador da vez terá 3 opções:

    Inserir uma nova letra:
        Permite ao usuário inserir uma nova letra do lado direito ou esquerdo da já existente, sem que a junção dessas forme uma palavra em inglês.

    Alegar blefe:
        De acordo com as inserções feitas, caso o jogador da vez entenda que a palavra formada não possa formar uma palavra existente na língua inglesa e apenas foi uma alternativa de seu oponente, ele pode questionar se o mesmo blefou ou não.

    Desistir:
        O jogador não encontra alternativas a partir da junção das letras, por exemplo: caso insira uma nova letra uma palavra será formada e, portanto, afirmar que o oponente blefou também não é uma opção.

A cada letra inserida, uma API será consultada com o intuito de validar se a combinação de letras forma uma palavra real da língua inglesa.

    Caso esta validação retorne que uma palavra foi formada, será apresentado aos usuários o significado.

Haverá um sistema de pontuação regressivo, ou seja, os jogadores iniciarão a partida com uma determinada quantidade de pontos e com o decorrer do jogo terão seus pontos decrementados, assim o vencedor será o único restante.
Sistema de Pontuação

    Cada jogador iniciará o jogo com 5 pontos.

    Desistência:
        Caso o jogador opte por desistir, perderá apenas um ponto.

    Blefe:
        Caso um dos oponentes desafie o outro alegando blefe e este esteja realmente blefando, o jogador que blefou perderá 2 pontos.
        Caso contrário, o jogador que desafiou perderá um ponto.

## Tecnologias Utilizadas

- Java
- Spring Boot
- H2 Database (em memória)
- Maven

## Configuração do Ambiente

### Pré-requisitos

- JDK 11 ou superior
- Maven

### Instalação

1. Clone o repositório:

   ```sh
   git clone https://github.com/seu-usuario/its-bluff-backend.git
   cd its-bluff-backend

2. Compile e construa o projeto:
   
  mvn clean install

4. Execute a aplicação:
   
  mvn spring-boot:run

## Endpoints Disponíveis

    GET /players - Retorna a lista de jogadores.
    GET /players/id - Retorna um jogador específico.
    POST /game/addNewLetter - Adiciona uma nova letra à palavra atual.
    GET /word/initialLetter - Busca a letra inicial do jogo.
    POST /game/challenge - Desafia o adversário se está blefando a respeito da palavra.
    POST /game/giveup - O jogador da vez prefere desistir ao inserir uma nova letra ou desafiar o blefe.

## Configuração do Banco de Dados

O banco de dados H2 é utilizado em memória para facilitar o desenvolvimento e os testes. A configuração do banco de dados pode ser encontrada em src/main/resources/application-test.properties.

## Inicialização de Dados

No perfil test, os dados dos jogadores são inicializados automaticamente na inicialização da aplicação. Esta configuração pode ser encontrada em TestConfig.java:

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.
