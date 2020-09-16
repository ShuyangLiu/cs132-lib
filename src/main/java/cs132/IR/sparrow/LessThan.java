package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

public class LessThan extends Instruction {
  public Identifier lhs;
  public Identifier arg1;
  public Identifier arg2;

  public LessThan(Identifier lhs, Identifier arg1, Identifier arg2) {
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

  public <A,R> R accept(ArgRetVisitor<A,R> v, A arg) {
    return v.visit(this, arg);
  }

  public <R> R accept(RetVisitor<R> v){
    return v.visit(this);
  }

  public String toString() {
    return lhs + " = " + arg1 + " < " + arg2;
  }

}
