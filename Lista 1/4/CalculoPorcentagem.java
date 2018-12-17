import java.util.Scanner;

class Produto implements Runnable
{
    private double valor;
    private int quantidade;
    private String nome;

    public Produto(int quantidade, double valor, String nome)
    {
        this.quantidade = quantidade;
        this.valor = valor;
        this.nome = nome;
    }

    public Produto(){}

    public void run()
    {
        if (quantidade <= 10)
        {
            return;
        }
        else if (quantidade <= 20)
        {
            valor -= valor * 0.1;
        }
        else if (quantidade <= 50)
        {
            valor -= valor * 0.2;
        }
        else
        {
            valor -= valor * 0.25;
        }
        System.out.println(valor);
    }

    public double getValor()
    {
        return this.valor;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public void setValor(double valor)
    {
        this.valor = valor;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
// Desconto de produtos também com uso de threads simultâneas
public class CalculoPorcentagem
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Produto p = new Produto();
        System.out.println("Digite a quantidade de produtos: ");
        p.setQuantidade(52);
        System.out.println("Digite o preco do produto: ");
        p.setValor(20);
        System.out.println("Digite o nome do produto: ");
        p.setNome("Bateria");

        Thread t = new Thread(p, "Produto");

        t.start();

        System.out.println("Valor final foi de: ");
    }
}