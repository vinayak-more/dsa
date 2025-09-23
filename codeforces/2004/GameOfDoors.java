import java.util.*;
//Problem 2004B

public class GameOfDoors{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] alice = new int[2];
		int[] bob = new int[2];
		int[] result = new int[n];
		for(int i = 0; i < n; i++){
			alice[0] = sc.nextInt();
			alice[1] = sc.nextInt();
			bob[0] = sc.nextInt();
			bob[1] = sc.nextInt();
			result[i] = solve(alice, bob);
		}
		for(int i = 0; i < n; i++){
			System.out.println(result[i]);
		}
	}
	private static int solve(int[] alice, int[] bob){
		if(alice[0] > bob[0]){
			int[] temp = alice;
			alice = bob;
			bob = temp;
		}

		if(bob[0] <= alice[1]){
			int count = Math.min(alice[1], bob[1]) - bob[0];
			if(alice[0] != bob[0]) count++;
			if(alice[1] != bob[1]) count++;
			return count; 
		} else {
			return 1;
		}
		
	}
}