package value;
  
public class IntegerConstant implements Value {
  public int i;

  public IntegerConstant(int i) {
    this.i = i;
  }

  public String toString() {
    return "" + i;
  }
}

