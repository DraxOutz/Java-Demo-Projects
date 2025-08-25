// Importa a classe Scanner, que permite ler entradas do usuário via teclado
import java.util.Scanner;

// Define a classe pública chamada PrintIdade
// A classe publica obrigatoriamente ter o mesmo nome do arquivo, mas só se houver uma classe pública no arquivo.
public class PrintIdade {

    // Método principal - ponto de entrada do programa
    public static void main(String[] args) {

        // Cria um objeto Scanner para ler dados do teclado
        Scanner scanner = new Scanner(System.in);

        // Exibe a mensagem solicitando que o usuário digite sua idade
        System.out.println("Digite sua idade: ");

        // Lê um número inteiro digitado pelo usuário e armazena na variável 'idade'
        int idade = scanner.nextInt();

        // Exibe a idade digitada pelo usuário
        System.out.println("Sua idade é: " + idade);

        // Fecha o scanner para liberar recursos do sistema
        scanner.close();
    }
}
