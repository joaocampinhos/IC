import java.util.*;

public class ASTFun implements ASTNode {
  ASTNode t;
  IValue v;
  Vector<String> vs;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier {
    Iterator<String> it = vs.iterator();

    return v;
  }

  public ASTDecl(Vector<String> vs, ASTNode t) {
    this.vs = vs;
    this.t  = t;
  }

  public void compile(CodeBlock c) {
  }
}