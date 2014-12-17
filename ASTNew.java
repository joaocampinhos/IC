public class ASTNew implements ASTNode {
  ASTNode t;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField{
    IValue tmp = t.eval(e);
    return new RefValue(tmp);
  }

  public ASTNew(ASTNode n) {
    t = n;
  }

  public void compile(CodeBlock c) {
  }
}
