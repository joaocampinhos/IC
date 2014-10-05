import java.util.Deque;
import java.util.LinkedList;

public class CodeBlock {

public  Deque<String> myStack= new LinkedList<String>();
	
	public void add(String instrucao){
		myStack.add(instrucao);
	}
	
	public String pop(){
		return myStack.poll();
	}
}
