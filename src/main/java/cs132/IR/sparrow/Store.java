package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;

public class Store extends Instruction {
  public Identifier base;
  public int offset;
  public Identifier rhs;

  public Store(Identifier base, int offset, Identifier rhs) {
    this.base = base;
    this.offset = offset;
    this.rhs = rhs;
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
    return "[" + base + " + " + offset + "] = " + rhs;
  }
}
