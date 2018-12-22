
import java.util.Scanner;

public class Horas
{
    public static void main(String[] args) 
    {
        escrita(leitura());
        
    }
    
    private static long leitura()
    {
        Scanner t = new Scanner(System.in);
        System.out.println("Digite o tempo em segundos: ");
        
        return t.nextLong();
    }
    
    private static long getHoras(long tempo)
    {
        return tempo / 3600;
    }
    
    private static long getMinutos(long tempo)
    {
        return tempo % 3600 / 60;
    }
    
    private static long getSegundos(long tempo)
    {
        return tempo % 3600 % 60;
    }
    
    private static void escrita(long tempo)
    {
        long hora = getHoras(tempo);
        long min = getMinutos(tempo);
        long seg = getSegundos(tempo);
        System.out.printf("Tempo: %d:%d:%d\n", hora, min, seg);
    }
}