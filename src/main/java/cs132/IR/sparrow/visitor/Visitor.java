package cs132.IR.sparrow.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrow.*;

public interface Visitor {

  /*   List<FunctionDecl> funDecls; */
  void visit(Program n);

  /*   Program parent;
   *   FunctionName functionName;
   *   List<Identifier> formalParameters;
   *   Block block; */
  void visit(FunctionDecl n);

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  void visit(Block n);

  /*   Label label; */
  void visit(LabelInstr n);

  /*   Identifier lhs;
   *   int rhs; */
  void visit(Move_Id_Integer n);

  /*   Identifier lhs;
   *   FunctionName rhs; */
  void visit(Move_Id_FuncName n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(Add n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(Subtract n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(Multiply n);

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  void visit(LessThan n);

  /*   Identifier lhs;
   *   Identifier base;
   *   int offset; */
  void visit(Load n);

  /*   Identifier base;
   *   int offset;
   *   Identifier rhs; */
  void visit(Store n);

  /*   Identifier lhs;
   *   Identifier rhs; */
  void visit(Move_Id_Id n);

  /*   Identifier lhs;
   *   Identifier size; */
  void visit(Alloc n);

  /*   Identifier content; */
  void visit(Print n);

  /*   String msg; */
  void visit(ErrorMessage n);

  /*   Label label; */
  void visit(Goto n);

  /*   Identifier condition;
   *   Label label; */
  void visit(IfGoto n);

  /*   Identifier lhs;
   *   Identifier callee;
   *   List<Identifier> args; */
  void visit(Call n);
}
