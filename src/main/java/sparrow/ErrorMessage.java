package sparrow;

import sparrow.visitor.ArgRetVisitor;
import sparrow.visitor.ArgVisitor;
import sparrow.visitor.RetVisitor;
import sparrow.visitor.Visitor;

public class ErrorMessage extends Instruction {
  public String msg;

  public ErrorMessage(String msg) {
    this.msg = msg;
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
    return "error(\"" + msg + "\")";
  }
}
