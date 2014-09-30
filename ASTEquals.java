public class ASTEquals implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() == right.eval();
  }

  public ASTEquals(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
