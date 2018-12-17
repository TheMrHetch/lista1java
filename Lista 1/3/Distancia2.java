import java.util.Scanner;
public class Distancia2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double x1, y1, x2, y2, distancia;
        System.out.println("Entre com as coordenadas x e y dos pontos nesta ordem:");
        x1 = 2;
        y1 = 2;
        x2 = 3;
        y2 = 4;
        distancia = Math.sqrt( Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        teclado.close();
        System.out.println("A distância é: " + distancia);
    }
}