package 크루스칼;

import java.util.*;

public class 서로소알고리즘 {
    static int v, e;//v 노드, e 간선
    static int[] parent = new int[100001];// 부모 테이블 초기화

    //자신과 부모가 같으면 return,
    //다르다면 재귀적으로 자신의 부모 테이블을 계속 상위 부모 탐색해서 return
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        v = sc.nextInt();
        e = sc.nextInt();

        for(int i = 1; i <= v; i++){
            parent[i] = i;//부모 테이블을 자기 자신으로 초기화
        }

        //간선 정보를 받아 부모 병합
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a,b);
        }


        //부모가 다 병합되면 각 원소가 속한 집합 출력하기
        for(int i = 1; i <= v; i++){
            System.out.println(i + "번째 노드의 부모는 : " + findParent(parent[i]));
        }

        
    }
    
}
