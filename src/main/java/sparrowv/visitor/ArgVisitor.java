package sparrowv.visitor;

import sparrowv.*;

public interface ArgVisitor<A> {

  /*   List<FunctionDecl> funDecls; */
  public void visit(Program n, A arg);

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n, A arg);

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  public void visit(Block n, A arg);

  /*   Label label; */
  public void visit(LabelInstr n, A arg);

  /*   Register lhs;
   *   int rhs; */
  public void visit(Move_Reg_Integer n, A arg);

  /*   Register lhs;
   *   FunctionName rhs; */
  public void visit(Move_Reg_FuncName n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(Add n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(Subtract n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(Multiply n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public void visit(LessThan n, A arg);

  /*   Register lhs;
   *   Register base;
   *   int offset; */
  public void visit(Load n, A arg);

  /*   Register base;
   *   int offset;
   *   Register rhs; */
  public void visit(Store n, A arg);

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
  public void visit(Alloc n, A arg);

  /*   Register content; */
  public void visit(Print n, A arg);

  /*   String msg; */
  public void visit(ErrorMessage n, A arg);

  /*   Label label; */
  public void visit(Goto n, A arg);

  /*   Register condition;
   *   Label label; */
  public void visit(IfGoto n, A arg);

  /*   Register lhs;
   *   Register callee;
   *   List<Identifier> args; */
  public void visit(Call n, A arg);
}
