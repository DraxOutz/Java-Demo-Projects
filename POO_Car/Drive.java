package POO_Car;
public class Drive {
    
   private static int speed;

    public static void Acelerar(Carro carro) {
        Main.print("Acelerando o " + carro.Modelo + " de " + carro.Ano);
        speed = 5;
    }

    public static String GetSpeed() {
        return String.valueOf(speed+" km/h");
    }

}
