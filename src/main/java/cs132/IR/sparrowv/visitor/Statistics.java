package cs132.IR.sparrowv.visitor;

public class Statistics {

  int loadsFromHeap = 0;
  int storesToHeap = 0;
  int loadsToHeap = 0;
  int storesToStack = 0;

  int numberOfDigits(int num) {
    int count = 0;

    while (num != 0) {
      num = num/10;
      count = count + 1;
    }

    return count;
  }

  String spaces(int n) {
    String res = "";
    for (int i=0; i<n; i++) {
      res = res + " ";
    }
    return res;
  }

  public String getStatistics() {
    return "Statistics:\n" + 
           "Loads from the heap:  " + 
           spaces(5 - numberOfDigits(loadsFromHeap)) +
           loadsFromHeap + "\n" +
           "Stores to heap:       " + 
           spaces(5 - numberOfDigits(storesToHeap)) +
           storesToHeap + "\n" +
           "Loads from the stack: " + 
           spaces(5 - numberOfDigits(loadsToHeap)) +
           loadsToHeap + "\n" +
           "Stores to the stack:  " + 
           spaces(5 - numberOfDigits(storesToStack)) +
           storesToStack;
           
  }

  void addLoadFromHeap() {
    loadsFromHeap = loadsFromHeap + 1;
  }

  void addStoreToHeap() {
    storesToHeap = storesToHeap + 1;
  }

  void addLoadFromStack() {
    loadsToHeap = loadsToHeap + 1;
  }

  void addStoreToStack() {
    storesToStack = storesToStack + 1;
  }
}
