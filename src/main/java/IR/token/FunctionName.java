package IR.token;

import IR.value.Value;

public class FunctionName implements Value {
  
  public String name;

  public FunctionName(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}
