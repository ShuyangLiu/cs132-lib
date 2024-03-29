package sparrowv;

import sparrowv.visitor.ArgRetVisitor;
import sparrowv.visitor.ArgVisitor;
import sparrowv.visitor.RetVisitor;
import sparrowv.visitor.Visitor;

public abstract class Instruction {
  public Block parent;

  public abstract void accept(Visitor v);
  public abstract <A> void accept(ArgVisitor<A> v, A arg);
  public abstract <A,R> R accept(ArgRetVisitor<A,R> v, A arg);
  public abstract <R> R accept(RetVisitor<R> v);

  public abstract String toString();
}
