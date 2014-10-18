public interface ASTNode {
  IValue eval(Env e) throws TypeError;
  void compile(CodeBlock c);
}
