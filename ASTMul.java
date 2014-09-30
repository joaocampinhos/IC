public class ASTMul implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() * right.eval();
  }

  public ASTMul(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
