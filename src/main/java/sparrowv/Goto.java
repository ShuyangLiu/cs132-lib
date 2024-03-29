package sparrowv;

import IR.token.Label;
import sparrowv.visitor.ArgRetVisitor;
import sparrowv.visitor.ArgVisitor;
import sparrowv.visitor.RetVisitor;
import sparrowv.visitor.Visitor;

public class Goto extends Instruction {
  public Label label;

  public Goto(Label label) {
    this.label = label;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public <A,R> R accept(ArgRetVisitor<A,R> v, A arg) {
    return v.visit(this, arg);
  }

  public <R> R accept(RetVisitor<R> v){
    return v.visit(this);
  }

  public String toString() {
    return "goto " + label;
  }
}
