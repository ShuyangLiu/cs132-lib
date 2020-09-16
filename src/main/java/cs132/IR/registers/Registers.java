package cs132.IR.registers;

import java.util.Set;

public class Registers {
  public static final Set<String> riscVregs =
          new java.util.HashSet<>();

  public static void SetRiscVregs() {
                                              riscVregs.add("a2");
    riscVregs.add("a3"); riscVregs.add("a4"); riscVregs.add("a5");
    riscVregs.add("a6"); riscVregs.add("a7");

                         riscVregs.add("s1"); riscVregs.add("s2");
    riscVregs.add("s3"); riscVregs.add("s4"); riscVregs.add("s5");
    riscVregs.add("s6"); riscVregs.add("s7"); riscVregs.add("s8");
    riscVregs.add("s9"); riscVregs.add("s10"); riscVregs.add("s11");

    riscVregs.add("t0"); riscVregs.add("t1"); riscVregs.add("t2");
    riscVregs.add("t3"); riscVregs.add("t4"); riscVregs.add("t5");
  }
}
