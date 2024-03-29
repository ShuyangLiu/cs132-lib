//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * Grammar production:
 * f0 -> Identifier()
 * f1 -> "="
 * f2 -> IntegerLiteral()
 */
public class SetInteger implements Node {
   public Identifier f0;
   public NodeToken f1;
   public IntegerLiteral f2;

   public SetInteger(Identifier n0, NodeToken n1, IntegerLiteral n2) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
   }

   public SetInteger(Identifier n0, IntegerLiteral n1) {
      f0 = n0;
      f1 = new NodeToken("=");
      f2 = n1;
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

