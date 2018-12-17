import java.util.Random;

class RetornoCalculo implements Runnable
{

    private double valor;
    private double juros;

    public RetornoCalculo(double valor, double juros)
    {
        this.valor = valor;
        this.juros = juros;
    }

    public void run()
    {
        double total = valor + (valor * (juros / 100));
        System.out.println("Total apos um ano = " + total);
        System.out.println("====================");
        
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        Thread.yield();
    }
}

public class Retorno
{
    public static void main(String[] args)
    {
        while (true)
        {
            double inv = new Random().nextDouble() * 1000 + 1;
            double jur = new Random().nextInt(15) + 1;

            System.out.println("Digite o valor do investimento: " + inv);
            
            System.out.println("Digite o valor dos juros: " + jur);
            
            
            
            Thread t = new Thread(new RetornoCalculo(inv, jur), "Investimento-T");
            
            t.start();
            try {
                t.join();   
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}