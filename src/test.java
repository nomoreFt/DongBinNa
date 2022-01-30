import java.io.IOException;
import java.util.*;

public class test {
    static int[] alpha = new int[200];
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            Arrays.fill(alpha,(int)1e9);
            int temp = 0;
            
            for(int i = 0; i < str.length(); i++){
                alpha[str.charAt(i)-'0'] = Math.min(i,alpha[str.charAt(i)-'0']);
            }
            for(int i = ('a'-'0'); i <= ('z'-'0'); i++){
                if(alpha[i] == (int)1e9){
                    System.out.print(-1+" ");    
                }else{
                    System.out.print(alpha[i]+" ");
                }
            }
        }
}
