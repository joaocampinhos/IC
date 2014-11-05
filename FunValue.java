import java.util.*;

public class FunValue implements IValue {

  Vector<String> vs;
  ASTNode body;


  FunValue(Vector<String> vec, ASTNode b) {
    vs = vec;
    body = b;
  }

  public VType typeOf() {
    return VType.FUN;
  }

  public String toString() {
    return body.toString();
  }

  public Vector<String> getParameter(){
    return vs;
  };

  public ASTNode getBody(){
    return body;
  };


}
