package sparrowv.visitor;

import sparrowv.Block;
import sparrowv.FunctionDecl;
import sparrowv.Instruction;
import sparrowv.Program;

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
