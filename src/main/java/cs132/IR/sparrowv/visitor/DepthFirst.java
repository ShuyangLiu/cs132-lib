package cs132.IR.sparrowv.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrowv.*;

public class DepthFirst implements Visitor {

  /*   ArrayList<FunctionDecl> funDecls; */
  public void visit(Program n) {
    for (FunctionDecl fd: n.funDecls) {
        fd.accept(this);
    }
  }

  /*   Program parent;
   *   FunctionName functionName;
   *   ArrayList<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n) {
    for (Identifier fp: n.formalParameters) {
        // ... fp ...
    }
    n.block.accept(this);
  }

  /*   FunctionDecl parent;
   *   ArrayList<Instruction> instructions;
   *   Identifier return_id; */
  public void visit(Block n) {
    for (Instruction i: n.instructions) {
        i.accept(this);
    }
  }

  /*   Label label; */
  public void visit(LabelInstr n) {
  }

  /*   Register lhs;
   *   int rhs; */
  public void visit(Move_Reg_Integer n) {
  }

  /*   Register lhs;
   *   FunctionName rhs; */
  public void visit(Move_Reg_FuncName n) {
  }

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(Add n) {
  }

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(Subtract n) {
  }

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(Multiply n) {
  }

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(LessThan n) {
  }

  /*   Register lhs;
   *   Register base;
   *   int offset; */
  public void visit(Load n) {
  }

  /*   Register base;
   *   int offset;
   *   Register rhs; */
  public void visit(Store n) {
  }

  /*   Register lhs;
   *   Register rhs; */
  public void visit(Move_Reg_Reg n) {
  }

  /*   Identifier lhs;
   *   Register rhs; */
  public void visit(Move_Id_Reg n) {
  }

  /*   Register lhs;
   *   Identifier rhs; */
  public void visit(Move_Reg_Id n) {
  }

  /*   Register lhs;
   *   Register size; */
  public void visit(Alloc n) {
  }

  /*   Register content; */
  public void visit(Print n) {
  }

  /*   String msg; */
  public void visit(ErrorMessage n) {
  }

  /*   Label label; */
  public void visit(Goto n) {
  }

  /*   Register condition;
   *   Label label; */
  public void visit(IfGoto n) {
  }

  /*   Register lhs;
   *   Register callee;
   *   ArrayList<Identifier> args; */
  public void visit(Call n) {
  }
}
