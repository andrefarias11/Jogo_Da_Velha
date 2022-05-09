package jogodavelha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        //instanciar
        Campo jogo = new Campo();
        String posicao;
        int valida = 0;
        int jogadas = 0;

        while (true) {
            jogo.Exibir();

            do {
                System.out.print("Jogador 1, Escolha uma posição: ");
                posicao = ler.next();
                while (!jogo.Valido(posicao)) {
                    System.out.println("Jogada invalida, tente novamente !");
                    System.out.print("Jogador 1, Escolha uma posição: ");
                    posicao = ler.next();
                    valida = 0;
                }
                jogo.Jogada(posicao, "X");
                valida = 1;

            } while (valida == 0);

            jogadas++;
            valida = 0;
            jogo.Exibir();
            if (!jogo.Win(jogadas).equals("null")) {
                break;
            }

            do {
                System.out.print("Jogador 2, Escolha uma posição: ");
                posicao = ler.next();
                while (!jogo.Valido(posicao)) {
                    System.out.println("Jogada invalida, tente novamente !");
                    System.out.print("Jogador 2, Escolha uma posição: ");
                    posicao = ler.next();
                    valida = 0;
                }
                jogo.Jogada(posicao, "O");
                valida = 1;

            } while (valida == 0);
            
            jogadas++;
            valida = 0;
            jogo.Exibir();
            if (!jogo.Win(jogadas).equals("null")) {
                break;
            }
        }
        System.out.println("O "+jogo.Win(jogadas)+" ganhou ");
    }
}
