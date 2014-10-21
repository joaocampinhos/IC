public interface ASTNode {
  IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier;
  void compile(CodeBlock c);
}
