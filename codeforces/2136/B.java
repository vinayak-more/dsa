import java.util.*;

public class B{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int n, k;
		String str;
		Result[] result = new Result[cases];
		for(int c = 0; c < cases; c++){
			n = sc.nextInt();
			k = sc.nextInt();
			str = sc.next();
			result[c] = solve(n, k, str);
		}
		for(Result r : result){
			if(!r.isPossible){
				System.out.println("NO");
			} else {
				System.out.println("YES");
				for(int p : r.permutation){
					System.out.print(p + " ");
				}
				System.out.println();
			}
		}
	}

	private static Result solve(int n, int k, String str){
		int start = 0, end = 0, count = 0;
		while(end < k ){
			if(str.charAt(end) == '1') count++;
			end++;
		}
		if(count == k) return new Result(false);
		while(end < str.length()){
			if(str.charAt(start) == '1') count--;
			start++;
			if(str.charAt(end) == '1') count++;
			if(count == k) return new Result(false);
			end++;
		}
		int[] permutation = new int[str.length()];
		int lower = 1;
		int upper = n;
		for(int i = 0; i < n; i++){
			permutation[i] = str.charAt(i) == '1' ? lower++ : upper--;
		}
		return new Result(true, permutation);
	}
}
class Result{
	boolean isPossible;
	int[] permutation;

	Result(boolean isPossible){ this.isPossible = isPossible;}
	Result(boolean isPossible, int[] permutation){
		this.isPossible = isPossible;
		this.permutation = permutation;
	} 
}
