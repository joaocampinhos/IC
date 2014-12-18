import java.util.*;

public class ASTFun implements ASTNode {
  Vector<String> vs;
  ASTNode body;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    FunValue f = new FunValue(vs, body, e);
    return f;
  }

  public ASTFun(Vector<String> vec, ASTNode b) {
    vs = vec;
    body  = b;
  }

  public IType typeCheck(TypeEnv e) throws TypeError{
      return new FunType();
  }

  public void compile(CodeBlock c) {
  }
}
