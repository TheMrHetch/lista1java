import java.util.Random;

class Construtor implements Runnable 
{
    private int numero;
    private long sleepTime;

    public Construtor(int numero, long sleepTime)
    {
        this.numero = numero;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run()
    {
        System.out.println("Tabuada do: " + numero);
        for (int i = 1; i <= 10; i++)
        {
            System.out.printf("%d * %d = %d\n", i, numero, (i * numero));
        }
        Thread.yield();
        try
        {
            Thread.sleep(sleepTime);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        
    }
}

// Parte desnecessária do exercício
class Perfeito implements Runnable
{

    private int numero;
    private long sleepTime;

    public Perfeito(int numero, int sleepTime)
    {
        this.numero = numero;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run()
    {
        int soma = 0;
        for(int i = 1; i < numero; i++)
        {
            if (numero % i == 0)
                soma += i;
        }
        if (soma == numero)
            System.out.println("Numero " + soma + " eh perfeito");
        else
            System.out.println("Numero " + numero + " nao eh perfeito");
        Thread.yield();
        try
        {
            Thread.sleep(sleepTime);
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
// Fim da parte desnecessária

// Não usando scanner por estar bugando o VSCODE, *instead* fazendo automática
public class Tabela
{
    public static void main(String[] args) 
    {
        int soninho = 1500;
        while (true)
        {
            int numero = new Random().nextInt(28) + 1;
            Thread t1 = new Thread(new Construtor(numero, soninho), "Tabuada-T");
            Thread t2 = new Thread(new Perfeito(numero, soninho), "NumeroPerfeito-T");
            t1.start();
            t2.start();
            try
            {
                Thread.sleep(soninho);
            } 
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}