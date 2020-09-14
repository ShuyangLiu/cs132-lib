package cs132.IR.sparrow.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrow.*;

public class DoNothing implements Visitor {

  /*   ArrayList<FunctionDecl> funDecls; */
  public void visit(Program n) {
  }

  /*   Program parent;
   *   FunctionName functionName;
   *   ArrayList<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n) {
  }

  /*   FunctionDecl parent;
   *   ArrayList<Instruction> instructions;
   *   Identifier return_id; */
  public void visit(Block n) {
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
   *   ArrayList<Identifier> args; */
  public void visit(Call n) {
  }
}
