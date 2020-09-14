//
// Generated by JTB 1.3.2
//

package cs132.minijava.syntaxtree;

/**
 * Grammar production:
 * f0 -> Type()
 * f1 -> Identifier()
 */
public class FormalParameter implements Node {
   public Type f0;
   public Identifier f1;

   public FormalParameter(Type n0, Identifier n1) {
      f0 = n0;
      f1 = n1;
   }

   public void accept(cs132.minijava.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(cs132.minijava.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(cs132.minijava.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(cs132.minijava.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

