import java.util.Random;

public class Juntar
{
    public static void main(String[] args)
    {
        int v1[] = new int[50];
        int v2[] = new int[50];
        int v3[] = new int[100];

        for (int i = 0; i < 50; i++)
        {
            v1[i] = new Random().nextInt(100);
            v2[i] = new Random().nextInt(100);
        }
        
        quickSort(v1, 0, 49);
        quickSort(v2, 0, 49);

        ordena(v1, v2, v3);
        quickSort(v2, 0, 49);
        
        System.out.println("V1");
        
        for (int i = 0; i < 50; i++)
        {
            System.out.printf(" %d \n", v1[i]);
        }
        
        System.out.println("V2");
        
        for (int i = 0; i < 50; i++)
        {
            System.out.printf(" %d \n", v2[i]);
        }
        
        junta(v1, v2, v3);
        
        System.out.println("V3");
        
        for (int i = 0; i < 100; i++)
        {
            System.out.printf(" %d \n", v3[i]);
        }
    }

    private static void quickSort(int[] v, int inicio, int fim)
    {
        int i, j, pivo, aux;
        i = inicio;
        j = fim;

        pivo = v[(inicio + fim) / 2];
        while (i <= j)
        {
            while (v[i] < pivo) { i++; }
            while (v[j] > pivo) { j--; }
            if (i <= j)
            {
                aux = v[i];
                v[i] = v[j];
                v[j] = aux;
                i++;
                j--;
            }
        }
        if (inicio < j) { quickSort(v, inicio, j); }
        if (i < fim) { quickSort(v, i, fim); }
    }

    private static void ordena(int[] v1, int[] v2, int[] v3) 
    {
        int aux, k = 0;
        for (int i = 0; i < 50; i++)
        {
            for (int j = 0; j < 50; j++)
            {
                if (v1[i] > v2[j])
                {
                    aux = v1[i];
                    v1[i] = v2[j];
                    v2[j] = aux;   
                }
            }
        }
    }
    
    private static void junta(int[] v1, int[] v2, int[] v3)
    {
        int k, j = 0, teste = 0;
        for (int i = 0; i < 100; i++)
        {
            if (j == 50)
            {
                j = 0;
                teste = 1;
            }
            
            if (teste == 0)
            {
                v3[i] = v1[j];
                j++;
            }
            else
            {
                v3[i] = v2[j];
                j++;
            }
        }
    }
}