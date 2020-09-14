//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * Grammar production:
 * f0 -> "func"
 * f1 -> FunctionName()
 * f2 -> "("
 * f3 -> ( Identifier() )*
 * f4 -> ")"
 * f5 -> Block()
 */
public class FunctionDeclaration implements Node {
   public NodeToken f0;
   public FunctionName f1;
   public NodeToken f2;
   public NodeListOptional f3;
   public NodeToken f4;
   public Block f5;

   public FunctionDeclaration(NodeToken n0, FunctionName n1, NodeToken n2, NodeListOptional n3, NodeToken n4, Block n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public FunctionDeclaration(FunctionName n0, NodeListOptional n1, Block n2) {
      f0 = new NodeToken("func");
      f1 = n0;
      f2 = new NodeToken("(");
      f3 = n1;
      f4 = new NodeToken(")");
      f5 = n2;
   }

   public void accept(cs132.IR.visitor.Visitor v) {
      v.visit(this);
   }
public <R,A> R accept(cs132.IR.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
public <R> R accept(cs132.IR.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }

public <A> void accept(cs132.IR.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }

}
