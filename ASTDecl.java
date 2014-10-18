public class ASTDecl implements ASTNode {
  ASTNode left, right;

  public IValue eval(Env e) throws TypeError {
    IValue v1 = left.eval(e);
    IValue v2 = right.eval(e);

    if (v1.typeOf() == IValue.VType.BOOLEAN && v2.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue vl = (BoolValue)v1;
      BoolValue vr = (BoolValue)v2;
      return new BoolValue(vl.getVal() && vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTDecl(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }

  public void compile(CodeBlock c) {
  }
}
