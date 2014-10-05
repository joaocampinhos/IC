public class ASTNum implements ASTNode {
  int val;

  public Object eval() {
    return (int)val;
  }

  public ASTNum(int n) {
    val = n;
  }

  public void compile(CodeBlock c) {
    c.add("sipush "+val);
  }
}
