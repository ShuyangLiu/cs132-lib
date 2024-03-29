package sparrowv;

import sparrowv.visitor.ArgRetVisitor;
import sparrowv.visitor.ArgVisitor;
import sparrowv.visitor.RetVisitor;
import sparrowv.visitor.Visitor;

import java.util.List;

public class Program {
  public List<FunctionDecl> funDecls;

  public Program() { }

  public Program(List<FunctionDecl> funDecls) {
    this.funDecls = funDecls;
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
    for (FunctionDecl fd: funDecls) {
      res = res + fd.toString();
    }
    return res;
  }
}
