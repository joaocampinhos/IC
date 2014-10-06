public class ASTLthen implements ASTNode {
  ASTNode left, right;

  public IValue eval() throws TypeError {
    IValue v1 = left.eval();
    IValue v2 = right.eval();

    if (v1.typeOf() == IValue.VType.INTEGER && v2.typeOf() == IValue.VType.INTEGER) {
      IntValue vl = (IntValue)v1;
      IntValue vr = (IntValue)v2;
      return new BoolValue(vl.getVal() < vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTLthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    c.incCounter();
    final String temp = c.getCounter();
    left.compile(c);
    right.compile(c);
    c.add("if_icmplt Menor"+temp);
    c.add("sipush 0");
    c.add("goto Nmenor"+temp);

    c.add("Menor"+temp+":");
    c.add("sipush 1");

    c.add("Nmenor"+temp+":");
  }
}
