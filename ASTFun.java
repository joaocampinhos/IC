import java.util.*;

public class ASTFun implements ASTNode {
  Vector<String> vs;
  ASTNode body;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    FunValue f = new FunValue(vs, body);  
    return f;
  }

  public ASTFun(Vector<String> vec, ASTNode b) {
    vs = vec;
    body  = b;
  }

  public void compile(CodeBlock c) {
  }
}
