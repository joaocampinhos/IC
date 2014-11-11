public class FunType implements IType{

  public TType typeOf() {
    return TType.FUN;
  }

  public String toString() {
    return "=>";
  }
}