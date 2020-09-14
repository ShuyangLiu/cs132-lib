package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

public class Move_Id_Id extends Instruction {
  public Identifier lhs;
  public Identifier rhs;

  public Move_Id_Id(Identifier lhs, Identifier rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    return lhs + " = " + rhs;
  }
}