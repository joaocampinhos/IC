public class ASTGEthen implements ASTNode {
  ASTNode left, right;

  public IValue eval() throws TypeError {
    IValue v1 = left.eval();
    IValue v2 = right.eval();

    if (v1.typeOf() == IValue.VType.INTEGER && v2.typeOf() == IValue.VType.INTEGER) {
      IntValue vl = (IntValue)v1;
      IntValue vr = (IntValue)v2;
      return new BoolValue(vl.getVal() >= vr.getVal());
    }
    else throw new TypeError();
  }

  public ASTGEthen(ASTNode l, ASTNode r) {
    left = l;
    right = r;
  }
}
