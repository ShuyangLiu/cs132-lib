package IR.token;

public class Identifier {
    String name;

    public Identifier(String name){
        this.name = name;
    }

    public String toString() {
      return name;
    }
}
