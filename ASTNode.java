public interface ASTNode {
  IValue eval(Env e) throws TypeError, Env.IdentifierDeclaredTwice, Env.UndeclaredIdentifier, UndefinedField;
  IType typeCheck(TypeEnv e) throws TypeError;
  void compile(CodeBlock c);
}
