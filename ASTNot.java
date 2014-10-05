public class ASTNot implements ASTNode {
  ASTNode t;

  public IValue eval() throws TypeError {
    IValue i = t.eval();

    if (i.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue v = (BoolValue)i;
      return new BoolValue(!v.getVal());
    }
    else throw new TypeError();
  }

  public ASTNot(ASTNode n) {
    t = n;
  }

  public void compile(CodeBlock c) {
    t.compile(c);
    c.add("ifeq Zero");
    c.add("sipush 0");
    c.add("goto Nzero");

    c.add("Zero:");
    c.add("sipush 1");

    c.add("Nzero:");
  }
}
