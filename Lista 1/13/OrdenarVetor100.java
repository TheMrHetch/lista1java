import java.util.Random;

public class OrdenarVetor100
{
    public static void main(String[] args)
    {
        int [] v = new int[100];

        for (int i = 0; i < 100; i ++)
        {
            v[i] = new Random().nextInt(1000) + 1;
            System.out.println(v[i]);
        }

        quickSort(v, 0, 99);
        System.out.println("Ordenado: ");
        for (int i = 0; i < 100; i ++)
        {
           System.out.println(v[i]);
        }
    }
    public static void quickSort(int[] v, int inicio, int fim)
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
}