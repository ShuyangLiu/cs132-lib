package IR.visitor;

import IR.registers.Registers;
import IR.syntaxtree.Add;
import IR.syntaxtree.Alloc;
import IR.syntaxtree.Call;
import IR.syntaxtree.ErrorMessage;
import IR.syntaxtree.Goto;
import IR.syntaxtree.IfGoto;
import IR.syntaxtree.LessThan;
import IR.syntaxtree.Load;
import IR.syntaxtree.Multiply;
import IR.syntaxtree.Print;
import IR.syntaxtree.Store;
import IR.syntaxtree.Subtract;
import IR.syntaxtree.*;
import IR.token.FunctionName;
import IR.token.Identifier;
import IR.token.Label;
import IR.token.Register;
import sparrowv.Instruction;
import sparrowv.*;
import sparrowv.visitor.SetParents;

import java.util.ArrayList;
import java.util.Enumeration;

public class SparrowVConstructor extends DepthFirstVisitor {

   sparrowv.Program program;

   public sparrowv.Program getProgram() {
     return this.program;
   }


   ArrayList<FunctionDecl> funList =
     new ArrayList<FunctionDecl>();

   FunctionDecl funDecl;

   sparrowv.Block block;

   ArrayList<Instruction> instrList =
     new ArrayList<Instruction>();

   /**
    * f0 -> ( FunctionDeclaration() )*
    * f1 -> <EOF>
    */
   public void visit(IR.syntaxtree.Program n) {
      n.f0.accept(this);
      this.program = new sparrowv.Program(this.funList);
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
      ArrayList<Identifier> formalParameters =
        new ArrayList<Identifier>();
      if ( n.f3.present() )
         for (Enumeration<Node> e = n.f3.elements(); e.hasMoreElements(); )
            formalParameters.add(
              new Identifier(
                    ((IR.syntaxtree.Identifier) (e.nextElement())).f0.toString())
            );

      n.f5.accept(this);

      this.funDecl = new FunctionDecl(
        new FunctionName(n.f1.f0.toString()),
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
   public void visit(IR.syntaxtree.Block n) {
      this.instrList = new ArrayList<Instruction>();
      n.f0.accept(this);

      this.block = new sparrowv.Block(
        this.instrList,
        new Identifier(n.f2.f0.toString())
      );
   }

   /**
    * f0 -> Label()
    * f1 -> ":"
    */
   public void visit(LabelWithColon n) {
      Instruction instruction =
        new LabelInstr(
          new Label(n.f0.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> IntegerLiteral()
    */
   public void visit(SetInteger n) {
      Instruction instruction =
        new Move_Reg_Integer(
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
      Instruction instruction =
        new Move_Reg_FuncName(
          new Register(n.f0.f0.toString()),
          new FunctionName(n.f3.f0.toString())
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
      Instruction instruction =
        new sparrowv.Add(
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
      Instruction instruction =
        new sparrowv.Subtract(
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
      Instruction instruction =
        new sparrowv.Multiply(
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
      Instruction instruction =
        new sparrowv.LessThan(
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
      Instruction instruction =
        new sparrowv.Load(
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
      Instruction instruction =
        new sparrowv.Store(
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
            Instruction instruction =
              new Move_Reg_Reg(
                new Register(n.f0.f0.toString()),
                new Register(n.f2.f0.toString())
              );
            this.instrList.add(instruction);
         }
         else {
            Instruction instruction =
              new Move_Reg_Id(
                new Register(n.f0.f0.toString()),
                new Identifier(n.f2.f0.toString())
              );
            this.instrList.add(instruction);
         }
      }
      else {
            Instruction instruction =
              new Move_Id_Reg(
                new Identifier(n.f0.f0.toString()),
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
      Instruction instruction =
        new sparrowv.Alloc(
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
      Instruction instruction =
        new sparrowv.Print(
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
      Instruction instruction =
        new sparrowv.ErrorMessage(
          n.f2.f0.toString()
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> "goto"
    * f1 -> Label()
    */
   public void visit(Goto n) {
      Instruction instruction =
        new sparrowv.Goto(
          new Label(n.f1.f0.toString())
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
      Instruction instruction =
        new sparrowv.IfGoto(
          new Register(n.f1.f0.toString()),
          new Label(n.f3.f0.toString())
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
      ArrayList<Identifier> actualParameterList =
        new ArrayList<Identifier>();
      if ( n.f5.present() )
         for ( Enumeration<Node> e = n.f5.elements(); e.hasMoreElements(); )
            actualParameterList.add(
              new Identifier(
                ((IR.syntaxtree.Identifier) (e.nextElement())).f0.toString()
              )
            );
    
      n.f5.accept(this);

      Instruction instruction =
        new sparrowv.Call(
          new Register(n.f0.f0.toString()),
          new Register(n.f3.f0.toString()),
          actualParameterList
        );
      this.instrList.add(instruction);
   }
}
