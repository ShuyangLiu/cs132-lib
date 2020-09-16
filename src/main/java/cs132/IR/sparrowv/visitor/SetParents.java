package cs132.IR.sparrowv.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrowv.*;

public class SetParents extends DepthFirst {

  /*   List<FunctionDecl> funDecls; */
  public void visit(Program n) {
    for (FunctionDecl fd: n.funDecls) {
        fd.parent = n;
        fd.accept(this);
    }
  }

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n) {
    n.block.parent = n;
    n.block.accept(this);
  }

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id ; */
  public void visit(Block n) {
    for (Instruction i: n.instructions) {
        i.parent = n;
    }
  }
}
