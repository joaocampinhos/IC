public interface IValue {

  public enum VType {
    INTEGER,
    BOOLEAN,
    ID,
    REFERENCE,
    FUN
  }

  VType typeOf();

  String toString();

}
