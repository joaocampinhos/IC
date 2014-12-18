import java.util.*;

public class ASTRecord implements ASTNode {
  Vector<Binding> ve;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    RecValue r = new RecValue(ve,e);
    return r;
  }

  public ASTRecord(Vector<Binding> ve) {
    this.ve = ve;
  }

  public IType typeCheck(TypeEnv e) throws TypeError {
    return new CmdType();
  }

  public void compile(CodeBlock c) {
  }
}
