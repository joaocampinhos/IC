public class ASTIf implements ASTNode {
  ASTNode exp, expif, expelse;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField {
    IValue e1 = exp.eval(e);
    IValue e2 = expif.eval(e);
    IValue e3 = expelse.eval(e);

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

  public IType typeCheck(TypeEnv e) throws TypeError{
    IType e1 = exp.typeCheck(e);
    IType e2 = expif.typeCheck(e);
    IType e3 = expelse.typeCheck(e);

    if (e1.typeOf() == IType.TType.BOOLEAN) {
      return new CmdType();
    } else throw new TypeError();
  }

  public void compile(CodeBlock c) {
    c.incCounter();
    final String temp = c.getCounter();
    exp.compile(c);
    c.add("ifne Entra"+temp);
    expelse.compile(c);
    c.add("goto Saio"+temp);

    c.add("Entra"+temp+":");
    expif.compile(c);

    c.add("Saio"+temp+":");
  }
}
