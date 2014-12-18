public class ASTNum implements ASTNode {
  int val;

  public IValue eval(Env e) {
    return new IntValue(val);
  }

  public ASTNum(int n) {
    val = n;
  }

  public IType typeCheck(TypeEnv e) {
    return new IntType();
  }

  public void compile(CodeBlock c) {
    c.add("sipush "+val);
  }
}
