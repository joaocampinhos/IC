public class ASTAnd implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    IValue v1 = left.eval(e);
    IValue v2 = right.eval(e);

    if (v1.typeOf() == IValue.VType.BOOLEAN && v2.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue vl = (BoolValue)v1;
      BoolValue vr = (BoolValue)v2;
      return new BoolValue(vl.getVal() && vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTAnd(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    IType l = left.typeCheck(e);
    IType r = right.typeCheck(e);

    if (l.typeOf() == IType.TType.BOOLEAN && r.typeOf() == IType.TType.BOOLEAN)
      return new BoolType();
    else throw new TypeError();
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("iand");
  }
}
