public class RefType implements IType{

  public TType typeOf() {
    return TType.REFERENCE;
  }

  public String toString() {
    return "ref";
  }
}