import java.util.*;

public class ASTGetRec implements ASTNode {
  ASTNode t;
  ASTNode id;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier{

    IValue r = t.eval(e);

    if (r.typeOf() == IValue.VType.REC) {

      RecValue rec = (RecValue)r;

      Env ee = rec.getEnv();
      IValue idv = id.eval(ee);

      return idv;

    } else throw new TypeError();

  }

  public ASTGetRec(ASTNode id, ASTNode t) {
    this.t = t;
    this.id = id;
  }

  public IType typeCheck(TypeEnv e) throws TypeError {
    return new CmdType();
  }

  public void compile(CodeBlock c) {
  }
}
