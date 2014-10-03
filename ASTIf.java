public class ASTIf implements ASTNode {
  ASTNode exp, expif, expelse;

  public Object eval() {
    return (boolean)exp.eval() ? expif.eval() : expelse.eval();
  }

  public ASTIf(ASTNode a, ASTNode b, ASTNode c) {
    exp = a;
    expif = b;
    expelse = c;
  }
}
