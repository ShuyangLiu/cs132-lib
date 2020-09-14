package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

public abstract class Instruction {
  public Block parent;

  public void accept(Visitor v) { }
  public <A> void accept(ArgVisitor<A> v, A arg) { }
  public String toString() { return "Should never be returned"; }
}
