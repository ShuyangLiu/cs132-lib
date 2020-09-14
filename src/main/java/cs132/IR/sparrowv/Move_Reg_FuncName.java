package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class Move_Reg_FuncName extends Instruction {
  public Register lhs;
  public FunctionName rhs;
  
  public Move_Reg_FuncName(Register lhs, FunctionName rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) { v.visit(this, arg); }

  public String toString() {
    return lhs + " = @" + rhs;
  }
}
