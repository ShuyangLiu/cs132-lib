//
// Generated by JTB 1.3.2
//

package cs132.IR.visitor;
import cs132.IR.syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJVoidDepthFirst<A> implements GJVoidVisitor<A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
      }
   }

   public void visit(NodeOptional n, A argu) {
      if ( n.present() )
         n.node.accept(this,argu);
   }

   public void visit(NodeSequence n, A argu) {
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
   }

   public void visit(NodeToken n, A argu) {}

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( FunctionDeclaration() )*
    * f1 -> <EOF>
    */
   public void visit(Program n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> "func"
    * f1 -> FunctionName()
    * f2 -> "("
    * f3 -> ( Identifier() )*
    * f4 -> ")"
    * f5 -> Block()
    */
   public void visit(FunctionDeclaration n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
   }

   /**
    * f0 -> ( Instruction() )*
    * f1 -> "return"
    * f2 -> Identifier()
    */
   public void visit(Block n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> LabelWithColon()
    *       | SetInteger()
    *       | SetFuncName()
    *       | Add()
    *       | Subtract()
    *       | Multiply()
    *       | LessThan()
    *       | Load()
    *       | Store()
    *       | Move()
    *       | Alloc()
    *       | Print()
    *       | ErrorMessage()
    *       | Goto()
    *       | IfGoto()
    *       | Call()
    */
   public void visit(Instruction n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> Label()
    * f1 -> ":"
    */
   public void visit(LabelWithColon n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> IntegerLiteral()
    */
   public void visit(SetInteger n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "@"
    * f3 -> FunctionName()
    */
   public void visit(SetFuncName n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "+"
    * f4 -> Identifier()
    */
   public void visit(Add n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "-"
    * f4 -> Identifier()
    */
   public void visit(Subtract n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "*"
    * f4 -> Identifier()
    */
   public void visit(Multiply n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "<"
    * f4 -> Identifier()
    */
   public void visit(LessThan n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
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
   public void visit(Load n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
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
   public void visit(Store n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    */
   public void visit(Move n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
   }

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "alloc"
    * f3 -> "("
    * f4 -> Identifier()
    * f5 -> ")"
    */
   public void visit(Alloc n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
   }

   /**
    * f0 -> "print"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    */
   public void visit(Print n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> "error"
    * f1 -> "("
    * f2 -> StringLiteral()
    * f3 -> ")"
    */
   public void visit(ErrorMessage n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
   }

   /**
    * f0 -> "goto"
    * f1 -> Label()
    */
   public void visit(Goto n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
   }

   /**
    * f0 -> "if0"
    * f1 -> Identifier()
    * f2 -> "goto"
    * f3 -> Label()
    */
   public void visit(IfGoto n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
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
   public void visit(Call n, A argu) {
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      n.f5.accept(this, argu);
      n.f6.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(FunctionName n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Label n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public void visit(Identifier n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public void visit(IntegerLiteral n, A argu) {
      n.f0.accept(this, argu);
   }

   /**
    * f0 -> <STRINGCONSTANT>
    */
   public void visit(StringLiteral n, A argu) {
      n.f0.accept(this, argu);
   }

   @Override
   public void visit(If n, A argu) {
      n.f0.accept(this,argu);
      n.f1.accept(this,argu);
      n.f2.accept(this,argu);
      n.f3.accept(this,argu);
   }

   @Override
   public void visit(LabeledInstruction n, A argu) {
      n.f0.accept(this,argu);
      n.f1.accept(this,argu);
   }

}
