public class ASTOr implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (boolean)left.eval() || (boolean)right.eval();
  }

  public ASTOr(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
