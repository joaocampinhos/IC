public interface ASTNode {
  IValue eval() throws TypeError;
  void compile(CodeBlock c);
}
