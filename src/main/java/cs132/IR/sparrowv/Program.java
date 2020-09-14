package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;
import java.util.ArrayList;

public class Program {
  public ArrayList<FunctionDecl> funDecls;

  public Program(ArrayList<FunctionDecl> funDecls) {
    this.funDecls = funDecls;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    String res = "";
    for (FunctionDecl fd: funDecls) {
      res = res + fd.toString();
    }
    return res;
  }
}
