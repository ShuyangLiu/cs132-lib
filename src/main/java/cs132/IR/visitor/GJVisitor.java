//
// Generated by JTB 1.3.2
//

package cs132.IR.visitor;
import cs132.IR.syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( FunctionDeclaration() )*
    * f1 -> <EOF>
    */
   public R visit(Program n, A argu);

   /**
    * f0 -> "func"
    * f1 -> FunctionName()
    * f2 -> "("
    * f3 -> ( Identifier() )*
    * f4 -> ")"
    * f5 -> Block()
    */
   public R visit(FunctionDeclaration n, A argu);

   /**
    * f0 -> ( Instruction() )*
    * f1 -> "return"
    * f2 -> Identifier()
    */
   public R visit(Block n, A argu);

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
   public R visit(Instruction n, A argu);

   /**
    * f0 -> Label()
    * f1 -> ":"
    */
   public R visit(LabelWithColon n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> IntegerLiteral()
    */
   public R visit(SetInteger n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "@"
    * f3 -> FunctionName()
    */
   public R visit(SetFuncName n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "+"
    * f4 -> Identifier()
    */
   public R visit(Add n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "-"
    * f4 -> Identifier()
    */
   public R visit(Subtract n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "*"
    * f4 -> Identifier()
    */
   public R visit(Multiply n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    * f3 -> "<"
    * f4 -> Identifier()
    */
   public R visit(LessThan n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "+"
    * f5 -> IntegerLiteral()
    * f6 -> "]"
    */
   public R visit(Load n, A argu);

   /**
    * f0 -> "["
    * f1 -> Identifier()
    * f2 -> "+"
    * f3 -> IntegerLiteral()
    * f4 -> "]"
    * f5 -> "="
    * f6 -> Identifier()
    */
   public R visit(Store n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> Identifier()
    */
   public R visit(Move n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "alloc"
    * f3 -> "("
    * f4 -> Identifier()
    * f5 -> ")"
    */
   public R visit(Alloc n, A argu);

   /**
    * f0 -> "print"
    * f1 -> "("
    * f2 -> Identifier()
    * f3 -> ")"
    */
   public R visit(Print n, A argu);

   /**
    * f0 -> "error"
    * f1 -> "("
    * f2 -> StringLiteral()
    * f3 -> ")"
    */
   public R visit(ErrorMessage n, A argu);

   /**
    * f0 -> "goto"
    * f1 -> Label()
    */
   public R visit(Goto n, A argu);

   /**
    * f0 -> "if0"
    * f1 -> Identifier()
    * f2 -> "goto"
    * f3 -> Label()
    */
   public R visit(IfGoto n, A argu);

   /**
    * f0 -> Identifier()
    * f1 -> "="
    * f2 -> "call"
    * f3 -> Identifier()
    * f4 -> "("
    * f5 -> ( Identifier() )*
    * f6 -> ")"
    */
   public R visit(Call n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(FunctionName n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Label n, A argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Identifier n, A argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu);

   /**
    * f0 -> <STRINGCONSTANT>
    */
   public R visit(StringLiteral n, A argu);

    R visit(If anIf, A argu);

   public R visit(LabeledInstruction n, A argu);
}
