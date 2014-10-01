public class ASTEquals implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (boolean)(left.eval() == right.eval());
  }

  public ASTEquals(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
