package cs132.IR.errors;

import cs132.IR.token.*;
import cs132.IR.registers.Registers;
import java.util.List;

public class ErrorReport {
 
  boolean valid = true;
  String errorMessage = "";

  public boolean getValid() {
    return this.valid;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public void error(String msg) {
    this.valid = false; 
    if (this.errorMessage.equals("")) {
       this.errorMessage = "Error: " + msg;
    }
    else {
       this.errorMessage = this.errorMessage + "\n" + 
                           "Error: " + msg;
    }
  }

  public void checkProgramIsNonempty(int size) {
    if (size == 0) {
       error( "The program has no function declarations" );
    }
  }

  public void checkFirstFunctionHasZeroParameters(List<Identifier> l) {
    if (l.size() > 0) {
       error( "The first function declaration must have zero parameters" );
    }
  }

  public void checkIdentifier(String n, Identifier id) {
    if (Registers.riscVregs.contains(id.toString())) {
       error( n + "\n       uses the RISC-V register " + id +
                  " as an identifier" );
    }
  }

  public void checkRegister(String n, Register r) {
    if (!(Registers.riscVregs.contains(r.toString()))) {
       error( n + "\n       uses the identifier " + r +
                  " as a RISC-V register" );
    }
  }

  public void checkOffset(String n, int offset) {
    if (! (offset >= 0)) {
       // Seems like we cannot encounter this error
       error( n + "\n       uses the offset " + offset +
                  " that is less than 0" );
    }
    if (! (offset % 4 == 0)) {
       error( n + "\n       uses the offset " + offset +
                  " that is not divisible by 4" );
    }
  }

  public void checkLabel(boolean found, String place, Label label) {
    if (!found) {
       error( place + "\n       uses the label " + label +
                  " which is undefined in that block" );
    }
  }

  public void checkFunctionName(boolean found, String place, FunctionName fn) {
    if (!found) {
       error( place + "\n       uses the function name " + fn + 
                  " which is undefined" );
    }
  }

  public void checkForDuplicates(String place, String kind, List<String> l) {
    for (int i=0; i<l.size(); i++) {
       for (int j=i+1; j<l.size(); j++) {
           if (l.get(i).equals
              (l.get(j))) {
                   error(
                     place + " declares the " + kind + " " + 
                     l.get(i) + " more than once" );
           }
       }
    }
  }
}
