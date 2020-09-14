package cs132.IR.sparrow.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrow.*;

public class SetParents extends DepthFirst {

  /*   ArrayList<FunctionDecl> funDecls; */
  public void visit(Program n) {
    for (FunctionDecl fd: n.funDecls) {
        fd.parent = n;
        fd.accept(this);
    }
  }

  /*   Program parent;
   *   FunctionName functionName;
   *   ArrayList<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n) {
    n.block.parent = n;
    n.block.accept(this);
  }

  /*   FunctionDecl parent;
   *   ArrayList<Instruction> instructions;
   *   Identifier return_id ; */
  public void visit(Block n) {
    for (Instruction i: n.instructions) {
        i.parent = n;
    }
  }
}
