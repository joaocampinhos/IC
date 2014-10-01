public class ASTDiv implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (int)left.eval() / (int)right.eval();
  }

  public ASTDiv(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
