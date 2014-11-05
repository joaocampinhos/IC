import java.util.*;

public class ASTCall implements ASTNode {
  Vector<ASTId> vs;
  ASTNode body;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    e.beginScope();
    //TODO: fazer isto!
    return null;
  }

  public ASTCall(Vector<ASTId> vec, ASTNode b) {
    vs = vec;
    body  = b;
  }

  public void compile(CodeBlock c) {
  }
}
