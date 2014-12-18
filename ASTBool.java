public class ASTBool implements ASTNode {
  boolean val;

  public IValue eval(Env e) {
    return new BoolValue(val);
  }

  public ASTBool(String n) {
    val = Boolean.parseBoolean(n);
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
    return new BoolType();
  }

  public void compile(CodeBlock c) {
    int v = val ? 1 : 0;
    c.add("sipush "+v);
  }
}
