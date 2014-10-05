public interface ASTNode {
  Object eval();
  void compile(CodeBlock c);
}
