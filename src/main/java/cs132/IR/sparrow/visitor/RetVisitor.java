package cs132.IR.sparrow.visitor;

import cs132.IR.sparrow.*;

public interface RetVisitor<R> {

  /*   List<FunctionDecl> funDecls; */
  R visit(Program n);

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  R visit(FunctionDecl n);

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  R visit(Block n);

  /*   Label label; */
  R visit(LabelInstr n);

  /*   Identifier lhs;
   *   int rhs; */
  R visit(Move_Id_Integer n);

  /*   Identifier lhs;
   *   FunctionName rhs; */
  R visit(Move_Id_FuncName n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(Add n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(Subtract n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(Multiply n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(LessThan n);

  /*   Identifier lhs;
   *   Identifier base;
   *   int offset; */
  R visit(Load n);

  /*   Identifier base;
   *   int offset;
   *   Identifier rhs; */
  R visit(Store n);

  /*   Identifier lhs;
   *   Identifier rhs; */
  R visit(Move_Id_Id n);

  /*   Identifier lhs;
   *   Identifier size; */
  R visit(Alloc n);

  /*   Identifier content; */
  R visit(Print n);

  /*   String msg; */
  R visit(ErrorMessage n);

  /*   Label label; */
  R visit(Goto n);

  /*   Identifier condition;
   *   Label label; */
  R visit(IfGoto n);

  /*   Identifier lhs;
   *   Identifier callee;
   *   List<Identifier> args; */
  R visit(Call n);
}
