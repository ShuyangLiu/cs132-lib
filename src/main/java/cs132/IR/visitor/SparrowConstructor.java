package cs132.IR.visitor;

import cs132.IR.syntaxtree.*;
import cs132.IR.sparrow.visitor.*;
import cs132.IR.registers.Registers;
import java.util.*;

public class SparrowConstructor extends DepthFirstVisitor {

   cs132.IR.sparrow.Program program;

   public cs132.IR.sparrow.Program getProgram() {
     return this.program;
   }


   ArrayList<cs132.IR.sparrow.FunctionDecl> funList =
     new ArrayList<cs132.IR.sparrow.FunctionDecl>();

   cs132.IR.sparrow.FunctionDecl funDecl;

   cs132.IR.sparrow.Block block;

   ArrayList<cs132.IR.sparrow.Instruction> instrList =
     new ArrayList<cs132.IR.sparrow.Instruction>();

   /**
    * f0 -> ( FunctionDeclaration() )*
    * f1 -> <EOF>
    */
   public void visit(Program n) {
      n.f0.accept(this);
      this.program = new cs132.IR.sparrow.Program(this.funList);
      this.program.accept(new SetParents());
   }

   /**
    * f0 -> "func"
    * f1 -> FunctionName()
    * f2 -> "("
    * f3 -> ( Identifier() )*
    * f4 -> ")"
    * f5 -> Block()
    */
   public void visit(FunctionDeclaration n) {
      ArrayList<cs132.IR.token.Identifier> formalParameters =
        new ArrayList<cs132.IR.token.Identifier>();
      if ( n.f3.present() )
         for ( Enumeration<Node> e = n.f3.elements(); e.hasMoreElements(); )
            formalParameters.add(
              new cs132.IR.token.Identifier(
                 ((cs132.IR.syntaxtree.Identifier) (e.nextElement())).f0.toString()
              )
            );

      n.f5.accept(this);

      this.funDecl = new cs132.IR.sparrow.FunctionDecl(
        new cs132.IR.token.FunctionName(n.f1.f0.toString()),
        formalParameters,
        this.block
      );

      this.funList.add(this.funDecl);
   }

   /**
    * f0 -> ( Instruction() )*
    * f1 -> "return"
    * f2 -> Identifier()
    */
   public void visit(Block n) {
      this.instrList = new ArrayList<cs132.IR.sparrow.Instruction>();
      n.f0.accept(this);

      this.block = new cs132.IR.sparrow.Block(
        this.instrList,
        new cs132.IR.token.Identifier(n.f2.f0.toString())
      );
   }

   /**
    * f0 -> Label()
    * f1 -> ":"
    */
   public void visit(LabelWithColon n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.LabelInstr(
          new cs132.IR.token.Label(n.f0.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> IntegerLiteral()
    */
   public void visit(SetInteger n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Move_Id_Integer(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          Integer.parseInt( n.f2.f0.toString() )
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "@"
    * f3 -> FunctionName()
    */
   public void visit(SetFuncName n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Move_Id_FuncName(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.FunctionName(n.f3.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "+"
    * f4 -> Identifier()
    */
   public void visit(Add n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Add(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f2.f0.toString()),
          new cs132.IR.token.Identifier(n.f4.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "-"
    * f4 -> Identifier()
    */
   public void visit(Subtract n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Subtract(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f2.f0.toString()),
          new cs132.IR.token.Identifier(n.f4.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "*"
    * f4 -> Identifier()
    */
   public void visit(Multiply n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Multiply(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f2.f0.toString()),
          new cs132.IR.token.Identifier(n.f4.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "<"
    * f4 -> Identifier()
    */
   public void visit(LessThan n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.LessThan(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f2.f0.toString()),
          new cs132.IR.token.Identifier(n.f4.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "+"
    * f5 -> IntegerLiteral()
    * f6 -> "]"
    */
   public void visit(Load n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Load(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f3.f0.toString()),
          Integer.parseInt( n.f5.f0.toString() )
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "["
    * f1 -> Identifier()
    * f2 -> "+"
    * f3 -> IntegerLiteral()
    * f4 -> "]"
    * f5 -> "="
    * f6 -> Identifier()
    */
   public void visit(Store n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Store(
          new cs132.IR.token.Identifier(n.f1.f0.toString()),
          Integer.parseInt( n.f3.f0.toString() ),
          new cs132.IR.token.Identifier(n.f6.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    */
   public void visit(Move n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Move_Id_Id(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f2.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "alloc"
    * f3 -> "("
    * f4 -> Identifier()
    * f5 -> ")"
    */
   public void visit(Alloc n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Alloc(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f4.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "print"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    */
   public void visit(Print n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Print(
          new cs132.IR.token.Identifier(n.f2.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "error"
    * f1 -> "("
    * f2 -> StringLiteral()
    * f3 -> ")"
    */
   public void visit(ErrorMessage n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.ErrorMessage(
          n.f2.f0.toString()
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "goto"
    * f1 -> Label()
    */
   public void visit(Goto n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Goto(
          new cs132.IR.token.Label(n.f1.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "if0"
    * f1 -> Identifier()
    * f2 -> "goto"
    * f3 -> Label()
    */
   public void visit(IfGoto n) {
      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.IfGoto(
          new cs132.IR.token.Identifier(n.f1.f0.toString()),
          new cs132.IR.token.Label(n.f3.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "call"
    * f3 -> Identifier()
    * f4 -> "("
    * f5 -> ( Identifier() )*
    * f6 -> ")"
    */
   public void visit(Call n) {
      ArrayList<cs132.IR.token.Identifier> actualParameterList =
        new ArrayList<cs132.IR.token.Identifier>();
      if ( n.f5.present() )
         for ( Enumeration<Node> e = n.f5.elements(); e.hasMoreElements(); )
            actualParameterList.add(
              new cs132.IR.token.Identifier(
                ((cs132.IR.syntaxtree.Identifier) (e.nextElement())).f0.toString()
              )
            );
    
      n.f5.accept(this);

      cs132.IR.sparrow.Instruction instruction =
        new cs132.IR.sparrow.Call(
          new cs132.IR.token.Identifier(n.f0.f0.toString()),
          new cs132.IR.token.Identifier(n.f3.f0.toString()),
          actualParameterList
        );
      this.instrList.add(instruction);
   }
}
