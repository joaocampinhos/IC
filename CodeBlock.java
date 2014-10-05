import java.io.*;
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

  public String debug() throws IOException {
    FileWriter writer = new FileWriter(new File("compile/i"), false);
    String result = "";
    for(Iterator itr = myStack.iterator();itr.hasNext();)  {
      result += itr.next()+"\n";
    }
    writer.write(result);
    writer.close();
    return result;

  }
}
