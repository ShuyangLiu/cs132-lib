package cs132.IR.sparrowv.visitor;

import cs132.IR.token.*;
import cs132.IR.value.*;
import cs132.IR.sparrowv.Block;
import java.util.Map;

public class LocalState {
  public Block block;
  public Map<String,Value> env;
  public int pc;
 
  public LocalState(Block block, Map<String,Value> env, int pc) {
    this.block = block;
    this.env = env;
    this.pc = pc;
  }
}
