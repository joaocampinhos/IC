public class ASTSub implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() - right.eval();
  }

  public ASTSub(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
