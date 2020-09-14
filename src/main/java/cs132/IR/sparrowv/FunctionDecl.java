package cs132.IR.sparrowv;

import cs132.IR.token.*;
import cs132.IR.sparrowv.visitor.*;

import java.util.ArrayList;
import java.util.HashMap;

public class FunctionDecl {
  public Program parent;

  public FunctionName functionName;
  public ArrayList<Identifier> formalParameters;
  public Block block;

  public FunctionDecl(FunctionName functionName,
                      ArrayList<Identifier> formalParameters,
                      Block block) {
    this.functionName = functionName;
    this.formalParameters = formalParameters;
    this.block = block;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    String res = "func " + functionName + "(";

    String s = "";
    for (Identifier fp: formalParameters) {
      s = s + fp.toString() + " ";
    }
    if (!(s.equals(""))) {
       res = res + s.subSequence(0,s.length()-1);
    }
    res = res + ")\n" + block.toString() + "\n\n";
    return res;
  }

    public int index_arg (String name){
        for (int i = 0 ; i < formalParameters.size(); ++i){
            if (formalParameters.get(i).toString().equals(name)) {
                return i;
            }
        }
        return -1;
    }

}