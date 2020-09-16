package cs132.IR.sparrow.visitor;

import cs132.IR.sparrow.*;

public interface ArgRetVisitor<A,R> {

  /*   List<FunctionDecl> funDecls; */
  R visit(Program n, A arg);

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  R visit(FunctionDecl n, A arg);

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  R visit(Block n, A arg);

  /*   Label label; */
  R visit(LabelInstr n, A arg);

  /*   Identifier lhs;
   *   int rhs; */
  R visit(Move_Id_Integer n, A arg);

  /*   Identifier lhs;
   *   FunctionName rhs; */
  R visit(Move_Id_FuncName n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(Add n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(Subtract n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(Multiply n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  R visit(LessThan n, A arg);

  /*   Identifier lhs;
   *   Identifier base;
   *   int offset; */
  R visit(Load n, A arg);

  /*   Identifier base;
   *   int offset;
   *   Identifier rhs; */
  R visit(Store n, A arg);

  /*   Identifier lhs;
   *   Identifier rhs; */
  R visit(Move_Id_Id n, A arg);

  /*   Identifier lhs;
   *   Identifier size; */
  R visit(Alloc n, A arg);

  /*   Identifier content; */
  R visit(Print n, A arg);

  /*   String msg; */
  R visit(ErrorMessage n, A arg);

  /*   Label label; */
  R visit(Goto n, A arg);

  /*   Identifier condition;
   *   Label label; */
  R visit(IfGoto n, A arg);

  /*   Identifier lhs;
   *   Identifier callee;
   *   List<Identifier> args; */
  R visit(Call n, A arg);
}
