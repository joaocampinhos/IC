public class ASTDiv implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() / right.eval();
  }

  public ASTDiv(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
