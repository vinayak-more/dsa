import java.util.*;

//Problem 2050E
public class ThreeStrings{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String a, b, c;
		int[] result = new int[n];
		for(int i = 0; i < n; i++){
			a = sc.next();
			b = sc.next();
			c = sc.next();
			result[i] = minReplacement(a, b, c);
		}
		for(int i = 0; i < n; i++){
			System.out.println(result[i]);
		}
	}
	
	private static int minReplacement(String a, String b, String c){
		int[][] dp = new int[a.length()+1][b.length()+1];
		for(int[] d : dp){
			Arrays.fill(d, Integer.MAX_VALUE);
		}
		dp[0][0] = 0;
		for(int i = 0; i <= a.length(); i++){
			for(int j = 0; j <= b.length(); j++){
				if( i > 0 ){
					int cost = a.charAt(i-1) == c.charAt(i + j - 1) ? 0 : 1;
					dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + cost);
				}
				if( j > 0 ){
					int cost = b.charAt(j-1) == c.charAt(i + j - 1) ? 0 : 1;
					dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + cost);
				}
			}
		}
		return dp[a.length()][b.length()];
		
	}
	
	
}