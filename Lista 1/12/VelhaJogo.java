import java.util.Random;
public class VelhaJogo
{
    public static void main(String[] args) throws InterruptedException
    {
        int[][] velha = new int[][]
        {
            {1, 1, -1},
            {-1, 0, 0},
            {1, 0, -1},
        };

        int[] vazias = checaPosicoesVazias(velha);
        if (vazias != null)
        {
            System.out.printf("Posicao disponivel para jogada\nAbaixo, sao as barras invertidas:\n");
            for (int i = 0; i < 3; i ++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (i != vazias[0] || j != vazias[1])
                        if (velha[i][j] == 1)
                            System.out.printf("o\t");
                        else if (velha[i][j] == -1)
                            System.out.printf("x\t");
                    if (velha[i][j] == 0)
                        System.out.printf("%c\t", '\\');
                }
                System.out.println();
            }
        }
        adicionaVelha(velha);
    }

    private static int[] checaPosicoesVazias(int[][] tabuleiro)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3 ; j++)
            {
                if (tabuleiro[i][j] == 0)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    private static int checaColunas(int[][] tabuleiro)
    {
        for (int i = 0 ; i < 3; i++)
        {
            if (tabuleiro[0][i] + tabuleiro[1][i] + tabuleiro[2][i] == 3)
            {
                return 1;
            }
            else if (tabuleiro[0][i] + tabuleiro[1][i] + tabuleiro[2][i] == -3)
            {
                return -1;
            }
        }
        return 0;
    }

    private static int checaDiagonais(int[][] tabuleiro)
    {
        if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == 3)
        {
            return 1;
        }
        else if (tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2] == -3)
        {
            return -1;
        }
        if (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0] == 3)
        {
            return 1;
        }
        else if (tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0] == -3)
        {
            return -1;
        }
        return 0;
    }

    private static void adicionaVelha(int[][] tabuleiro) throws InterruptedException
    {
        do
        {
            int[] vazias = checaPosicoesVazias(tabuleiro);

            System.out.println("Digite a posicao que deseja jogar: ");
            int linhaJog = new Random().nextInt(3); // Randomico
            System.out.println("Linha: " + linhaJog);
            int colunaJog = new Random().nextInt(3); // Randomico
            System.out.println("Coluna: " + colunaJog);
            if (tabuleiro[linhaJog][colunaJog] == 0)
            {
                tabuleiro[linhaJog][colunaJog] = -1;
                vazias = checaPosicoesVazias(tabuleiro);
                System.out.println("Adicionado ao tabuleiro o X");
            }
            else
            {
                System.err.println("Posicao ocupada, veja a disposicao novamente: ");
                for (int i = 0; i < 3; i ++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (i != vazias[0] || j != vazias[1])
                            if (tabuleiro[i][j] == 1)
                                System.out.printf("o\t");
                            else if (tabuleiro[i][j] == -1)
                                System.out.printf("x\t");
                        if (tabuleiro[i][j] == 0)
                            System.out.printf("%c\t", '\\');
                    }
                    System.out.println();
                }
            }
                
            Thread.sleep(1000);
        } while(checaPosicoesVazias(tabuleiro) != null);
        if (checaColunas(tabuleiro) == -1)
            System.out.println("Voce ganhou!");
    }
}