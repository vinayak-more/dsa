
class FIFOCache{

    public FIFOCache(int capacity){
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {
    }

}

public class FIFOCacheSolution{
    public static void main(String[] args){
        FIFOCache cache = new FIFOCache(2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1) == 1 ? 1 : "FAILED check 1");       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2) == -1 ? "PASSED" : "FAILED check 2");       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1) == -1 ? "PASSED" : "FAILED check 3");       // returns -1 (not found)
        System.out.println(cache.get(3) == 3 ? "PASSED" : "FAILED check 3");       // returns 3
        System.out.println(cache.get(4) == 4 ? "PASSED" : "FAILED check 3");       // returns 4
    }
}