//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * Grammar production:
 * f0 -> <IDENTIFIER>
 */
public class Label implements Node {
   public NodeToken f0;

   public Label(NodeToken n0) {
      f0 = n0;
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

