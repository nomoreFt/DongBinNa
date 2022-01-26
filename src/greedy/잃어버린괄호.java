package greedy;

import java.io.*;
import java.util.StringTokenizer;
/*
* - 기준으로 나눠서 나머지들을 모두 더한 덩어리들을 -해준다
* 유의사항 맨 앞 숫자는 +
*/
public class 잃어버린괄호{
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        int sum = Integer.MAX_VALUE;

        while(st.hasMoreTokens()){
            int temp = 0;
            
            StringTokenizer st2 = new StringTokenizer(st.nextToken(),"+");
            
            while(st2.hasMoreTokens()){
                temp += Integer.parseInt(st2.nextToken());
            }

            if(sum == Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
    
}