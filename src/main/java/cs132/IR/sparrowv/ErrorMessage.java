package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class ErrorMessage extends Instruction {
  public String msg;

  public ErrorMessage(String msg) {
    this.msg = msg;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    return "error(" + msg + ")";
  }
}
