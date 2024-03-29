package IR.visitor;

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
import sparrow.Instruction;
import sparrow.*;
import sparrow.visitor.SetParents;

import java.util.ArrayList;
import java.util.Enumeration;

public class SparrowConstructor extends DepthFirstVisitor {

   sparrow.Program program;

   public sparrow.Program getProgram() {
     return this.program;
   }


   ArrayList<FunctionDecl> funList =
       new ArrayList<>();

   FunctionDecl funDecl;

   sparrow.Block block;

   ArrayList<Instruction> instrList =
       new ArrayList<>();

   /**
    * f0 -> ( FunctionDeclaration() )*
    * f1 -> <EOF>
    */
   public void visit(IR.syntaxtree.Program n) {
      n.f0.accept(this);
      this.program = new sparrow.Program(this.funList);
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
          new ArrayList<>();
      if ( n.f3.present() )
         for (Enumeration<Node> e = n.f3.elements(); e.hasMoreElements(); )
            formalParameters.add(
              new Identifier(
                 ((IR.syntaxtree.Identifier) (e.nextElement())).f0.toString()
              )
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

      this.block = new sparrow.Block(
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
        new Move_Id_Integer(
          new Identifier(n.f0.f0.toString()),
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
        new Move_Id_FuncName(
          new Identifier(n.f0.f0.toString()),
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
        new sparrow.Add(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f2.f0.toString()),
          new Identifier(n.f4.f0.toString())
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
        new sparrow.Subtract(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f2.f0.toString()),
          new Identifier(n.f4.f0.toString())
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
        new sparrow.Multiply(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f2.f0.toString()),
          new Identifier(n.f4.f0.toString())
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
        new sparrow.LessThan(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f2.f0.toString()),
          new Identifier(n.f4.f0.toString())
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
        new sparrow.Load(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f3.f0.toString()),
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
        new sparrow.Store(
          new Identifier(n.f1.f0.toString()),
          Integer.parseInt( n.f3.f0.toString() ),
          new Identifier(n.f6.f0.toString())
        );
      this.instrList.add(instruction);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    */
   public void visit(Move n) {
      Instruction instruction =
        new Move_Id_Id(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f2.f0.toString())
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
      Instruction instruction =
        new sparrow.Alloc(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f4.f0.toString())
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
        new sparrow.Print(
          new Identifier(n.f2.f0.toString())
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
        new sparrow.ErrorMessage(
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
        new sparrow.Goto(
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
        new sparrow.IfGoto(
          new Identifier(n.f1.f0.toString()),
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
          new ArrayList<>();
      if ( n.f5.present() )
         for ( Enumeration<Node> e = n.f5.elements(); e.hasMoreElements(); )
            actualParameterList.add(
              new Identifier(
                ((IR.syntaxtree.Identifier) (e.nextElement())).f0.toString()
              )
            );
    
      n.f5.accept(this);

      Instruction instruction =
        new sparrow.Call(
          new Identifier(n.f0.f0.toString()),
          new Identifier(n.f3.f0.toString()),
          actualParameterList
        );
      this.instrList.add(instruction);
   }
}
