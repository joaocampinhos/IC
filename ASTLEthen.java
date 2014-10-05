public class ASTLEthen implements ASTNode {
  ASTNode left, right;

  public IValue eval() throws TypeError {
    IValue v1 = left.eval();
    IValue v2 = right.eval();

    if (v1.typeOf() == IValue.VType.INTEGER && v2.typeOf() == IValue.VType.INTEGER) {
      IntValue vl = (IntValue)v1;
      IntValue vr = (IntValue)v2;
      return new BoolValue(vl.getVal() <= vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTLEthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("if_icmple Igual");
    c.add("sipush 0");
    c.add("goto Dif");

    c.add("Igual:");
    c.add("sipush 1");

    c.add("Dif:");

  }
}
