public class ASTId implements ASTNode {
  String val;

  public IValue eval() {
    return new IdValue(val);
  }

  public ASTId(String n) {
    val = n;
  }

  public void compile(CodeBlock c) {
  }
}
