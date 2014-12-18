public class ASTNeg implements ASTNode {
  int val;

  public IValue eval(Env e) {
    return new IntValue(-val);
  }

  public ASTNeg(int n) {
    val = n;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
      return new IntType();
  }

  public void compile(CodeBlock c) {
    c.add("sipush "+(-val));
  }
}
