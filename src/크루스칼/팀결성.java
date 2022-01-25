package 크루스칼;

import java.util.*;

public class 팀결성 {
    static int n,m;//n학생수 //m 연산수
    static int[] parents = new int[100001];

    static int findParent(int x){
        if(x == parents[x]) return x; //부모와 자신이 같으면 그대로 반환(종료조건)
        else return parents[x] = findParent(parents[x]);//재귀함수로 지속해서 부모를 넣어서 시작부모 (부모와 자기자신이 같은)아이 꺼내줌
    }

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a < b) parents[b] = a; //더 작은 앞순번의 노드에 병합
        else parents[a] = b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        n = sc.nextInt();
        m = sc.nextInt();
        
        //자기자신의 부모 초기화
        for(int i = 0; i <=n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < m; i++){
            int cmd = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if(cmd == 0) unionParent(a, b);
            else if( cmd == 1){
                int parentA = findParent(a);
                int parentB = findParent(b);
                
                if(parentA == parentB) sb.append("TRUE\n");
                else sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
    
}
