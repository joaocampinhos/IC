public interface IValue {

  public enum VType {
    INTEGER,
    BOOLEAN,
    ID
  }

  VType typeOf();

  String toString();

}
