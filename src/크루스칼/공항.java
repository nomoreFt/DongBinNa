package 크루스칼;

import java.util.*;

public class 공항 {
    static int[] parent = new int[100001];
    static int findParent(int x){
        if(x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    static int n,m;//n == 게이트 m == 비행기의 수
    static ArrayList<Integer> planes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i <= n; i++){
            parent[i] = i;
        }

        int cnt = 0;

        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            
            /* 굳이 while문으로 개별적으로 -1 하지 않아도, 2 가 두번올경우
            첫 2 : parent[2] == 1
            두번째 2 : findParent(2) == 1 올거임
            두번째 2에서 unionParent(1,0)하면 
            이후 findParent(2) 할 시에 재귀로 parent[2]는 1, x는 2라서 parent[2] = Findparent(1)//0 이기 떄문에
            결국 1,2 공항이 모두 parent가 0이나 진배없음.
            */
            int root = findParent(x);
            
            
            if(root == 0) break;
            unionParent(root, root-1);
            cnt++;
        }
System.out.println(cnt);
        //arr에서 꺼내서 제일 끝 공항부터 도킹, 해당 parent를 이전과 병합 (parent가 본인이 아닐 경우 도킹된 상태)
        //만약 자리가 차있으면 왼쪽 parent[해당 -1]씩 하며 parent가 자기자신인 아이 찾아서 union시킴
        //병합되면 cnt++
        

    }
    
}
