class Calculos implements Runnable 
{
    private int numero;

    public Calculos(int numero)
    {
        this.numero = numero;
    }

    @Override
    public void run() 
    {
        int fi = 0;
        if (numero == 0)
        {
            fi = 1;
            System.out.println(fi + " Digito(s).");
            return;
        }

        else
        {
            while (numero != 0)
            {
                numero /= 10;
                fi++;          
            }
            System.out.println(fi + " Digito(s).");
        }
    }
}

// Número de digitos do informado
public class QuantidadeNumeros
{
    public static void main(String[] args)
    {
        Thread qtd = new Thread(new Calculos(1650), "Calculo-T");
        qtd.start();
    }
}