public class ASTNeg implements ASTNode {
  int val;

  public Object eval() {
    return (int)-val;
  }

  public ASTNeg(int n) {
    val = n;
  }
}
