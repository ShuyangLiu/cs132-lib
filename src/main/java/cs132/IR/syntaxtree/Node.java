//
// Generated by JTB 1.3.2
//

package cs132.IR.syntaxtree;

/**
 * The interface which all syntax tree classes must implement.
 */
public interface Node extends java.io.Serializable {
   public void accept(cs132.IR.visitor.Visitor v);
   public <R,A> R accept(cs132.IR.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(cs132.IR.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(cs132.IR.visitor.GJVoidVisitor<A> v, A argu);
}

