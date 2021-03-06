public class ASTWhile implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue v1 = left.eval(e);
    IValue v2 = right.eval(e);

    if (v1.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue vl = (BoolValue)v1;
      while (vl.getVal()) {
        v2 = right.eval(e);
        v1 = left.eval(e);
        vl = (BoolValue)v1;
      }
      return v2;
    }
    else throw new TypeError();
  }

  public ASTWhile(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    IType l = left.typeCheck(e);

    if (l.typeOf() == IType.TType.BOOLEAN) {
      right.typeCheck(e);
      return new CmdType();
    } else throw new TypeError();
  }

  public void compile(CodeBlock c) {
  }
}
