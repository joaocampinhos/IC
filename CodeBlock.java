import java.io.*;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class CodeBlock {

  private  Deque<String> myStack;
  private int counter;

  public CodeBlock() {
    myStack= new LinkedList<String>();
    counter = 0;
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

  public String print() throws IOException {
    String result = "";
    for(Iterator itr = myStack.iterator();itr.hasNext();)  {
      result += itr.next()+"\n";
    }
    return result;

  }

  public String getCounter(){
    return  Integer.toString(counter);
  }

  public void incCounter(){
    counter++;
  }
}
