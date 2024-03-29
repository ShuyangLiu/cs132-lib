package sparrowv.visitor;

import sparrowv.*;

public interface RetVisitor <R> {
      /*   List<FunctionDecl> funDecls; */
  public R visit(Program n);

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  public R visit(FunctionDecl n);

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  public R visit(Block n);

  /*   Label label; */
  public R visit(LabelInstr n);

  /*   Register lhs;
   *   int rhs; */
  public R visit(Move_Reg_Integer n);

  /*   Register lhs;
   *   FunctionName rhs; */
  public R visit(Move_Reg_FuncName n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(Add n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(Subtract n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(Multiply n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  public R visit(LessThan n);

  /*   Register lhs;
   *   Register base;
   *   int offset; */
  public R visit(Load n);

  /*   Register base;
   *   int offset;
   *   Register rhs; */
  public R visit(Store n);

  /*   Register lhs;
   *   Register rhs; */
  public R visit(Move_Reg_Reg n);

  /*   Identifier lhs;
   *   Register rhs; */
  public R visit(Move_Id_Reg n);

  /*   Register lhs;
   *   Identifier rhs; */
  public R visit(Move_Reg_Id n);

  /*   Register lhs;
   *   Register size; */
  public R visit(Alloc n);

  /*   Register content; */
  public R visit(Print n);

  /*   String msg; */
  public R visit(ErrorMessage n);

  /*   Label label; */
  public R visit(Goto n);

  /*   Register condition;
   *   Label label; */
  public R visit(IfGoto n);

  /*   Register lhs;
   *   Register callee;
   *   List<Identifier> args; */
  public R visit(Call n);
}