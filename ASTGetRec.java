import java.util.*;

public class ASTGetRec implements ASTNode {
  ASTNode t;
  //String id;
  ASTNode id;

  public IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField{

    IValue r = t.eval(e);
    IValue idv = id.eval(e);

    System.out.println(r.typeOf());
    System.out.println(idv.typeOf());

    if (r.typeOf() == IValue.VType.REC) {

      IdValue name = (IdValue)idv;

      RecValue rec = (RecValue)r;

      Env ee = rec.getEnv();

      //ASTNode el = rec.getParameter(id);
      System.out.println(name.toString());
      ASTNode el = rec.getParameter(name.toString());


      IValue res = el.eval(ee);

      return res;

    } else throw new TypeError();

  }

  public ASTGetRec(ASTNode id, ASTNode t) {
  //public ASTGetRec(String id, ASTNode t) {
    this.t = t;
    this.id = id;
  }

  public IType typeCheck(TypeEnv e) throws TypeError {
    return new CmdType();
  }

  public void compile(CodeBlock c) {
  }
}
