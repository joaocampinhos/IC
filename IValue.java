public interface IValue {

  public enum VType {
    INTEGER,
    BOOLEAN,
    ID,
    REFERENCE
  }

  VType typeOf();

  String toString();

}
