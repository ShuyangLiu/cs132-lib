//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * Grammar production:
 * f0 -> Identifier()
 * f1 -> "="
 * f2 -> Identifier()
 * f3 -> "-"
 * f4 -> Identifier()
 */
public class Subtract implements Node {
   public Identifier f0;
   public NodeToken f1;
   public Identifier f2;
   public NodeToken f3;
   public Identifier f4;

   public Subtract(Identifier n0, NodeToken n1, Identifier n2, NodeToken n3, Identifier n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public Subtract(Identifier n0, Identifier n1, Identifier n2) {
      f0 = n0;
      f1 = new NodeToken("=");
      f2 = n1;
      f3 = new NodeToken("-");
      f4 = n2;
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

