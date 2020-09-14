package cs132.IR.token;
  
public class FunctionName implements cs132.IR.value.Value {
  
  public String name;

  public FunctionName(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}
