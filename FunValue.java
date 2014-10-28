public class FunValue implements IValue {

  Vector<String> vs;
  

  IdValue(String v) {
    val = v;
  }

  public VType typeOf() {
    return VType.FUN;
  }

  public String toString() {
    return val;
  }

}
