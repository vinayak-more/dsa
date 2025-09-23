import java.util.*;

public class Pow{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int p = sc.nextInt();
		System.out.println(pow(n, p));
	}
	
	private static long pow(int n, int p){
		if(p == 1) return n;
		if(p == 0) return 1;
		long half = pow(n, p/2);
		long result = half * half;
		if(p %2 == 1 ) result *= n;
		return result;
	}
}
