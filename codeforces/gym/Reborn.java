import java.util.*;

public class Reborn{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println(reborn(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()));
	}
	
	private static String reborn(int hpr, int atkr, int hpx, int atkx){
		if(atkr == atkx ) return hpr > hpx ? "Yes" : "No";
		if(hpr == hpx ) return atkr > atkx ? "Yes" : "No";

		double dr = hpr / atkx;
		double dx = hpx / atkr;
		if(dr > dx ) return "Yes";
		else return "No";
	}
}