package sparrow;

import IR.token.Identifier;
import sparrow.visitor.ArgRetVisitor;
import sparrow.visitor.ArgVisitor;
import sparrow.visitor.RetVisitor;
import sparrow.visitor.Visitor;

import java.util.List;

public class Block {
  public FunctionDecl parent;

  public List<Instruction> instructions;
  public Identifier return_id;

  public Block() { }

  public Block(List<Instruction> instructions, Identifier return_id) {
    this.instructions = instructions;
    this.return_id = return_id;
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
    String res = "";
    for (Instruction li: instructions) {
      res = res + li.toString() + "\n";
    }
    res = res + "      return " + return_id;
    return res;
  }
}
