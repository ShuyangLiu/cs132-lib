package cs132.IR.visitor;

import cs132.IR.token.*;
import cs132.IR.syntaxtree.*;

import cs132.IR.sparrowv.visitor.*;
import cs132.IR.registers.Registers;
import java.util.*;

public class SparrowVConstructor extends DepthFirstVisitor {

   cs132.IR.sparrowv.Program program;

   public cs132.IR.sparrowv.Program getProgram() {
     return this.program;
   }


   ArrayList<cs132.IR.sparrowv.FunctionDecl> funList =
     new ArrayList<cs132.IR.sparrowv.FunctionDecl>();

   cs132.IR.sparrowv.FunctionDecl funDecl;

   cs132.IR.sparrowv.Block block;

   ArrayList<cs132.IR.sparrowv.Instruction> instrList =
     new ArrayList<cs132.IR.sparrowv.Instruction>();

   /**
    * f0 -> ( FunctionDeclaration() )*
    * f1 -> <EOF>
    */
   public void visit(Program n) {
      n.f0.accept(this);
      this.program = new cs132.IR.sparrowv.Program(this.funList);
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
                    ((cs132.IR.syntaxtree.Identifier) (e.nextElement())).f0.toString())
            );

      n.f5.accept(this);

      this.funDecl = new cs132.IR.sparrowv.FunctionDecl(
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
      this.instrList = new ArrayList<cs132.IR.sparrowv.Instruction>();
      n.f0.accept(this);

      this.block = new cs132.IR.sparrowv.Block(
        this.instrList,
        new cs132.IR.token.Identifier(n.f2.f0.toString())
      );
   }

   /**
    * f0 -> Label()
    * f1 -> ":"
    */
   public void visit(LabelWithColon n) {
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.LabelInstr(
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Move_Reg_Integer(
          new Register(n.f0.f0.toString()),
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Move_Reg_FuncName(
          new Register(n.f0.f0.toString()),
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Add(
          new Register(n.f0.f0.toString()),
          new Register(n.f2.f0.toString()),
          new Register(n.f4.f0.toString())
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Subtract(
          new Register(n.f0.f0.toString()),
          new Register(n.f2.f0.toString()),
          new Register(n.f4.f0.toString())
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Multiply(
          new Register(n.f0.f0.toString()),
          new Register(n.f2.f0.toString()),
          new Register(n.f4.f0.toString())
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.LessThan(
          new Register(n.f0.f0.toString()),
          new Register(n.f2.f0.toString()),
          new Register(n.f4.f0.toString())
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Load(
          new Register(n.f0.f0.toString()),
          new Register(n.f3.f0.toString()),
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Store(
          new Register(n.f1.f0.toString()),
          Integer.parseInt( n.f3.f0.toString() ),
          new Register(n.f6.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    */
   public void visit(Move n) {
      if (Registers.riscVregs.contains(n.f0.f0.toString())) {
         if (Registers.riscVregs.contains(n.f2.f0.toString())) {
            cs132.IR.sparrowv.Instruction instruction =
              new cs132.IR.sparrowv.Move_Reg_Reg(
                new Register(n.f0.f0.toString()),
                new Register(n.f2.f0.toString())
              );
            this.instrList.add(instruction);
         }
         else {
            cs132.IR.sparrowv.Instruction instruction =
              new cs132.IR.sparrowv.Move_Reg_Id(
                new Register(n.f0.f0.toString()),
                new cs132.IR.token.Identifier(n.f2.f0.toString())
              );
            this.instrList.add(instruction);
         }
      }
      else {
            cs132.IR.sparrowv.Instruction instruction =
              new cs132.IR.sparrowv.Move_Id_Reg(
                new cs132.IR.token.Identifier(n.f0.f0.toString()),
                new Register(n.f2.f0.toString())
              );
            this.instrList.add(instruction);
      }
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Alloc(
          new Register(n.f0.f0.toString()),
          new Register(n.f4.f0.toString())
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Print(
          new Register(n.f2.f0.toString())
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.ErrorMessage(
          n.f2.f0.toString()
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "goto"
    * f1 -> Label()
    */
   public void visit(Goto n) {
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Goto(
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
      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.IfGoto(
          new Register(n.f1.f0.toString()),
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

      cs132.IR.sparrowv.Instruction instruction =
        new cs132.IR.sparrowv.Call(
          new Register(n.f0.f0.toString()),
          new Register(n.f3.f0.toString()),
          actualParameterList
        );
      this.instrList.add(instruction);
   }
}
