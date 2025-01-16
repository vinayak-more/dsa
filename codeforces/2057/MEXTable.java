import java.util.*;

//Problem 2057 A

public class MEXTable{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		int[] result = new int[cases];
		int row, col;
		for(int c = 0; c < cases; c++){
			row = sc.nextInt();
			col = sc.nextInt();
			result[c] = Math.max(col, row) + 1;
		}
		Arrays.stream(result).forEach(System.out::println);
	}

}
