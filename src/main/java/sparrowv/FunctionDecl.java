package sparrowv;

import IR.token.FunctionName;
import IR.token.Identifier;
import sparrowv.visitor.ArgRetVisitor;
import sparrowv.visitor.ArgVisitor;
import sparrowv.visitor.RetVisitor;
import sparrowv.visitor.Visitor;

import java.util.List;

public class FunctionDecl {
  public Program parent;

  public FunctionName functionName;
  public List<Identifier> formalParameters;
  public Block block;

  public  FunctionDecl() { }
  public FunctionDecl(FunctionName functionName,
                      List<Identifier> formalParameters,
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

  public <A,R> R accept(ArgRetVisitor<A,R> v, A arg) {
    return v.visit(this, arg);
  }

  public <R> R accept(RetVisitor<R> v){
    return v.visit(this);
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
}
