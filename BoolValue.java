public class BoolValue implements IValue {

  boolean val;

  BoolValue(boolean v) {
    val = v;
  }

  public VType typeof() {
    return VType.BOOLEAN;
  }

  public boolean getVal() {
    return val;
  }

  public String toString() {
    return Boolean.toString(val);
  }

}
