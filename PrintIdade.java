import java.util.Scanner;

public class PrintIdade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Sua idade é: " + idade);

        scanner.close();
    }
}
