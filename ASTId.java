public class ASTId implements ASTNode {
  String val;

  public IValue eval(Env e) throws Env.UndeclaredIdentifier {
    return e.find(val);
  }

  public ASTId(String n) {
    val = n;
  }

  public void compile(CodeBlock c) {
  }
}
