package sparrowv;

import IR.token.Identifier;
import IR.token.Register;
import sparrowv.visitor.ArgRetVisitor;
import sparrowv.visitor.ArgVisitor;
import sparrowv.visitor.RetVisitor;
import sparrowv.visitor.Visitor;

public class Move_Id_Reg extends Instruction {
  public Identifier lhs;
  public Register rhs;

  public Move_Id_Reg(Identifier lhs, Register rhs) {
    this.lhs = lhs;
    this.rhs = rhs;
  }

  public Move_Id_Reg() {
  }

  public void accept(Visitor v) {
    v.visit(this);
  }

  public <A,R> R accept(ArgRetVisitor<A,R> v, A arg) {
    return v.visit(this, arg);
  }

  public <R> R accept(RetVisitor<R> v){
    return v.visit(this);
  }

  public <A> void accept(ArgVisitor<A> v, A arg) { v.visit(this, arg); }

  public String toString() {
    return lhs + " = " + rhs;
  }
}
