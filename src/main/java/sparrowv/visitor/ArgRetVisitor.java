package sparrowv.visitor;

import sparrowv.*;

public interface ArgRetVisitor <A,R> {
      /*   List<FunctionDecl> funDecls; */
  public R visit(Program n, A arg);

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  public R visit(FunctionDecl n, A arg);

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  public R visit(Block n, A arg);

  /*   Label label; */
  public R visit(LabelInstr n, A arg);

  /*   Register lhs;
   *   int rhs; */
  public R visit(Move_Reg_Integer n, A arg);

  /*   Register lhs;
   *   FunctionName rhs; */
  public R visit(Move_Reg_FuncName n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(Add n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(Subtract n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(Multiply n, A arg);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(LessThan n, A arg);

  /*   Register lhs;
   *   Register base;
   *   int offset; */
  public R visit(Load n, A arg);

  /*   Register base;
   *   int offset;
   *   Register rhs; */
  public R visit(Store n, A arg);

  /*   Register lhs;
   *   Register rhs; */
  public R visit(Move_Reg_Reg n, A arg);

  /*   Identifier lhs;
   *   Register rhs; */
  public R visit(Move_Id_Reg n, A arg);

  /*   Register lhs;
   *   Identifier rhs; */
  public R visit(Move_Reg_Id n, A arg);

  /*   Register lhs;
   *   Register size; */
  public R visit(Alloc n, A arg);

  /*   Register content; */
  public R visit(Print n, A arg);

  /*   String msg; */
  public R visit(ErrorMessage n, A arg);

  /*   Label label; */
  public R visit(Goto n, A arg);

  /*   Register condition;
   *   Label label; */
  public R visit(IfGoto n, A arg);

  /*   Register lhs;
   *   Register callee;
   *   List<Identifier> args; */
  public R visit(Call n, A arg);
}