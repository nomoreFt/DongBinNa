package 정렬;
import java.util.*;

class Q26카드정렬하기{
    static PriorityQueue<Integer> pq = new PriorityQueue<>(); 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        for(int i = 0; i < N; i++){
          pq.offer(sc.nextInt());  
        }
        int result = 0;
        while(pq.size() != 1){
            int one = pq.poll();
            int two = pq.poll();
            int sum = one + two;
            result += sum;
            pq.offer(sum);
        }
        System.out.print(result);
    }
}
