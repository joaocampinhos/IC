public class ASTBool implements ASTNode {
  boolean val;

  public Object eval() {
    return (boolean)val;
  }

  public ASTBool(String n) {
    val = Boolean.parseBoolean(n);
  }
}
