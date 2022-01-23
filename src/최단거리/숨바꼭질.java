package 최단거리;

import java.util.*;

class Barn implements Comparable<Barn>{
    int idx;
    int dist;
    
    public Barn(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }

    @Override
    public int compareTo(Barn other){
        return this.idx - other.idx;
    }
}

public class 숨바꼭질 {
    static int n,m;
    static int[] d = new int[20001];
    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Barn>> graph = new ArrayList<>();

    static void djikstra(int start){
        PriorityQueue<Barn> pq = new PriorityQueue<>();
        pq.offer(new Barn(start,0));
        d[start] = 0;
        while(!pq.isEmpty()){
            Barn b = pq.poll();
            int now = b.idx;
            int dist = b.dist;
            //이미 거쳐가서 1번 헛간 -> now번 헛간까지 최단거리보다
            //현재 꺼낸 헛간의 거리가 더 멀면 skip
            if(d[now] < dist) continue;
            for(int i = 0; i < graph.get(now).size(); i++){
                //비교 cost = 현재 초기화된 (1 -> now)까지 최단거리
                // + now에서 달린 간선의 거리cost 
                int cost = d[now] + graph.get(now).get(i).dist;
                if(cost < d[graph.get(now).get(i).idx]){
                    d[graph.get(now).get(i).idx] = cost;
                    pq.offer(new Barn(graph.get(now).get(i).idx,cost));
                }
            }

        }    
    
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        //최단테이블 초기화
        Arrays.fill(d,INF);
        
        //graph 초기화 (헛간 개수별로 생성)
        for(int i = 0; i <= m; i++){
            graph.add(new ArrayList<Barn>());
        }
        //간선의 개수만큼 쌍방향 list 추가
        for(int i = 0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            
            graph.get(start).add(new Barn(end, 1));
            graph.get(end).add(new Barn(start, 1));
        }
        
        //술래는 항상 1번에서 출발
        //다익스트라로 1번부터 ~N번 헛간까지 최단거리 table 생성
        djikstra(1);
        
        int maxDist = -INF;
        //제일 먼 거리 측정
        for(int i = 1; i <= n; i++){
            maxDist = Math.max(maxDist, d[i]);
        }
        //먼 거리의 d idx를 ArrayList에 삽입 (개수, 거리)
        ArrayList<Barn> maxDistBarns = new ArrayList<>();
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(d[i] == maxDist) {
                maxDistBarns.add(new Barn(i, maxDist));
                cnt+=1;
            }
        }
        Collections.sort(maxDistBarns);
        //제일 앞에놈 select (먼거리의헛간들중idx가 제일 작은놈)
        System.out.println(maxDistBarns.get(0).idx + " " + maxDist + " " + cnt );
        sc.close();
    }
}
