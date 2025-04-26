public class Tabuleiro extends Jogador {

    //inicia um char bidimenssional para criar o tabuleiro do jogo e
    //atribui inicialmente valores vazios que depois serão preenchidos com os simbnolos do jogo
    public char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '},
    };

    //função que cria o menu inicial, onde serão mostradas as instruções do jogo
    public void menu(){
        System.out.print(
                """
                        \n
                        ||    Olá, sejam bem-vindos ao clássico     ||
                        ||      ----->  JOGO DA VELHA  <-----       ||
                        ||                X : X : O                 ||
                        ||                O : X : O                 ||
                        ||                X : O : X                 ||
                        ||                                          ||
                        ||    As regras são simples:                ||
                        ||    1º - Escolha X ou O;                  ||
                        ||    2º - Tente formar uma linha com 3     ||
                        ||      simbolos iguais, seja ela na:       ||\
                        
                        ||     HORIZONTAL, VERTICAL OU DIAGONAL.    ||\
                        
                        ||    3º - Vença o jogo e se divirta-se!!!  ||
                        """);

        //instruções iniciais
        System.out.print(
                """
                       \s
                        Instruções iniciais para o jogo:
                        \n   O jogo funcionará com base em MATRIZES, ou seja, para escolher cada posição\s
                          você terá que dizer primeiro o número da linha e depois o número da coluna,\s
                          por exemplo: \n
                           * linha 2 e coluna 2, o X irá fica nesta posição:\s
                                              :   :                  \s
                                              : X :                  \s
                                              :   :                  \s
                       \s
                           * linha 1, coluna 3:\s
                                              :   : X                \s
                                              :   :                  \s
                                              :   :                  \s
                       \s
                           As posições da matriz estão organizadas assim (x,y) onde
                           X é a linha e Y a coluna:\s
                                            1,1 : 1,2 : 1,3                \s
                                            2,1 : 2,2 : 2,3                 \s
                                            3,1 : 3,2 : 3,3                  \s
                       \s""");
    }


    //função que converte o tabuleiro bidimensional (char[][] tabuleiro)
    // em um array unidimensional (char[9] esteJogo), retornando ele ao final
    public char[] transformaTabuleiro() {
        char[] esteJogo = new char[9];
        int index = 0;
        //loops que percorrem cada elemento do tabuleiro bidimensional e os atribuem ao array unidimensional
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                esteJogo[index++] = tabuleiro[i][j];
            }
        }
        return esteJogo;
    }

    //função que mostra o tabuleiro em cada jogada para os jogadores
    public void mostraEsteJogo() {

        //chama a função "transformaTabuleiro" para obter o array 'esteJogo'
        char[] esteJogo = transformaTabuleiro();

        //loop que percorre percorre o array unidimensional e imprime cada elemento
        for (int i = 0; i < 9; i++) {
            System.out.print(esteJogo[i]);

            //adiciona uma quebra de linha a cada três caracteres para manter o formato do tabuleiro
            if ((i + 1) % 3 == 0) {
                System.out.println();
            } else {
                System.out.print(" : ");
            }
        }
    }

    //funçãoq ue verifica cada jogada, verificando se ela esta dentro da matriz e se a posição escolhida esta
    //vazia, caso NÃO, retorna false e uma mensagem para o usuário
    public boolean verificajogada(int linha, int coluna) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || tabuleiro[linha][coluna] != ' ') {
            System.out.println("Movimento inválido!!!");
            return false;
        } else {
            //caso a jogada seja válida, retorna true
            return true;
        }
    }

    //função que verifica a vitória do jogo, percorrendo cada linha, coluna e diagonal da matriz
    //e retorna true caso tenha uma vitória
    public boolean verificaVitoria() {
        for (int i = 0; i < 3; i++) {
            //linhas
            if (tabuleiro[i][0] == 'X' && tabuleiro[i][1] == 'X' && tabuleiro[i][2] == 'X') {
                return true;
            }
            if (tabuleiro[i][0] == 'x' && tabuleiro[i][1] == 'x' && tabuleiro[i][2] == 'x') {
                return true;
            }
            if (tabuleiro[i][0] == 'O' && tabuleiro[i][1] == 'O' && tabuleiro[i][2] == 'O') {
                return true;
            }
            if (tabuleiro[i][0] == 'o' && tabuleiro[i][1] == 'o' && tabuleiro[i][2] == 'o') {
                return true;
            }

            //colunas
            if (tabuleiro[0][i] == 'X' && tabuleiro[1][i] == 'X' && tabuleiro[2][i] == 'X') {
                return true;
            }
            if (tabuleiro[0][i] == 'x' && tabuleiro[1][i] == 'x' && tabuleiro[2][i] == 'x') {
                return true;
            }
            if (tabuleiro[0][i] == 'O' && tabuleiro[1][i] == 'O' && tabuleiro[2][i] == 'O') {
                return true;
            }
            if (tabuleiro[0][i] == 'o' && tabuleiro[1][i] == 'o' && tabuleiro[2][i] == 'o') {
                return true;
            }

            //diagonal 1
            if (tabuleiro[0][0] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][2] == 'X') {
                return true;
            }
            if (tabuleiro[0][0] == 'x' && tabuleiro[1][1] == 'x' && tabuleiro[2][2] == 'x') {
                return true;
            }
            if (tabuleiro[0][0] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][2] == 'O') {
                return true;
            }
            if (tabuleiro[0][0] == 'o' && tabuleiro[1][1] == 'o' && tabuleiro[2][2] == 'o') {
                return true;
            }

            //diagonal 2
            if (tabuleiro[0][2] == 'X' && tabuleiro[1][1] == 'X' && tabuleiro[2][0] == 'X') {
                return true;
            }
            if (tabuleiro[0][2] == 'x' && tabuleiro[1][1] == 'x' && tabuleiro[2][0] == 'x') {
                return true;
            }
            if (tabuleiro[0][2] == 'O' && tabuleiro[1][1] == 'O' && tabuleiro[2][0] == 'O') {
                return true;
            }
            if (tabuleiro[0][2] == 'o' && tabuleiro[1][1] == 'o' && tabuleiro[2][0] == 'o') {
                return true;
            }
        }
        //retorna false caso não tenha tido uma vitória
        return false;
    }

    //função que verifica se houve um empate no jogo, percorrento a matriz inteira. Assim ele verifica se a matriz esta
    // completa, mas caso esteja com os valores vazios, ele retorna false o que significa que não houve empate
    //caso a matriz esteja completa e preenchida com os simbolos, ele retorna true, significando que houve empate
    public boolean verificaEmpate() {
        for (int i = -0; i < 3; i++) {
            for (int j = -0; j < 3; j++)
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
        }
        return true;
    }

    //função que zera o tabuleiro para o estado inicial da matriz todas as vezes que o jogo inicia novamente
    public void zeraTabuleiro() {
        tabuleiro = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
    }

    //função que pede para os jogadores se eles desejam continuar o jogo,
    //caso sim, ele zera o tabuleiro e retorna true,
    //caso não, ele exibe a mensagem para os jogadores e retorna false
    //caso a opção seja inválida, ele exibe a mensagem para os jogadores e
    //pede para ele selecionar novamente a opção
    public boolean continuaJogo() {
        System.out.println("""
                \nDesejam continuar o jogo?
                1 - Sim
                2 - Não""");
        int escolha = le.nextInt();
        if (escolha == 1) {
            zeraTabuleiro();
            return true;
        } else if (escolha == 2) {
            System.out.println("Obrigada por jogar!\n");
            return false;
        } else {
            System.out.println("Opção Inválida! Tente Novamente!\n");
            return continuaJogo();
        }
    }
}