import java.util.*;

public class ValidParantheses{
	public boolean isValid(String str){
		Deque<Character> stack = new LinkedList<>();
		char ch;
		for(int i = 0; i < str.length(); i++){
			ch = str.charAt(i);
			switch(ch){
				case '{' :
				case '(' :
				case '[' : stack.push(ch); break;
				case '}' : if(stack.isEmpty() || stack.peek() != '{') return false; stack.pop(); break;
				case ')' : if(stack.isEmpty() || stack.peek() != '(') return false; stack.pop(); break;
 				case ']' : if(stack.isEmpty() || stack.peek() != '[') return false; stack.pop(); break;
				default : return false;
			}
		}
		return stack.isEmpty();
	}
}
//([{}])
//i = 0 s = (
//i = 1 s = ( [
//i = 2 s = ( [ {
//i = 3 s = ( [
//i = 4 s = (
//i = 5 s = 
//return true s is empty