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

  }
}
