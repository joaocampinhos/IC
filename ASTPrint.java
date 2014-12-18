public class ASTPrint implements ASTNode {
  ASTNode left;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{
    IValue v1 = left.eval(e);
    System.out.print(v1);
    return v1;
  }

  public ASTPrint(ASTNode l) {
    left = l;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{

    left.typeCheck(e);

    return new CmdType();
  }

  public void compile(CodeBlock c) {
  }
}
