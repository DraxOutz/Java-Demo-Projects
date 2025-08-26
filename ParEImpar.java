import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    System.out.println("Digite o número: ");
       int Numero = scanner.nextInt();
       Numero = Numero%2;

       if (Numero == 0){
        System.out.println("O numero é Par");
       }else{
        System.out.println("O numero é Impar");
       }

    }
}
    