public class ASTNot implements ASTNode {
  ASTNode t;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField{
    IValue i = t.eval(e);

    if (i.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue v = (BoolValue)i;
      return new BoolValue(!v.getVal());
    }
    else throw new TypeError();
  }

  public ASTNot(ASTNode n) {
    t = n;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    IType tt = t.typeCheck(e);

    if (tt.typeOf() == IType.TType.BOOLEAN)
      return new BoolType();
    else throw new TypeError();
  }

  public void compile(CodeBlock c) {
    c.incCounter();
    final String temp = c.getCounter();
    t.compile(c);
    c.add("ifeq Zero"+temp);
    c.add("sipush 0");
    c.add("goto Nzero"+temp);

    c.add("Zero"+temp+":");
    c.add("sipush 1");

    c.add("Nzero"+temp+":");
  }
}
