package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

public class Alloc extends Instruction {
  public Identifier lhs;
  public Identifier size;

  public Alloc(Identifier lhs, Identifier size) {
    this.lhs = lhs;
    this.size = size;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    return lhs + " = alloc(" + size + ")";
  }
}
