package src.main.java.com.Java.TypeInfo_14;

import java.util.List;
import java.util.Random;

class Pet {
  Pet() {}
  Pet(String name) {
  }
}

class Dog extends Pet {
  public Dog() {super();}
  public Dog(String name ) {
    super(name);
  }
}

class Manx extends Pet {
  public Manx() {super();}
  public Manx(String name ) {
    super(name);
  }
}

abstract class PetCreator {
  private Random rand = new Random(47);
  public abstract List<Class<? extends Pet>> types();
  public Pet randomPet() {
    int n  = rand.nextInt(types().size());
    try {
      return types().get(n).newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException();
    } catch (IllegalAccessException e) {
      throw new RuntimeException();
    }
  }
  public Pet[] createArray(int size) {
    Pet[] result = new Pet[size];
    for(int i=0;i<size;i++) {
      result[i] = randomPet();
    }
    return result;
  }
}

public class t {

}
