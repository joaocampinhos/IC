public class ASTPlus implements ASTNode {
  ASTNode left, right;

  public int eval() {
    return left.eval() + right.eval();
  }

  public ASTPlus(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
