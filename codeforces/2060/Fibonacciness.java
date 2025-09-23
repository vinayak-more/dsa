import java.util.*;

public class Fibonacciness{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int[] result = new int[cases];
        for(int c = 0; c < cases; c++){
            result[c] = solve(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int solve(int a, int b, int c, int d){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a + b, 1);
        map.put(c - b, map.getOrDefault(c - b, 0) + 1);
        map.put(d - c, map.getOrDefault(d - c, 0) + 1);
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return max;
    }

}