import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class CodeBlock {

  private  Deque<String> myStack;

  public CodeBlock() {
    myStack= new LinkedList<String>();
  }

  public void add(String instrucao){
    myStack.add(instrucao);
  }

  public String pop(){
    return myStack.poll();
  }
  
  public Iterator<String> compile(){
	  return myStack.iterator();
  }
}
