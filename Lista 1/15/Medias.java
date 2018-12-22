public class Medias
{
    public static void main(String[] args) 
    {
        System.out.println("Aluno A tirou " + getMedia(8, 4, 8.5, 5.5) + " de média e está " + getConceito(getMedia(8, 4, 8.5, 5.5)));
    }
    
    private static double getMedia(double... notas)
    {
        double soma = 0;
        for (int i = 0; i < notas.length; i++)
        {
            soma += notas[i];
        }
        return soma / notas.length;
    }
    
    private static String getConceito(double media)
    {
        if (media < 4)
        {
            return "Reprovado";
        }
        else if (media <= 6)
        {
            return "Verificação Suplementar";
        }
        return "Aprovado";
    }
}