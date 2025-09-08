public class Main {
    
    public static void main(String[] args) {
   
        String Modelo = "Toyota";
        int Ano = 2006;

        Carro MyCar = new Carro(Modelo,Ano);

        Drive.Acelerar(MyCar);
    }

   public static void print(String vlr){
    System.err.println(vlr);
   }

}
