public class ASTMul implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (int)left.eval() * (int)right.eval();
  }

  public ASTMul(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("imul");
  }
}
