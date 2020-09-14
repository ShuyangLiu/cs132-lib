package cs132.IR.sparrow.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrow.*;

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

  /*   Identifier lhs;
   *   int rhs; */
  void visit(Move_Id_Integer n, A arg);

  /*   Identifier lhs;
   *   FunctionName rhs; */
  void visit(Move_Id_FuncName n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(Add n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(Subtract n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(Multiply n, A arg);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(LessThan n, A arg);

  /*   Identifier lhs;
   *   Identifier base;
   *   int offset; */
  void visit(Load n, A arg);

  /*   Identifier base;
   *   int offset;
   *   Identifier rhs; */
  void visit(Store n, A arg);

  /*   Identifier lhs;
   *   Identifier rhs; */
  void visit(Move_Id_Id n, A arg);

  /*   Identifier lhs;
   *   Identifier size; */
  void visit(Alloc n, A arg);

  /*   Identifier content; */
  void visit(Print n, A arg);

  /*   String msg; */
  void visit(ErrorMessage n, A arg);

  /*   Label label; */
  void visit(Goto n, A arg);

  /*   Identifier condition;
   *   Label label; */
  void visit(IfGoto n, A arg);

  /*   Identifier lhs;
   *   Identifier callee;
   *   ArrayList<Identifier> args; */
  void visit(Call n, A arg);
}
