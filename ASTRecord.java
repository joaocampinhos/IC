import java.util.*;

public class ASTRecord implements ASTNode {
  Vector<Binding> ve;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    Env eaux = e.beginScope();

    Iterator<Binding> it = ve.iterator();
    while(it.hasNext()) {
      Binding a = it.next();
      eaux.assoc(a.getId(), a.getExp().eval(e));
    }

    RecValue r = new RecValue(eaux);
    eaux.endScope();
    return r;
  }

  public ASTRecord(Vector<Binding> ve) {
    this.ve = ve;
  }

  public IType typeCheck(TypeEnv e) throws TypeError {

    TypeEnv eaux = e.beginScope();

    Iterator<Binding> it = ve.iterator();
    while(it.hasNext()) {
      Binding a = it.next();
      eaux.assoc(a.getId(), a.getExp().typeCheck(e));
    }

    RecType r = new RecType(eaux);
    eaux.endScope();
    return r;
  }

  public void compile(CodeBlock c) {
  }
}
