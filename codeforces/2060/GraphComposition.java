import java.util.*;

public class GraphComposition{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        long[] result = new long[cases];
        for(int c = 0 ; c < cases; c++){
            int n = sc.nextInt();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int[][] f = new int[m1][];
            int[][] g = new int[m2][];
            for(int i = 0 ; i < m1; i++) f[i] = new int[] {sc.nextInt(), sc.nextInt()};
            for(int i = 0 ; i < m2; i++) g[i] = new int[] {sc.nextInt(), sc.nextInt()};

            result[c] = solve(n, f, g);
        }

        Arrays.stream(result).forEach(System.out::println);
    }

    private static long solve(int n, int[][] f, int[][] g){
       UnionFind uf1 = new UnionFind(n+1);
       UnionFind uf2 = new UnionFind(n+1); 

       for(int[] edge: g) uf2.union(edge[0], edge[1]);

       int count = 0;
       for(int[] edge : f){
            if(uf2.isUnion(edge[0], edge[1])){
                uf1.union(edge[0], edge[1]);
            } else count++;
       }

       for(int[] edge: g){
            if(!uf1.isUnion(edge[0], edge[1])){
                uf1.union(edge[0], edge[1]);
                count++;
            }
       }
       return count;
    }

    
}

class UnionFind{
    private int[] ids;
    private int[] size;
    private int numComponents;

    public UnionFind(int n){
        this.numComponents = n;
        this.init();
    }

    private void init(){
        int n = this.numComponents;
        ids = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++){
            ids[i] = i;
            size[i] = 1;
        }
    }

    private int find(int node){
        int root = node;
        while(ids[root] != root){
            root = ids[root];
        }
        //Path compression
        while(ids[node] != node){
            node = ids[node];
            ids[node] = root;
        }
        return root;
    }

    public boolean isUnion(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return true;
        return false;
    }

    public boolean union(int a, int b){
        int root1 = find(a);
        int root2 = find(b);

        if(root1 == root2) return false;
        //Union by rank
        if(size[root1] > size[root2]){
            ids[root2] = root1;
            size[root1] += size[root2];
        } else {
            ids[root1] = root2;
            size[root2] += size[root1];
        }
        numComponents--;
        return true;
    }

    public int getNumComponents(){
        return this.numComponents;
    }

}
