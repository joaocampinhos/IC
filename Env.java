import java.util.*;

public class Env {
  Env upper;
  Vector<Assoc> alist;

  class Assoc {
  String id;
        IValue v;
  
  public Assoc(String s, IValue vi)
  {
    id = s;
    v = vi;
        }
  
  String getId() 
  {
      return id;
        }

  IValue getValue() 
  {
      return v;
        }
    }

  public class UndeclaredIdentifier extends Exception {
    String id;

    public UndeclaredIdentifier(String s)
      {
        id = s;
      }
  }

  public class IdentifierDeclaredTwice extends Exception {
    String id;

    public IdentifierDeclaredTwice(String s)
      {
        id = s;
      }
  }

  public Env() {
    upper = null;
    alist = new Vector<Assoc>(5,1);
  }

  private Env(Env up){
    upper = up;
  }

  public Env beginScope() {
    upper = new Env(upper);
    return upper;
  }

  public Env endScope() {
    upper = upper.getUpper();
    return upper;
  }

  public IValue find(String id) throws UndeclaredIdentifier{
    Iterator<Assoc> al = alist.iterator();
            while (al.hasNext()) 
    {   
        Assoc a = al.next();
        if (a.getId().equals(id))
      return a.getValue();
    }
      if (upper != null) 
    return upper.find(id) ;
    else throw new UndeclaredIdentifier(id);
  }

  private Env getUpper(){ 
      return upper;
  }

  void assoc(String id, IValue v) throws IdentifierDeclaredTwice{ 
      Iterator<Assoc> al = alist.iterator();
            while (al.hasNext()) {   
        Assoc a = al.next();
        if (a.getId().equals(id))
      throw new IdentifierDeclaredTwice(id);
    }
      alist.addElement(new Assoc(id,v));
  }

  
}

