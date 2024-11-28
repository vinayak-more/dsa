import java.util.*;

public class ReversePolishNotations{
	// + - * /
	public int evalRPN(String[] tokens){
		Deque<Integer> stack = new LinkedList<>();
		int a, b;
		for(String token : tokens){
			switch(token){
				case "+" : stack.push(stack.pop() + stack.pop()); break;
				case "-" : stack.push( - stack.pop() + stack.pop()); break;
				case "*" : stack.push(stack.pop() * stack.pop()); break;
				case "/" : b = stack.pop(); a = stack.pop(); stack.push( a / b); break;
				default : stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
//["1","2","+","3","*","4","-"]
//i = 0 s = 1
//i = 1 s = 2 1
//i = 2 s = 3
//i = 3 s = 3 3
//i = 4 s = 9
//i = 5 s = 4 9
//i = 6 s = 5