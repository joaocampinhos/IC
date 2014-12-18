public class ASTPrintln implements ASTNode {
  ASTNode left;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    IValue v1 = left.eval(e);
    System.out.println(v1);
    return v1;
  }

  public ASTPrintln(ASTNode l) {
    left = l;
  }

  public IType typeCheck(TypeEnv e) {
    return null;
  }

  public void compile(CodeBlock c) {
  }
}
