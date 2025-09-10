package Aula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Personagem {
    String nome;
    int fome = 100;
    int sede = 100;
    int energia = 100;
    int vida = 100;

    long sonodelay = 0;
    long cacadelay = 0;

    int comida = 0;
    int bebida = 0;

    int nivel = 1;
    int XP = 0;

    int MaxVida = 100;

    public void cacar() {
        long agora = System.currentTimeMillis();

  

        if (agora > cacadelay) {
            if (energia > 0) {
                comida = (int) (Math.random() * 3);
                bebida = (int) (Math.random() * 3);
    
                 XP+=5;

                cacadelay = agora + (60 * 1000);
                energia -= (int) (Math.random() * 25);

                main.print("O personagem está caçando.");
                main.print("Energia: " + energia);

                if ((int) (Math.random() * 100) < 50) {
                    vida -= (int) (Math.random() * 25);
                    main.print("O personagem foi atacado, vida: " + vida);
                }

                main.print("Coletou: " + comida + " comidas e " + bebida + " bebidas.");

            } else {
                main.print("O personagem está exausto.");
            }
        } else {
            long restanteSegundos = (cacadelay - agora) / 1000;
            main.print("Aguarde " + restanteSegundos + " segundos para caçar novamente.");
        }

        if (XP >= 25*nivel) {
            nivel+=1;
            MaxVida = 100*nivel;
            XP=0;
            vida = MaxVida;
            main.print("Parabéns você subiu para o nível: "+nivel);
           }
    }

    public void comerEbeber(String vlr) {
        if ("Comer".equals(vlr)) {
            if (comida > 0) {
                fome += (int) (Math.random() * 100);
                fome = Math.min(100, fome);  // Limita a 100 no máximo
                vida += (int) (Math.random() * 25);
                vida = Math.min(MaxVida, vida);  // Limita a 100 no máximo
                main.print("Personagem está comendo.");
                main.print("Fome: " + fome);
                comida--;
            } else {
                main.print("Você não possui comida.");
            }
        } else {
            if (bebida > 0) {
                sede += (int) (Math.random() * 100);
                sede = Math.min(100, sede);  // Limita a 100 no máximo
                main.print("Personagem está bebendo.");
                main.print("Sede: " + sede);
                bebida--;
            } else {
                main.print("Você não possui bebida.");
            }
        }
    }
    

    public void dormir() {
        if (System.currentTimeMillis() > sonodelay) {
            energia = 100;
            sonodelay = System.currentTimeMillis() + (300 * 1000);
            vida = MaxVida;
            fome -= (int) (Math.random() * 25);
            sede -= (int) (Math.random() * 25);
            main.print("Personagem dormiu, energia e vida restauradas.");
        } else {
            long restanteSegundos = (sonodelay - System.currentTimeMillis()) / 1000;
            main.print("Pode dormir em " + restanteSegundos + " segundos.");
        }
    }

     // ... Seus métodos já existentes ...

     public String salvarComoJSON() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public static Personagem carregarDeJSON(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Personagem.class);
    }
}
