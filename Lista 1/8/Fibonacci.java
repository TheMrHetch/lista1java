class FiboCalc implements Runnable
{
    private int n;

    public FiboCalc(int n)
    {
        this.n = n;
    }

    @Override
    public void run()
    {
        int soma = 0;
        int anterior = 1;
        for (int i = 0; i < n; i ++)
        {
            soma = anterior + soma;
            anterior = soma - anterior;
        }
        System.out.println("Fibonacci de " + n + " eh " + soma);
    }
}

public class Fibonacci
{
    public static void main(String[] args)
    {
        Thread fib = new Thread(new FiboCalc(9), "Fibonacci-T");
        fib.start();
    }
}