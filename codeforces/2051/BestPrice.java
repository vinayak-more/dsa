import java.util.*;
import java.util.stream.*;
//problem 2051 E
public class BestPrice{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		long[] result = new long[cases];
		for(int c = 0; c < cases; c++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			for(int i = 0 ; i < n; i++) a[i] = sc.nextInt();
			for(int i = 0 ; i < n; i++) b[i] = sc.nextInt();
			result[c] = bestPrice(a, b, k);
		}
		Arrays.stream(result).forEach(System.out::println);
	}
	
	private static long bestPrice(int[] a, int[] b, int k){
		long result = 0;
		int n = a.length;
		List<Pair> list1 = new ArrayList<>(a.length);
		Set<Integer> set = new HashSet<>();
		for(int i = 0 ; i < a.length; i++){
			set.add(a[i]);
			set.add(b[i]);
			list1.add(new Pair(a[i], b[i]));
		}
		List<Pair> list2 = new ArrayList<>(list1);
		list1.sort(Comparator.comparingInt(p -> p.b));
		list2.sort(Comparator.comparingInt(p -> p.a));
		//System.out.println(list1);
		//System.out.println(list2);
		long profit = 0;
		int reviews;
		for(Integer price : set){
			profit = 0;
			reviews = 0;
			int customers = n - binarySearch(list1, new Pair(0, price), Comparator.comparingInt(p -> p.b));
			int positives = n - binarySearch(list2, new Pair(price, 0), Comparator.comparingInt(p -> p.a));
			if(customers - positives <= k ) result = Math.max(result, customers * (long)price);
			//System.out.println(String.format("price = %d, customers = %d, positives = %d", price, customers, positives));
		}
		return result;
	}
	
	private static <T> int binarySearch(List<T> list, T key, Comparator<T> comparator){
		int left = 0, right = list.size() - 1;
		int mid = -1;
		while( left <= right){
			mid = left + (right - left)/2;
			int compare = comparator.compare(key, list.get(mid));
			if( compare > 0 ) left = mid + 1;
			else right = mid - 1;
		}
		return left;
	}
}

class Pair{
	int a, b;
	public Pair(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public String toString(){
		return String.format("[ a = %d, b = %d]", a, b);
	}
}