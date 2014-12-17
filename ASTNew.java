public class ASTNew implements ASTNode {
  ASTNode t;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField{
    IValue tmp = t.eval(e);
    return new RefValue(tmp);
  }

  public ASTNew(ASTNode n) {
    t = n;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{

    IType n = t.typeCheck(e);

    RefType res = new RefType(n);

    return res;
  }

  public void compile(CodeBlock c) {
  }
}
