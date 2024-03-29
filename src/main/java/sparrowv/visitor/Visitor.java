package sparrowv.visitor;

import sparrowv.*;

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

  /*   Register lhs;
   *   int rhs; */
  void visit(Move_Reg_Integer n);

  /*   Register lhs;
   *   FunctionName rhs; */
  void visit(Move_Reg_FuncName n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(Add n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(Subtract n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(Multiply n);

  /*   Register lhs;
   *   Register arg1;
   *   Register arg2; */
  void visit(LessThan n);

  /*   Register lhs;
   *   Register base;
   *   int offset; */
  void visit(Load n);

  /*   Register base;
   *   int offset;
   *   Register rhs; */
  void visit(Store n);

  /*   Register lhs;
   *   Register rhs; */
  void visit(Move_Reg_Reg n);

  /*   Identifier lhs;
   *   Register rhs; */
  void visit(Move_Id_Reg n);

  /*   Register lhs;
   *   Identifier rhs; */
  void visit(Move_Reg_Id n);

  /*   Register lhs;
   *   Register size; */
  void visit(Alloc n);

  /*   Register content; */
  void visit(Print n);

  /*   String msg; */
  void visit(ErrorMessage n);

  /*   Label label; */
  void visit(Goto n);

  /*   Register condition;
   *   Label label; */
  void visit(IfGoto n);

  /*   Register lhs;
   *   Register callee;
   *   List<Identifier> args; */
  void visit(Call n);
}
