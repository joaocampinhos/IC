public class ASTAssi implements ASTNode {
  ASTNode t, r;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue tmp1 = t.eval(e);
    IValue tmp2 = r.eval(e);
    if (tmp1.typeOf() == IValue.VType.REFERENCE) {
      RefValue a = (RefValue)tmp1;
      a.setVal(tmp2);
      return tmp2;
    }
    else throw new TypeError();
  }

  public ASTAssi(ASTNode t1, ASTNode t2) {
    t = t1;
    r = t2;
  }

  public void compile(CodeBlock c) {
  }
}
