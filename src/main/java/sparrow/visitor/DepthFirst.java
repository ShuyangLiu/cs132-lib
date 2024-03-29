package sparrow.visitor;

import IR.token.Identifier;
import sparrow.*;

public class DepthFirst implements Visitor {

  /*   List<FunctionDecl> funDecls; */
  public void visit(Program n) {
    for (FunctionDecl fd: n.funDecls) {
        fd.accept(this);
    }
  }

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n) {
    for (Identifier fp: n.formalParameters) {
        // ... fp ...
    }
    n.block.accept(this);
  }

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  public void visit(Block n) {
    for (Instruction i: n.instructions) {
        i.accept(this);
    }
  }

  /*   Label label; */
  public void visit(LabelInstr n) {
  }

  /*   Identifier lhs;
   *   int rhs; */
  public void visit(Move_Id_Integer n) {
  }

  /*   Identifier lhs;
   *   FunctionName rhs; */
  public void visit(Move_Id_FuncName n) {
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(Add n) {
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(Subtract n) {
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(Multiply n) {
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(LessThan n) {
  }

  /*   Identifier lhs;
   *   Identifier base;
   *   int offset; */
  public void visit(Load n) {
  }

  /*   Identifier base;
   *   int offset;
   *   Identifier rhs; */
  public void visit(Store n) {
  }

  /*   Identifier lhs;
   *   Identifier rhs; */
  public void visit(Move_Id_Id n) {
  }

  /*   Identifier lhs;
   *   Identifier size; */
  public void visit(Alloc n) {
  }

  /*   Identifier content; */
  public void visit(Print n) {
  }

  /*   String msg; */
  public void visit(ErrorMessage n) {
  }

  /*   Label label; */
  public void visit(Goto n) {
  }

  /*   Identifier condition;
   *   Label label; */
  public void visit(IfGoto n) {
  }

  /*   Identifier lhs;
   *   Identifier callee;
   *   List<Identifier> args; */
  public void visit(Call n) {
  }
}
