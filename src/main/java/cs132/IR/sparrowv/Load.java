package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class Load extends Instruction {
  public Register lhs;
  public Register base;
  public int offset;

  public Load(Register lhs, Register base, int offset) {
    this.lhs = lhs;
    this.base = base;
    this.offset = offset;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    return lhs + " = [" + base + " + " + offset + "]";
  }
}
