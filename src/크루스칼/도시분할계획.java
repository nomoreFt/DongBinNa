package 크루스칼;

import java.util.*;

/*
도시를 두개로 분할한다는 점에 유의하자.
최소신장트리로 사이클이 돌지 않는 가장 값싼 도로만을 남겨두고
가장 비싼 도로를 하나 없애면 그게 도시 두개가 된다.
*/
public class 도시분할계획 {
    static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int distance;
        
        public Edge (int nodeA, int nodeB, int distance){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Edge other){
            return this.distance - other.distance;
        }
    }
    static int n,m; //n집의 개수 //m 길의 개수
    public static int totalCost = 0;
    static int maxCost = 0;
    static int[] parent = new int[100001];//사이클이 도는지 check할 부모테이블
    static ArrayList<Edge> graph = new ArrayList<>();
    
    static int findParent(int x){
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    static int process(){
        int result = 0;
        for(int i = 0; i < graph.size(); i++){
            Edge edge = graph.get(i);
            int nodeA = edge.nodeA;
            int nodeB = edge.nodeB;
            int cost = edge.distance;

            if(findParent(nodeA) != findParent(nodeB)){
                unionParent(nodeA,nodeB);
                result += cost;
                maxCost = Math.max(maxCost,cost);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i <=n; i++){
            parent[i] = i;
        }
        //각 집 -> 집 끼리 도로 연결 완료
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph.add(new Edge(a,b,cost));
        }
        Collections.sort(graph);//최소비용순으로 edge 초기화

        totalCost = process();
        
        System.out.println(totalCost);
        System.out.println(maxCost);
        System.out.println(totalCost - maxCost);

        sc.close();
        
    }
}
