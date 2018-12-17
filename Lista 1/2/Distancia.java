class Calculo implements Runnable
{
    private int[] x = new int[2];
    private int[] y = new int[2];
    private int[] z = new int[2];
    
    public Calculo(int[] x, int[] y, int[] z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public void run()
    {
        double det = Math.sqrt( (Math.pow((x[1] - x[0]), 2))
        + (Math.pow((y[1] - y[0]), 2))
        + (Math.pow((z[1] - z[0]), 2)) );
        System.out.println("A distância entre os espaços: ");
        for(int i = 0; i < 2; i++)
        {
            if (i == 0)
            {
                System.out.printf("xA = %d\n", x[i]);
                System.out.printf("yA = %d\n", y[i]);
                System.out.printf("zA = %d\n", z[i]);
            }
            else
            {
                System.out.printf("\nxB = %d\n", x[i]);
                System.out.printf("yB = %d\n", y[i]);
                System.out.printf("zB = %d\n", z[i]);
            }
        }
        System.out.printf("\n\nÉ de: " + det);
    }
}

// Calcular distância entre 2 pontos num espaço 3D, com thread
public class Distancia
{
    public static void main(String[] args) 
    {
        int a[] = new int[]{1, 2};
        int b[] = new int[]{4, 5};
        int c[] = new int[]{4, 3};

        Thread dist = new Thread(new Calculo(a, b, c), "Distancia-T");
        dist.start();
    }
}