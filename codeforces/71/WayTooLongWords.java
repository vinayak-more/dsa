import java.util.*;
// Problem 71A
public class WayTooLongWords{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] inputs = new String[n];
		for(int i = 0 ; i < n; i++){
			inputs[i] = sc.next();
		}
		for(String input : inputs){
			solve(input);
		}
	}
	
	private static void solve(String input){
		if(input.length() > 10){
			System.out.println(input.charAt(0) + "" + (input.length() - 2) + "" + input.charAt(input.length() - 1));
		} else {
			System.out.println(input);
		}
	
	}

}