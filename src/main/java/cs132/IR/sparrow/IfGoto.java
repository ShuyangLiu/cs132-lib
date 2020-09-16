package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

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
