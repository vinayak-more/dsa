import java.util.*;

public class TheatreSquare{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		long result =(long) (Math.ceil(n / (double)a) * Math.ceil(m / (double) a));
		System.out.println(result);
	}
}
