package dp;

import java.util.*;

public class Q36편집거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int n = str1.length();
        int m = str2.length();
        int[][] arr = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            arr[i][0] = i;
        }
        for(int j = 1; j <= m; j++){
            arr[0][j] = j;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1];//글자가 같으면 대각선 위
                }else{
                    arr[i][j] = Math.min(arr[i-1][j],Math.min(arr[i][j-1],arr[i-1][j-1]))+1;
                }
            }
        }

        System.out.println(arr[n-1][m-1]);



        











        sc.close();
    }
}
