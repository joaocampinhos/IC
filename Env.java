public class Env {
  public Env() {
    
  }
  public Env beginScope() {
    return new Env();
  }
  public Env endScope() {
    return new Env();
  }
  public IValue find(String id) {
    return new IntValue(3);
  }
  public void assoc(String id, IValue v) {
  }
}

