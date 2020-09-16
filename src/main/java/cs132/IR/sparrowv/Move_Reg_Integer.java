package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public class Move_Reg_Integer extends Instruction {
  public Register lhs;
  public int rhs;
  
  public Move_Reg_Integer(Register lhs, int rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }
  
  public <A> void accept(ArgVisitor<A> v, A arg) { v.visit(this, arg); }


  public <A,R> R accept(ArgRetVisitor<A,R> v, A arg) {
    return v.visit(this, arg);
  }

  public <R> R accept(RetVisitor<R> v){
    return v.visit(this);
  }
  
  public String toString() {
    return lhs + " = " + rhs;
  }

}
