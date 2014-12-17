import java.util.*;

public class ASTGetRec implements ASTNode {
  ASTNode t;
  String id;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField{

    IValue r = t.eval(e);

    if (r.typeOf() == IValue.VType.REC) {

      RecValue rec = (RecValue)r;

      Env ee = rec.getEnv();

      ASTNode el = rec.getParameter(id);

      IValue res = el.eval(ee);

      return res;

    } else throw new TypeError();

  }

  public ASTGetRec(String id, ASTNode t) {
    this.t = t;
    this.id = id;
  }

  public void compile(CodeBlock c) {
  }
}
