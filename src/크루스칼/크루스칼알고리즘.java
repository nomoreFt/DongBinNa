package 크루스칼;

import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

//크루스칼 알고리즘은 노드들을 최소비용으로 연결할 때 사용된다.
//간선들을 적은 비용으로 정렬해서 적은 비용순으로 길을 연결하고, cycle이 발생하는 간선을 제외하는 그리디 알고리즘
//cycle 체크는 union, find 기법으로 간선으로 연결할 두 노드의 부모가 달라야 cycle이 생기지 않는다고 판단한다.

public class 크루스칼알고리즘 {
    static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int distance;
        public Edge(int nodeA,int nodeB, int distance){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance= distance;
        }

        //A와 B를 잇는 간선중에서 가장 비용이 적은 순으로 꺼냄 (그리디 성질)
        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    static int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    //a와 b의 부모를 구해서 더 큰 쪽이 작은 쪽으로 병합
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    static int v, e; //노드개수, 간선개수
    static int[] parent = new int[100001];//부모 테이블 초기화
    //모든 간선을 담을 리스트와 최종 비용을 담을 변수
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        //부모 테이블 초기화
        for(int i = 0; i <= v; i++){
            parent[i] = i;
        }

        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int dist = sc.nextInt();
            edges.add(new Edge(a, b, dist));
        }
        
        Collections.sort(edges);
        
        for(int i = 0; i < e; i++){
            Edge e = edges.get(i);
            int a = e.nodeA;
            int b = e.nodeB;
            int distance = e.distance;

            if(findParent(a) == findParent(b)) continue;
            unionParent(a, b);
            result += distance;
        }
        System.out.println(result);
    }
    
}
