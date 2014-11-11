public interface IType {

  public enum TType {
    INTEGER,
    BOOLEAN,
    REFERENCE,
    FUN,
    CMD
  }

  TType typeOf();

  String toString();

}
