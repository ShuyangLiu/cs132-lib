package sparrow;

import IR.token.Identifier;
import sparrow.visitor.ArgRetVisitor;
import sparrow.visitor.ArgVisitor;
import sparrow.visitor.RetVisitor;
import sparrow.visitor.Visitor;

public class Print extends Instruction {
  public Identifier content;

  public Print(Identifier content) {
    this.content = content;
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
    return "print(" + content + ")";
  }
}
