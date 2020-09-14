package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class Alloc extends Instruction {
  public Register lhs;
  public Register size;

  public Alloc(Register lhs, Register size) {
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
