public class FunValue implements IValue {

  Vector<ASTId> vs;
  ASTNode body;
  

  FunValue(Vector<ASTId> vec, ASTNode b) {
    vs = vec;
    body = b;
  }

  public VType typeOf() {
    return VType.FUN;
  }

  public String toString() {
    return body.toString();
  }

  public Vector<ASTId> getParameter(){
    return vs;
  };

  public ASTNode getBody(){
    return body;
  };


}
