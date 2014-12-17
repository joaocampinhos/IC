public class ASTMultiple implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField {

    IValue v1 = left.eval(e);

    //System.out.println(e.toString());

    e.beginScope();
    IValue v2 = right.eval(e);
    e.endScope();

    return v2;
  }

  public ASTMultiple(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
    left.compile(c);
    right.compile(c);
    c.add("iand");
  }
}
