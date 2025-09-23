import java.util.*;
//problem 2048 A
public class CombinationLock{
	private static final String YES = "YES";
	private static final String NO = "NO";
	private static final String TT = "33";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		String[] result = new String[cases];
		for(int k = 0 ; k < cases; k++){
			result[k] = canUnlock2(sc.nextInt());
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static String canUnlock2(int n){
		return n % 33 == 0 ? YES : NO;
	}
	
	private static String canUnlock(int n){
		int m;
		while(n >= 33){
			m = removeConsecutives(n);
			if( m != n) {
				n = m;
				continue;
			}
			else n -= 33;
		}
		return n == 0 ? YES : NO;
	}
	
	private static int removeConsecutives(int n){
		if(n <= 33 ) return n;
		StringBuilder sb = new StringBuilder();
		sb.append(n);
		int index = sb.indexOf(TT);
		if(index == -1 ) return n;
		sb.delete(index, index + 2);
		return Integer.parseInt(sb.toString());
	}
}