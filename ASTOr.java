public class ASTOr implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError , Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue v1 = left.eval(e);
    IValue v2 = right.eval(e);

    if (v1.typeOf() == IValue.VType.BOOLEAN && v2.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue vl = (BoolValue)v1;
      BoolValue vr = (BoolValue)v2;
      return new BoolValue(vl.getVal() || vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTOr(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public IType typeCheck(TypeEnv e) {
    return null;
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("ior");
  }
}
