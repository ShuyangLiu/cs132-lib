package cs132.IR.sparrowv.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrowv.*;

public class GetFunctionDecl extends DoNothing {

  FunctionName ce;
  FunctionDecl result;

  public GetFunctionDecl(FunctionName ce) {
    this.ce = ce;
  }

  /*   ArrayList<FunctionDecl> funDecls; */
  public void visit(Program n) {
    for (FunctionDecl fd: n.funDecls) {
      if (fd.functionName.toString().equals(ce.toString())) {
         result = fd;
      }
    }
  }
}
