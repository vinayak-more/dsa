import java.util.*;

//Problem 4 B <b> Before an Exam </b>
public class BeforeAnExam{
	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int sumTime = sc.nextInt();
		int[][] time = new int[d][2];
		for(int i = 0 ; i < d; i++){
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
		}
		Pair pair = solve(d, sumTime, time);
		System.out.println(pair.ans);
		Arrays.stream(pair.result).forEach(ele -> System.out.print(ele >= 0 ? ele + " " : "0 "));	
	}
	
	private static Pair solve(int d, int sumTime, int[][] time){
		int[] result = new int[d];
		Arrays.fill(result, -1);
		
		for(int i = 0; i < d && sumTime > 0; i++){
			result[i] = time[i][0];
			sumTime -= time[i][0];
		}
		if(sumTime < 0 ){
			return new Pair(NO, new int[]{});
		}
		if(sumTime == 0 ){
			return new Pair(YES, result);
		}
		for(int i = 0; i < d && sumTime > 0; i++){
			if(result[i] == -1 ) continue;
			int diff = time[i][1] - time[i][0];
			int min = Math.min(sumTime, diff);
			result[i] += min;
			sumTime -= min;
		}
		if(sumTime == 0 ){
			return new Pair(YES, result);
		}
		return new Pair(NO, new int[]{});
	} 
}

class Pair{
	String ans;
	int[] result;
	Pair(String ans, int[] result){
		this.ans = ans;
		this.result = result;
	}
}