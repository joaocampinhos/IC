public class ASTBool implements ASTNode {
  boolean val;

  public Object eval() {
    return (boolean)val;
  }

  public ASTBool(String n) {
    val = Boolean.parseBoolean(n);
  }

  public void compile(CodeBlock c) {
    int v = val ? 1 : 0;
    c.add("sipush "+v);
  }
}
