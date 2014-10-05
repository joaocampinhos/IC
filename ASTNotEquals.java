public class ASTNotEquals implements ASTNode {
  ASTNode left, right;

  public IValue eval() throws TypeError {
    IValue v1 = left.eval();
    IValue v2 = right.eval();

    if (v1.typeOf() == IValue.VType.BOOLEAN && v2.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue vl = (BoolValue)v1;
      BoolValue vr = (BoolValue)v2;
      return new BoolValue(vl.getVal() != vr.getVal());
    }
    else if (v1.typeOf() == IValue.VType.INTEGER && v2.typeOf() == IValue.VType.INTEGER) {
      IntValue vl = (IntValue)v1;
      IntValue vr = (IntValue)v2;
      return new BoolValue(vl.getVal() != vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTNotEquals(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("if_icmpne Nigual");
    c.add("sipush 0");
    c.add("goto Ndif");

    c.add("Nigual:");
    c.add("sipush 1");

    c.add("Ndif:");

  }
}
