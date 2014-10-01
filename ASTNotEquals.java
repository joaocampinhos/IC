public class ASTNotEquals implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (boolean)(left.eval() != right.eval());
  }

  public ASTNotEquals(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
