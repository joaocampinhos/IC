public class ASTIf implements ASTNode {
  ASTNode exp, expif, expelse;

  public IValue eval() throws TypeError {
    IValue e1 = exp.eval();
    IValue e2 = expif.eval();
    IValue e3 = expelse.eval();

    if (e1.typeOf() == IValue.VType.BOOLEAN) {
      BoolValue vl = (BoolValue)e1;
      if (vl.getVal()) {
        if (e2.typeOf() == IValue.VType.BOOLEAN) {
          BoolValue v2 = (BoolValue)e2;
          return new BoolValue(v2.getVal());
        }
        else {
          IntValue v2 = (IntValue)e2;
          return new IntValue(v2.getVal());
        }
      }
      else {
        if (e3.typeOf() == IValue.VType.BOOLEAN) {
          BoolValue v3 = (BoolValue)e3;
          return new BoolValue(v3.getVal());
        }
        else {
          IntValue v3 = (IntValue)e3;
          return new IntValue(v3.getVal());
        }
      }
    }
    else throw new TypeError();
  }

  public ASTIf(ASTNode a, ASTNode b, ASTNode c) {
    exp = a;
    expif = b;
    expelse = c;
  }

  public void compile(CodeBlock c) {

  }
}
