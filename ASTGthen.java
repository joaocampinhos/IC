public class ASTGthen implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (boolean)((int)left.eval() > (int)right.eval());
  }

  public ASTGthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
