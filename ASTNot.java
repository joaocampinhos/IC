public class ASTNot implements ASTNode {
  ASTNode t;

  public Object eval() {
    return !(boolean)t.eval();
  }

  public ASTNot(ASTNode n) {
    t = n;
  }
}
