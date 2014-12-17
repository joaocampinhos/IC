import java.util.*;

public class RecValue implements IValue {

  Vector<Binding> ve;
  Env e;

  RecValue(Vector<Binding> ve, Env e) {
    this.ve = ve;
    this.e = e;
  }

  public VType typeOf() {
    return VType.REC;
  }

  public ASTNode getParameter(String id) throws UndefinedField{

    Iterator<Binding> it = ve.iterator();
    while(it.hasNext()) {
      Binding a = it.next();
      String name = a.getId();

      if (id.equals(name)) {
        return a.getExp();
      }
    }
    throw new UndefinedField();
  }

  public Env getEnv() {
    return e;
  }

}
