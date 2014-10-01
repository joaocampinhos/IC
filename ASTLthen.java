public class ASTLthen implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (boolean)((int)left.eval() < (int)right.eval());
  }

  public ASTLthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
