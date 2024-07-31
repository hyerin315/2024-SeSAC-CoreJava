import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		String [] array = {"한지민", "박지민", "홍지민", "한지민", "홍지민", "신지민", "곽지민"};
		Stack<String> stack = new Stack<String>();
		for(String element : array) {
			stack.push(element);
		}
		//System.out.println(stack.peek());
		while(!stack.empty())   System.out.println(stack.pop());
	}
}
