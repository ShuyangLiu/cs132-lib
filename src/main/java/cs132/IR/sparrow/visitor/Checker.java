package cs132.IR.sparrow.visitor;

import cs132.IR.token.*;
import cs132.IR.errors.*;
import cs132.IR.sparrow.*;
import cs132.IR.registers.Registers;
import java.util.List;
import java.util.ArrayList;

public class Checker extends DoNothing {

  ErrorReport report;

  public Checker(ErrorReport report) {
    this.report = report;
  }

  /*   ArrayList<FunctionDecl> funDecls; */
  public void visit(Program n) {
    report.checkProgramIsNonempty(n.funDecls.size());
    if (n.funDecls.size() > 0) {
       report.checkFirstFunctionHasZeroParameters(n.funDecls.get(0).formalParameters);

       List<String> fnames = new ArrayList<String>();
       for (FunctionDecl fd: n.funDecls) {
         fnames.add(fd.functionName.toString());
       }
       report.checkForDuplicates("The program", "function", fnames);

       for (FunctionDecl fd: n.funDecls) {
         fd.accept(this);
       }
    }
  }

  /*   Program parent;
   *   FunctionName functionName;
   *   ArrayList<Identifier> formalParameters;
   *   Block block; */
  public void visit(FunctionDecl n) {
    List<String> fps = new ArrayList<String>();
    for (Identifier i: n.formalParameters) {
      fps.add(i.toString());
    }
    report.checkForDuplicates("The function " + n.functionName,"parameter",fps);

    for (Identifier fp: n.formalParameters) {
        report.checkIdentifier("Formal parameter " + fp, fp);
    }
    n.block.accept(this);
  }

  /*   FunctionDecl parent;
   *   ArrayList<Instruction> instructions;
   *   Identifier return_id; */
  public void visit(Block n) {
    List<String> labels = new ArrayList<String>();
    for (Instruction i: n.instructions) {
        if (i instanceof LabelInstr) {
           labels.add(((LabelInstr) i).label.toString());
        }
    }
    report.checkForDuplicates("A block", "label", labels);
    for (Instruction i: n.instructions) {
      i.accept(this);
    }
    report.checkIdentifier("return " + n.return_id, n.return_id);
  }

  /*   Label label; */
  public void visit(LabelInstr n) {
    // nothing to check
  }

  /*   Identifier lhs;
   *   int rhs; */
  public void visit(Move_Id_Integer n) {
    report.checkIdentifier(n.toString(),n.lhs);
  }
  
  /*   Identifier lhs;
   *   FunctionName rhs; */
  public void visit(Move_Id_FuncName n) {
    report.checkIdentifier(n.toString(),n.lhs);

    GetFunctionDecl gfd = new GetFunctionDecl(n.rhs);
    n.parent.parent.parent.accept(gfd); // find n.rhs in the program
    FunctionDecl fd = gfd.result;
    report.checkFunctionName(!(fd == null),n.toString(),n.rhs);
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(Add n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.arg1);
    report.checkIdentifier(n.toString(),n.arg2);
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(Subtract n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.arg1);
    report.checkIdentifier(n.toString(),n.arg2);
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(Multiply n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.arg1);
    report.checkIdentifier(n.toString(),n.arg2);
  }

  /*   Identifier lhs;
   *   Identifier arg1;
   *   Identifier arg2; */
  public void visit(LessThan n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.arg1);
    report.checkIdentifier(n.toString(),n.arg2);
  }

  /*   Identifier lhs;
   *   Identifier base;
   *   int offset; */
  public void visit(Load n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.base);
    report.checkOffset(n.toString(),n.offset);
  }

  /*   Identifier base;
   *   int offset;
   *   Identifier rhs; */
  public void visit(Store n) {
    report.checkIdentifier(n.toString(),n.base);
    report.checkOffset(n.toString(),n.offset);
    report.checkIdentifier(n.toString(),n.rhs);
  }

  /*   Identifier lhs;
   *   Identifier rhs; */
  public void visit(Move_Id_Id n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.rhs);
  }

  /*   Identifier lhs;
   *   Identifier size; */
  public void visit(Alloc n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.size);
  }

  /*   Identifier content; */
  public void visit(Print n) {
    report.checkIdentifier(n.toString(),n.content);
  }

  /*   String msg; */
  public void visit(ErrorMessage n) {
    // nothing to check
  }

  /*   Label label; */
  public void visit(Goto n) {
    Find f = new Find(n.label);
    n.parent.accept(f); // find the declaration of label in its block
    int pc = f.result;
    report.checkLabel((pc >= 0),n.toString(),n.label);
  }

  /*   Identifier condition;
   *   Label label; */
  public void visit(IfGoto n) {
    report.checkIdentifier(n.toString(),n.condition);
    Find f = new Find(n.label);
    n.parent.accept(f); // find the declaration of label in its block
    int pc = f.result;
    report.checkLabel((pc >= 0),n.toString(),n.label);
  }

  /*   Identifier lhs;
   *   Identifier callee;
   *   ArrayList<Identifier> args; */
  public void visit(Call n) {
    report.checkIdentifier(n.toString(),n.lhs);
    report.checkIdentifier(n.toString(),n.callee);
    for (Identifier s: n.args) {
      report.checkIdentifier(n.toString(),s);
    }
  }
}
