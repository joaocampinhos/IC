import java.util.*;

public class ASTDecl implements ASTNode {
  ASTNode t;
  IValue v;
  Vector<Binding> ve;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    Iterator<Binding> it = ve.iterator();
    Env en = e.beginScope();
    while (it.hasNext()) {
      Binding a = it.next();
      e.assoc(a.getId(), a.getExp().eval(e));
    }
    v = t.eval(en);
    en.endScope();
    return v;
  }

  public ASTDecl(Vector<Binding> ve, ASTNode t) {
    this.ve = ve;
    this.t  = t;
  }

  public IType typeCheck(TypeEnv e) {
    return null;
  }

  public void compile(CodeBlock c) {
  }
}
