package greedy;

import java.util.*;

public class ATM {
    static int[] times = new int[1001];
    static int n;
    static ArrayList<Integer> p = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            p.add(sc.nextInt());
        }
        Collections.sort(p);
        int result = 0;
        times[0] = p.get(0);
        for(int i = 1; i < p.size(); i++){
            times[i] = Math.max(times[i], times[i-1] + p.get(i));
            result += times[i];
        }
        System.out.println(result + times[0]);
        sc.close();
    }
}
