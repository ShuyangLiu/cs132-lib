package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class Move_Reg_Id extends Instruction {
  public Register lhs;
  public Identifier rhs;

  public Move_Reg_Id(Register lhs, Identifier rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  public Move_Reg_Id() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
    
  public <A> void accept(ArgVisitor<A> v, A arg) { v.visit(this, arg); }

  public String toString() {
    return lhs + " = " + rhs;
  }
}
