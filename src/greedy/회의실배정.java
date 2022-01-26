package greedy;

import java.util.*;
/**
 * 그리디의 활동선택문제 ( 한 사람이 하나의 활동에 대해서만 작업할 수 있을 때 최대한 많은 활동을 할 수 있는 수를 선택)
 * 탐욕 선택이 이후 결과에 영향을 미치지 않는다.
 * 
 * 서로 겹치지 않는 활동에 대해 종료시간이 빠리면 더 많은 활동을 선택할 수 있는 시간이 많아진다.
 * 
 * 종료시간에 맞춰 정렬 (같으면 시작시간기준 오름차순)
 * 이후 종료시간이 가장 빠른 것순으로 차례차례 담고, 다음 종료시간이 빠른 아이의 시작시간이 
 * 이전 종료시간과 같거나 크면 담음, 그리고 이후 종료시간을 그 아이의 종료시간으로 초기화
 * 
 * https://st-lab.tistory.com/145
 */
public class 회의실배정 {
    static class Conf implements Comparable<Conf>{
        int start;
        int end;
        public Conf(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Conf other){
            if(this.end == other.end){
                return this.start - other.start;
            }
            return this.end - other.end;
        }
        
    }
    static int n;
    static int time[] = new int[100001];
    static ArrayList<Conf> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            arr.add(new Conf(start,end));
        }
        Collections.sort(arr);
        int cnt = 0;
        int prev_end_time = 0;
        
        for(int i = 0; i < arr.size(); i++){
            int now_start_time = arr.get(i).start;
            if(prev_end_time <= now_start_time){
                prev_end_time = arr.get(i).end;
                cnt++;
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
