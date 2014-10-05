public class ASTPlus implements ASTNode {
  ASTNode left, right;

  public Object eval() {
    return (int)left.eval() + (int)right.eval();
  }

  public ASTPlus(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public compile(Codeblock c) {
    left.compile(c);
    right.compile(c);
    c.add("iadd");
  }
}
