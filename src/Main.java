public class Main {

    // inicializamos os objetos e as variáveis necessárias
    // para o funcionamento do jogo
    static Jogador jogador1 = new Jogador();
    static Jogador jogador2 = new Jogador();
    static Tabuleiro jogo = new Tabuleiro();
    static int contVitoria1 = 0;
    static int contVitoria2 = 0;
    static int rodada = 1;

    public static void main(String[] args) {
        //chamando a função 'menu' para dar as instruções do jogo
        jogo.menu();

        //chamando as funções para pegar os dados iniciais dos jogadores,
        //sendo seu nome e o simbolo escolhido
        jogador1.pega_Dados();
        jogador2.pega_Dados2();
        atribuiSimbolo();

        //estrutura de repetição que verifica se caso o jogo não tenha um vencedor
        //o jogo continua com as jogadas alternadas de cada jogador
        while (!jogo.verificaVitoria()){
            System.out.println(" ");
            alternaJogador(rodada);
            rodada++;
        }
    }

    //função para as jogadas do primeiro jogador
    public static void jogaJogador1() {

        // declara um char para pegar o simbolo do jogador 1 que foi declarado inicialmente
        char simboloS = jogador1.getSimbolo();

        //declara 2 inteiros para pegar, atravéz da função "jogadaLinha" e jogadaColuna"
        // a linha e a coluna (respectivamente) de cada jogada realizada
        int linha1 = Character.getNumericValue(jogador1.jogadaLinha());
        int coluna1 = Character.getNumericValue(jogador1.jogadaColuna());

        //estrutura de repetição que verifica se a jogada foi realizada de maneira correta
        //ou seja, dentro da estrutura da matriz e se caso sim, atribui o simbolo a posição determinada
        if (jogo.verificajogada(linha1, coluna1)) {
            jogo.tabuleiro[linha1][coluna1] = simboloS;
            jogo.mostraEsteJogo();
        } else {
            //caso a jogada não tenha sido feita da maneira correta ou a posição já esteja ocupada,
            // ele retorna isso para o jogador e pede para ele jogar novamente
            System.out.println("Posição ocupada!!! Tente novamente: ");
            jogaJogador1();
        }

        //Após a verificação da jogada, ele verifica se o primeiro jogador venceu e caso sim,
        //conta a vitoria em um contador "contVitoria1" e exibe a mensagem de vitória para o jogador
        if (jogo.verificaVitoria()){
            contVitoria1++;
            System.out.println(jogador1.getNome() + ", você venceu!!! Parabéns!");

            //laço de repotição que chama a função "ContinuaJogo" e verifica se os jogadores querem continuar
            //caso NÃO, ele chama a função para contar vitórias e sai do programa
            if (!jogo.continuaJogo()){
                contaVitorias(contVitoria1, contVitoria2);
                System.exit(0);

                //caso SIM, ele chama a função "mudaSimbolo" para mudar os simbolos dos jogadores
                //invertendo entre os dois os simbolos definidos anteriormente
            } else {
              mudaSimbolo();
            }
            //caso o jogo não tenha um vencedor, ele verifica se teve empate, caso sim, ele exibe a
            //mensagem de empate para os jogadores
        } else if (jogo.verificaEmpate() ) {
            System.out.println("Deu empate!!!!");

            //do memso modo que foi feito acima, ele chama a função "ContinuaJogo" e verifica se os jogadores querem continuar
            //caso NÃO, ele chama a função para contar vitórias e sai do programa
            if (!jogo.continuaJogo()) {
                contaVitorias(contVitoria1, contVitoria2);
                System.exit(0);

                //caso SIM, ele chama a função "mudaSimbolo" para mudar os simbolos dos jogadores
                //invertendo entre os dois os simbolos definidos anteriormente
            } else {
             mudaSimbolo();
            }
        }
    }

    //função para as jogadas do segundo jogador
    public static void jogaJogador2() {

        //repete todas as verificações e funções da função "jogaJogador1" mas desta vez
        //para o jogador 2 realizar a jogada
        char simboloS2 = jogador2.getSimbolo();
        int linha2 = Character.getNumericValue(jogador2.jogadaLinha());
        int coluna2 = Character.getNumericValue(jogador2.jogadaColuna());
        if (jogo.verificajogada(linha2, coluna2)) {
            jogo.tabuleiro[linha2][coluna2] = simboloS2;
            jogo.mostraEsteJogo();
        } else {
            System.out.println("Posição ocupada!!! Tente novamente: \n");
            jogaJogador2();
        }

        if (jogo.verificaVitoria()){
            contVitoria2++;
            System.out.println("\n" + jogador2.getNome() + ", você venceu!!! Parabéns!");
            if (!jogo.continuaJogo()){
                contaVitorias(contVitoria1, contVitoria2);
                System.exit(0);
            } else {
             mudaSimbolo();
             }
        } else if (jogo.verificaEmpate()){
            System.out.println("\nDeu empate!!!!");
            if (!jogo.continuaJogo()){
                contaVitorias(contVitoria1, contVitoria2);
                System.exit(0);

            } else {
                mudaSimbolo();
            }
        }
    }

    //função que verifica o simbolo definido pelo primeiro jogador e atribui o simbolo oposto
    //para o segundo jogador
    public static void atribuiSimbolo(){

        //caso o primeiro jogador tenha escolhido 'X', ele atribui o 'O' para o segundo jogador
        //e mostra a mensagem contendo o simbolo de cada um
        if (jogador1.getSimbolo() == 'X' || jogador1.getSimbolo() == 'x'){
            jogador2.setSimbolo('O');
            System.out.println("\n" + jogador1.getNome() + " seu simbolo é " + jogador1.getSimbolo() + "!");
            System.out.println(jogador2.getNome() + " seu símbolo é O!");

            //caso o primeiro jogador tenha escolhido 'O', ele atribui o 'X' para o segundo jogador
            //e mostra a mensagem contendo o simbolo de cada um
        } else if (jogador1.getSimbolo() == 'O' || jogador1.getSimbolo() == 'o') {
            jogador2.setSimbolo('X');
            System.out.println("\n" + jogador1.getNome() + " seu simbolo é " + jogador1.getSimbolo() + "!");
            System.out.println(jogador2.getNome() + " seu símbolo é X!");
        }
    }

    //função responsável para exibir a contagem de vitórias de cada jogador ao final do jogo
    //puxando o nome do jogador e a variavel da contagem de vitorias
    public static void contaVitorias(int nVitoria1, int nVitoria2){
        System.out.println("\n-- O jogador " + jogador1.getNome() + " teve " + nVitoria1 + " vitórias!");
        System.out.println("-- O jogador " + jogador2.getNome() + " teve " + nVitoria2 + " vitórias!");
    }

    //função responsável por mudar o símbolo de cada jogador caso eles queiram continuar o jogo depois do final
    public static void mudaSimbolo() {
        //caso o segundo jogador tenha o simbolo 'X', ele atribui para ele o simbolo 'O'
        //e atribui o simbolo 'X' para o primeiro jogador, chamando a função "atribuiSimbolo"
        //para mostrar os simbolos determinados
        if (jogador2.getSimbolo() == 'X' || jogador2.getSimbolo() == 'x') {
            jogador2.setSimbolo('O');
            jogador1.setSimbolo('X');
            atribuiSimbolo();

            //caso o segundo jogador tenha o simbolo 'O', ele atribui para ele o simbolo 'X'
            //e atribui o simbolo 'O' para o primeiro jogador, chamando a função "atribuiSimbolo"
            //para mostrar os simbolos determinados
        } else if (jogador2.getSimbolo() == 'O' || jogador2.getSimbolo() == 'o') {
            jogador2.setSimbolo('X');
            jogador1.setSimbolo('O');
            atribuiSimbolo();

            //realiza as mesmas funçoes feitas anteriormente, mas desta vez para o primeiro jogador
        } else if (jogador1.getSimbolo() == 'X' || jogador1.getSimbolo() == 'x') {
            jogador1.setSimbolo('O');
            jogador2.setSimbolo('X');
            atribuiSimbolo();
        } else if (jogador1.getSimbolo() == 'O' || jogador1.getSimbolo() == 'o') {
            jogador1.setSimbolo('X');
            jogador2.setSimbolo('O');
            atribuiSimbolo();
        }
    }

    //função que altera o jogador que inicia as rodadas. Quando a rodada foi impar
    //o primeiro jogador começa, quando for par, o segundo jogador começa
    public static void alternaJogador(int rodada){
        if (rodada % 2 == 0){
            jogaJogador2();
        } else if (rodada % 2 != 0){
            jogaJogador1();
        }
    }
}