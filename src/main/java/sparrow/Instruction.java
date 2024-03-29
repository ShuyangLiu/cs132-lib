package sparrow;

import sparrow.visitor.ArgRetVisitor;
import sparrow.visitor.ArgVisitor;
import sparrow.visitor.RetVisitor;
import sparrow.visitor.Visitor;

public abstract class Instruction {
  public Block parent;

  public abstract void accept(Visitor v);
  public abstract <A> void accept(ArgVisitor<A> v, A arg);
  public abstract <A,R> R accept(ArgRetVisitor<A,R> v, A arg);
  public abstract <R> R accept(RetVisitor<R> v);
  public abstract String toString();
}
