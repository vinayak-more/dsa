import java.util.*;

public class JohnsCardGame{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        Integer[][] result = new Integer[cases][];
        for(int c = 0; c < cases; c++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<LinkedList<Integer>> list = new ArrayList<>(n);
            for(int i = 0; i < n; i++){
                list.add(new LinkedList<>());
                for(int j = 0; j < m; j++){
                    list.get(i).add(sc.nextInt());
                }
            } 
            result[c] = solve(n, m, list);
        }
        for(int c = 0; c < cases; c++){
            Arrays.stream(result[c]).forEach(ele -> System.out.print((ele + 1) + " "));
            System.out.println();
        }
    }

    private static Integer[] solve(int n, int m, List<LinkedList<Integer>> lists){
        Integer[] order = new Integer[n];
        for(int i = 0; i < n; i++){
            order[i] = i;
        }
        for(List<Integer> list : lists){
            Collections.sort(list);
        }
        Arrays.sort(order, (a, b) -> lists.get(a).getFirst() - lists.get(b).getFirst());
        Collections.sort(lists, (a, b) -> a.getFirst() - b.getFirst());
        //verify the Order
        int i = 0;
        int top = -1;
        int nm = n * m;
        while( i < nm){
            if(top > lists.get(i % n).getFirst()) return new Integer[]{-2};
            top = lists.get(i % n).removeFirst();
            i++;
        }
        return order;
    }
}