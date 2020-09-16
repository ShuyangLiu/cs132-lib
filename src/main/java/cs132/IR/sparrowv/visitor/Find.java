package cs132.IR.sparrowv.visitor;

import cs132.IR.token.*;
import cs132.IR.sparrowv.*;

public class Find extends DoNothing {

  public Label target;
  public int result = -1;

  public Find(Label target) {
    this.target = target;
  }

  /*   FunctionDecl parent;
   *   List<Instruction> instructions;
   *   Identifier return_id; */
  public void visit(Block n) {
    int i=0;
    while ((i<n.instructions.size()) && (result==-1)) {
        Instruction li = n.instructions.get(i);
        if ((li instanceof LabelInstr) && 
            (((LabelInstr) li).label.toString().equals(target.toString()))) {
           result = i;
        }
        i=i+1;
    }
  }
}
