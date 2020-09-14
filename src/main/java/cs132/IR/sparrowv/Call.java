package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;
import java.util.ArrayList;

public class Call extends Instruction {
  public Register lhs;
  public Register callee;
  public ArrayList<Identifier> args;

  public Call(Register lhs, Register callee, ArrayList<Identifier> args) {
    this.lhs = lhs ;
    this.callee = callee;
    this.args = args;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    String res = lhs + " = call " + callee + "(";
    String s = "";
    for (Identifier param: args) {
      s = s + param + " ";
    }
    if (!(s.equals(""))) {
       res = res + s.subSequence(0,s.length()-1);
    }
    res = res + ")";
    return res;
  }
}