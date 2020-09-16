package value;
  
public class HeapAddressWithOffset implements Value {
  public int heapAddress;
  public int offset;

  public HeapAddressWithOffset(int heapAddress, int offset) {
    this.heapAddress = heapAddress;
    this.offset = offset;
  }
  
  public String toString() {
    return "(" + heapAddress + " + " + offset + ")";
  }
}
