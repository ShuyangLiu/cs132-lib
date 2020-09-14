package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

public class Load extends Instruction {
  public Identifier lhs;
  public Identifier base;
  public int offset;

  public Load(Identifier lhs, Identifier base, int offset) {
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
