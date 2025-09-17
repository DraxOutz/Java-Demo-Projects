interface Animal {
    void som();  // método abstrato (sem corpo)
}

class Cachorro implements Animal {
    @Override
    public void som() {
        System.out.println("O cachorro late");
    }
}

class Gato implements Animal {
    @Override
    public void som() {
        System.out.println("O gato mia");
    }
}

public class Interface {
    public static void main(String[] args) {
        Animal animal1 = new Cachorro();
        animal1.som();  // O cachorro late

        Animal animal2 = new Gato();
        animal2.som();  // O gato mia
    }
}
