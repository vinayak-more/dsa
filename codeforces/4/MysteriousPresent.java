import java.util.*;

public class MysteriousPresent{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		List<Envelope> envelopes = new ArrayList<>(n+1);
		envelopes.add(new Envelope(0, w, h));
		int wi, hi;
		for(int i = 0 ; i < n; i++){
			wi = sc.nextInt();
			hi = sc.nextInt();
			if(wi > w && hi > h)
				envelopes.add(new Envelope(i+1, wi, hi));
		}
		int[] result = present(envelopes, w, h);
		System.out.println(result.length);
		Arrays.stream(result).forEach(arr -> System.out.print(arr + " "));
	}

	private static int[] present(List<Envelope> envelopes, int w, int h){
		Collections.sort(envelopes);
		short[][] dp = new short[envelopes.size()][envelopes.size()];
		for(int i = envelopes.size() - 1; i>= 0; i--){
			Arrays.fill(dp[i], (short)-1);
		}
		int[] parent = new int[envelopes.size()];
		Arrays.fill(parent, -1);
		int max = solve(envelopes, 1, 0, dp, parent);
		int[] result = new int[max];
		int count = 0;
		/*System.out.println(envelopes);
		for(int i = 0 ; i < dp.length; i++){
			for(int j = 0; j < dp[i].length; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		Arrays.stream(parent).forEach(System.out::println);*/
		int node = 0;
		while(parent[node] != -1){
			result[count++] = envelopes.get(parent[node]).index;
			node = parent[node];
		}
		return result;
	}

	private static short solve(List<Envelope> envelops, int index, int prev, short[][] dp, int[] parent){
		if(index == envelops.size()) return 0;
		if(dp[index][prev] != -1 ) return dp[index][prev];
		dp[index][prev] = solve(envelops, index + 1, prev, dp, parent);

		if(envelops.get(index).w > envelops.get(prev).w && envelops.get(index).h > envelops.get(prev).h){
			short val = (short)(solve(envelops, index + 1, index, dp, parent) + 1);
			if(dp[index][prev] < val ){
				dp[index][prev] = val;
				parent[prev] = index;
			}
		} 
		return dp[index][prev];
	}
	

}

class Envelope implements Comparable<Envelope>{
	int index;
	int w;
	int h;
	Envelope(int index, int w, int h){
		this.index = index;
		this.w = w;
		this.h = h;
	}

	public int compareTo(Envelope other){
		if(this.w == other.w) return this.h - other.h;
		return this.w - other.w;
	}
	
	public String toString(){
		return (String.format("{index = %d, w = %d, h = %d}", index, w, h));
	}
}
