public class RaizAproximada
{
    public static void main(String[] args) 
    {
        int n = 60;
        int aux = 1;
        int resp = 0;

        while (n >= aux)
        {
            n -= aux;
            aux += 2;
            resp++;
        }

        System.out.println("A raiz aproximada eh : " + resp);
    }
}