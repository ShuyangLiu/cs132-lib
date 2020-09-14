package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

public class Print extends Instruction {
  public Identifier content;

  public Print(Identifier content) {
    this.content = content;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    return "print(" + content + ")";
  }
}
