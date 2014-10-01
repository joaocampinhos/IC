public class ASTNum implements ASTNode {
  int val;

  public Object eval() {
    return (int)val;
  }

  public ASTNum(int n) {
    val = n;
  }
}
