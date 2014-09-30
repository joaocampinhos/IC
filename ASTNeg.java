public class ASTNeg implements ASTNode {
  ASTNode right;

  public int eval() {
    return -right.eval();
  }

  public ASTNeg(ASTNode r) {
    right = r;
  }
}
