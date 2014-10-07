public class IdValue implements IValue {

  String val;

  IdValue(String v) {
    val = v;
  }

  public VType typeOf() {
    return VType.ID;
  }

  public String toString() {
    return val;
  }

}
