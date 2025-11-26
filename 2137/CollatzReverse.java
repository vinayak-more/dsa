import java.util.Scanner;

public class CollatzReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int x = sc.nextInt();
            for (int i = 0; i < k; i++) {
                if (x % 2 == 0) {
                    x = x * 2;
                } else {
                    if ((x - 1) % 3 == 0) {
                        int prev = (x - 1) / 3;
                        if (prev % 2 == 1 && prev > 0) {
                            x = prev;
                        } else {
                            x = x * 2;
                        }
                    } else {
                        x = x * 2;
                    }
                }
            }
            System.out.println(x);
        }
        sc.close();
    }
}
