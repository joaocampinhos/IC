public class ASTGthen implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError {
    IValue v1 = left.eval(e);
    IValue v2 = right.eval(e);

    if (v1.typeOf() == IValue.VType.INTEGER && v2.typeOf() == IValue.VType.INTEGER) {
      IntValue vl = (IntValue)v1;
      IntValue vr = (IntValue)v2;
      return new BoolValue(vl.getVal() > vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTGthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    c.incCounter();
    final String temp = c.getCounter();
    left.compile(c);
    right.compile(c);
    c.add("if_icmpgt Maior"+temp);
    c.add("sipush 0");
    c.add("goto Nmaior"+temp);

    c.add("Maior"+temp+":");
    c.add("sipush 1");

    c.add("Nmaior"+temp+":");
  }
}
