public interface ASTNode {
  IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField;
  void compile(CodeBlock c);
}
