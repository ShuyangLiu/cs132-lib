//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * Grammar production:
 * f0 -> Identifier()
 * f1 -> "="
 * f2 -> "call"
 * f3 -> Identifier()
 * f4 -> "("
 * f5 -> ( Identifier() )*
 * f6 -> ")"
 */
public class Call implements Node {
   public Identifier f0;
   public NodeToken f1;
   public NodeToken f2;
   public Identifier f3;
   public NodeToken f4;
   public NodeListOptional f5;
   public NodeToken f6;

   public Call(Identifier n0, NodeToken n1, NodeToken n2, Identifier n3, NodeToken n4, NodeListOptional n5, NodeToken n6) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
   }

   public Call(Identifier n0, Identifier n1, NodeListOptional n2) {
      f0 = n0;
      f1 = new NodeToken("=");
      f2 = new NodeToken("call");
      f3 = n1;
      f4 = new NodeToken("(");
      f5 = n2;
      f6 = new NodeToken(")");
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
