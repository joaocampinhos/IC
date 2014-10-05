public class ASTAnd implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (boolean)left.eval() && (boolean)right.eval();
  }

  public ASTAnd(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("iand");
  }
}
