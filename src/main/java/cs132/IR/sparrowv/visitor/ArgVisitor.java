package cs132.IR.sparrowv.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrowv.*;

public interface ArgVisitor<A> {

  /*   ArrayList<FunctionDecl> funDecls; */
  void visit(Program n, A arg);

  /*   Program parent;
   *   FunctionName functionName;
   *   ArrayList<Identifier> formalParameters;
   *   Block block; */
  void visit(FunctionDecl n, A arg);

  /*   FunctionDecl parent;
   *   ArrayList<Instruction> instructions;
   *   Identifier return_id; */
  void visit(Block n, A arg);

  /*   Label label; */
  void visit(LabelInstr n, A arg);

  /*   Register lhs;
   *   int rhs; */
  void visit(Move_Reg_Integer n, A arg);

  /*   Register lhs;
   *   FunctionName rhs; */
  void visit(Move_Reg_FuncName n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(Add n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(Subtract n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(Multiply n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(LessThan n, A arg);

  /*   Register lhs;
   *   Register base;
   *   int offset; */
  void visit(Load n, A arg);

  /*   Register base;
   *   int offset;
   *   Register rhs; */
  void visit(Store n, A arg);

  /*   Register lhs;
   *   Register rhs; */
  public void visit(Move_Reg_Reg n, A arg);

  /*   Identifier lhs;
   *   Register rhs; */
  public void visit(Move_Id_Reg n, A arg);

  /*   Register lhs;
   *   Identifier rhs; */
  public void visit(Move_Reg_Id n, A arg);

  /*   Register lhs;
   *   Register size; */
  void visit(Alloc n, A arg);

  /*   Register content; */
  void visit(Print n, A arg);

  /*   String msg; */
  void visit(ErrorMessage n, A arg);

  /*   Label label; */
  void visit(Goto n, A arg);

  /*   Register condition;
   *   Label label; */
  void visit(IfGoto n, A arg);

  /*   Register lhs;
   *   Register callee;
   *   ArrayList<Identifier> args; */
  void visit(Call n, A arg);
}
