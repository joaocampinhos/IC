public class ASTLSthen implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() < right.eval();
  }

  public ASTLSthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
