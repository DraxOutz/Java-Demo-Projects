package POO_Car;

import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
   
        String Modelo = "Toyota";
        int Ano = 2006;

        Carro MyCar = new Carro(Modelo,Ano);

        Drive.Acelerar(MyCar);

        print(Drive.GetSpeed());
    }

   public static void print(String vlr){
    JOptionPane.showMessageDialog(null, vlr);
   }

}
