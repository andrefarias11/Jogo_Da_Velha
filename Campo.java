package jogodavelha;

public class Campo {

    String[][] m = {{"1", "2", "3"},
                    {"4", "5", "6"},
                    {"7", "8", "9"}};

    public String Exibir() {
        for (int li = 0; li < 3; li++) {
            for (int co = 0; co < 3; co++) {
                System.out.printf("  " + m[li][co]);
            }
            System.out.println("\n");
        }
        return null;
    }

    public boolean Valido(String p) {
        for (int li = 0; li<3; li++) {
            for (int co = 0; co<3; co++) {
                if (m[li][co].equals(p))
                    return true;
            }
        }
        return false;
    }

    public void Jogada(String p, String j) {
        if (p.equals("1")) {
            m[0][0] = j;
        } else if (p.equals("2")) {
            m[0][1] = j;
        } else if (p.equals("3")) {
            m[0][2] = j;
        } else if (p.equals("4")) {
            m[1][0] = j;
        } else if (p.equals("5")) {
            m[1][1] = j;
        } else if (p.equals("6")) {
            m[1][2] = j;
        } else if (p.equals("7")) {
            m[2][0] = j;
        } else if (p.equals("8")) {
            m[2][1] = j;
        } else if (p.equals("9")) {
            m[2][2] = j;
        }
    }

    public String Win(int jogadas) {
        String[] W = new String[8];
        String vencedor = "null";
        if (jogadas == 9) {
            vencedor = "jogo empatou e ninguem ";

        }
        W[0] = m[0][0] + m[0][1] + m[0][2];//linha 1
        W[1] = m[1][0] + m[1][1] + m[1][2];//linha 2
        W[2] = m[2][0] + m[2][1] + m[2][2];//linha 3

        W[3] = m[0][0] + m[1][0] + m[2][0];//col 1 
        W[4] = m[0][1] + m[1][1] + m[2][1];//col 2
        W[5] = m[0][2] + m[1][2] + m[2][2];//col 3

        W[6] = m[0][0] + m[1][1] + m[2][2];//diagonal
        W[7] = m[0][2] + m[1][1] + m[2][0];//diagonal

        for (int i = 0; i < W.length; i++) {
            if (W[i].equals("XXX")) {
                vencedor = "Jogador 1 ";
            } else if (W[i].equals("OOO")) {
                vencedor = "Jogador 2";
            }
        }
        return vencedor;
    }

}
