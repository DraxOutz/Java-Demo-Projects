import javax.print.DocFlavor.STRING;
import java.util.Scanner;

public class Script {

    public static void main(String[] args) {
        
     int A = input();
     int B = input();
           
     int Resultado = (A*B);
     
     String Valor = String.valueOf(Resultado);

     print("Resultado é: " + Valor);
 
      if (A >5); {
        print((A+" é maior que"));
      }

    }

    public static int input() {

        Scanner scanner = new Scanner(System.in);

        print("Digte um número: ");
     int numero = scanner.nextInt();
        return numero;
    }

    public static void print(String text) {
        System.err.println(text);;
    }
}