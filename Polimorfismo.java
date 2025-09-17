class Animal {
    public void som() {
        System.out.println("O animal faz um som");
    }
}

class Cachorro extends Animal {
    @Override
    public void som() {
        System.out.println("O cachorro late");
    }
}

class Gato extends Animal {
    @Override
    public void som() {
        System.out.println("O gato mia");
    }
}

public class Teste {
    public static void main(String[] args) {
        Animal obj = new Gato();
        obj.som();  // Método da SubClasse (sobrescrito)
    }
}
