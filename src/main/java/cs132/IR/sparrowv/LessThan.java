package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class LessThan extends Instruction {
  public Register lhs;
  public Register arg1;
  public Register arg2;

  public LessThan(Register lhs, Register arg1, Register arg2) {
    this.lhs = lhs;
    this.arg1 = arg1;
    this.arg2 = arg2;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    return lhs + " = " + arg1 + " < " + arg2;
  }

}
