
import java.util.Arrays;

public class Numeros
{
    public static void main(String[] args)
    {
        int num = 2345;
        System.out.println(Arrays.toString(getValoresIndividuais(num)));
        System.out.println(getDigitos(num));
        System.out.printf("O valor %d em 'extenso' é %s\n", num, getExtenso(num));
    }
    
    public static String getExtenso(int num)
    {
          int totDigitos = getDigitos(num);
          String[] vet = new String[]{"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
          int vetorInverso[] = getValoresIndividuais(num);
          String[] sb = new String[totDigitos];
          for (int i = 0; i < totDigitos; i++)
          {
              for (int j = 0; j < vet.length; j++)
              {
                  if (vetorInverso[i] == j)
                  {
                      sb[i] = vet[j] + " ";
                  }
              }
          }
          
          String[] nsb = new String[totDigitos];
          int j = 0;
          
          for (int i = totDigitos - 1; i >= 0; i--)
          {
              nsb[j] = sb[i];
              j++;
          }
          
          return Arrays.toString(nsb);
    }
    
    public static int getDigitos(int num)
    {
        int digito = 0;
        while (num != 0)
        {
            num /= 10;
            digito++;
        }
        return digito;
    }
    
    public static int[] getValoresIndividuais(int num)
    {
        int novoNum[] = new int[getDigitos(num)];
        int i = 0;
        while (num != 0)
        {
            novoNum[i] = num % 10;
            num /= 10;
            i++;
        }
        return novoNum;
    }
}