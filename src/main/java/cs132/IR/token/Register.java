package cs132.IR.token;

public class Register {

    // {a0, . . . , a7, s1, . . . , s11, t0, . . . , t5}
    String name;

    public Register(String name){
      this.name = name;
    }
 
    public String toString() {
      return name;
    }
}
