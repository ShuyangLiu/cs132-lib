//
// Generated by JTB 1.3.2
//

package cs132.minijava.syntaxtree;

/**
 * Represents a grammar choice, e.g. ( A | B )
 */
public class NodeChoice implements Node {
   public NodeChoice(Node node) {
      this(node, -1);
   }

   public NodeChoice(Node node, int whichChoice) {
      choice = node;
      which = whichChoice;
   }

   public void accept(cs132.minijava.visitor.Visitor v) {
      choice.accept(v);
   }
   public <R,A> R accept(cs132.minijava.visitor.GJVisitor<R,A> v, A argu) {
      return choice.accept(v,argu);
   }
   public <R> R accept(cs132.minijava.visitor.GJNoArguVisitor<R> v) {
      return choice.accept(v);
   }
   public <A> void accept(cs132.minijava.visitor.GJVoidVisitor<A> v, A argu) {
      choice.accept(v,argu);
   }

   public Node choice;
   public int which;
}

