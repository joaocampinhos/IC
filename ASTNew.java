public class ASTNew implements ASTNode {
  ASTNode t;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue tmp = t.eval(e);
    return new RefValue(tmp);
  }

  public ASTNew(ASTNode n) {
    t = n;
  }

  public IType typeCheck(TypeEnv e) {
    return null;
  }

  public void compile(CodeBlock c) {
  }
}
