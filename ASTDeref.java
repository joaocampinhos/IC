
public class ASTDeref implements ASTNode {
  ASTNode t;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue i = t.eval(e);

    if (i.typeOf() == IValue.VType.REFERENCE) {
      RefValue v = (RefValue)i;
      return v.getVal();
    }
    else throw new TypeError();
  }

  public ASTDeref(ASTNode n) {
    t = n;
  }

  public void compile(CodeBlock c) {
  }
}
