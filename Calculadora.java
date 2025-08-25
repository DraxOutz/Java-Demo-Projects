import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int X = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        int Y = scanner.nextInt();

        System.out.println("Digite o sinal (+, -, *, /): ");
        String Z = scanner.next();

        int resultado = somar(X, Y, Z);
        System.out.println("Resultado: " + resultado);

        scanner.close(); // boa prática
    }

    public static int somar(int a, int b, String C) {
        if (C.equals("+")) {
            return a + b;
        } else if (C.equals("-")) {
            return a - b;
        } else if (C.equals("/")) {
            return a / b;
        } else if (C.equals("*")) {
            return a * b;
        } else {
            System.out.println("Operador inválido!");
            return 0;
        }
    }
}
