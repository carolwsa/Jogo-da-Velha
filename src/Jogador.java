import java.util.Scanner;
public class Jogador{

    //declara os atributos necessário para cada jogador
    String nome;
    char simbolo;
    Scanner le = new Scanner(System.in);

    //função que pega os dados do primeiro jogador, seu nome e o simbolo escolhido
    //caso a opção selecionada seja inválida, ele exibe a mensagem para o usuário
    //e pede para ele começar novamente
    public void pega_Dados(){
        System.out.println("\nVamos começar!\n - Insira seu nome: ");
        setNome(le.next());

        System.out.println("Bem-vindo(a) " + getNome() + "! Agora escolha: X ou O? ");
        setSimbolo(le.next().charAt(0));

        if(getSimbolo() != 'X' && getSimbolo() != 'O' && getSimbolo() != 'x' && getSimbolo() != 'o'){
            System.out.println("Simbolo inválido! Comece novamente :)");
            pega_Dados();
        }
    }

    //função que pega o nome do segundo jogador
    public void pega_Dados2() {
        System.out.println("\nSua vez, jogador 2:\n - Insira seu nome: ");
        setNome(le.next());
    }

    //função que permite que o jogador selecione em qual linha ele deseja jogar.
    //para que o jogador possa selecionar valores de 1 a 3 e não de 0 a 2,
    //realizei a subtração da variável 'linha2', assim, caso o jogador
    //digite '1', o sistema entenderá '0' e assim por diante
    public char jogadaLinha() {
        int linha1;
        int linha2;
        char linhaV;
        System.out.println(getNome() + " escolha a linha que vai jogar: ");
        linha1 = (le.next().charAt(0));
        linha2 = linha1 - 1;
        linhaV = (char) linha2;
        return linhaV;
    }

    //mesmas funções atribuidas a função 'jogadaLinha', mas desta vez para as colunas
    public char jogadaColuna(){
        int coluna1;
        int coluna2;
        char colunaV;
        System.out.println(getNome() + " agora, escolha a coluna que vai jogar: ");
        coluna1 =(le.next().charAt(0));
        coluna2 = coluna1 - 1;
        colunaV = (char) coluna2;
        return colunaV;
    }

    //metodos get e set do objeto
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public char getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}