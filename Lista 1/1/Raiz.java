class Determinante implements Runnable
{
    private int a;
    private int b;
    private int c;

    public Determinante(int a, int b, int c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void run()
    {
        int delta = (b * b) - 4 * a * c;
        double raiz1 = ( ( b * -1 ) + Math.sqrt(delta) ) / (2 * a);
        double raiz2 = ( ( b * -1 ) - Math.sqrt(delta) ) / (2 * a);

        System.out.println("Raíz 1: " + raiz1);
        System.out.println("Raíz 2: " + raiz2);
    }
}

public class Raiz
{
    // Calcular raiz quadrada usando thread
    public static void main(String[] args)
    {
        Thread det = new Thread(new Determinante(1, 3, 2), "Determinante-T");
        det.start();
    }
}
