import java.util.*;
// Problem 4A
public class Watermelon{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		if(w < 3) System.out.println("NO");
		else if(w%2 == 0) System.out.println("YES");
		else System.out.println("No");
	}
}