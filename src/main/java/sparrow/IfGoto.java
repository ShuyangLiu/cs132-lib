package sparrow;

import IR.token.Identifier;
import IR.token.Label;
import sparrow.visitor.ArgRetVisitor;
import sparrow.visitor.ArgVisitor;
import sparrow.visitor.RetVisitor;
import sparrow.visitor.Visitor;

public class IfGoto extends Instruction {
  public Identifier condition;
  public Label label;

  public IfGoto(Identifier condition, Label label) {
    this.condition = condition;
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
    return "if0 " + condition + " goto " + label;
  }
}
