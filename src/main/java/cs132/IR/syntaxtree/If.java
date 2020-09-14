//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * Grammar production:
 * f0 -> "if0"
 * f1 -> Identifier()
 * f2 -> "goto"
 * f3 -> Label()
 */
public class If implements Node {
   public NodeToken f0;
   public Identifier f1;
   public NodeToken f2;
   public Label f3;

   public If(NodeToken n0, Identifier n1, NodeToken n2, Label n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public If(Identifier n0, Label n1) {
      f0 = new NodeToken("if0");
      f1 = n0;
      f2 = new NodeToken("goto");
      f3 = n1;
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

