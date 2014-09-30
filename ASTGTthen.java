public class ASTGTthen implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() > right.eval();
  }

  public ASTGTthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
