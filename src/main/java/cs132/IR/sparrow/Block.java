package cs132.IR.sparrow;

import cs132.IR.token.*;
import cs132.IR.sparrow.visitor.*;
import java.util.ArrayList;

public class Block {
  public FunctionDecl parent;

  public ArrayList<Instruction> instructions;
  public Identifier return_id;

  public Block(ArrayList<Instruction> instructions, Identifier return_id) {
    this.instructions = instructions;
    this.return_id = return_id;
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) {
    v.visit(this, arg);
  }

  public String toString() {
    String res = "";
    for (Instruction li: instructions) {
      res = res + li.toString() + "\n";
    }
    res = res + "      return " + return_id;
    return res;
  }
}
