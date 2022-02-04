import java.io.IOException;
import java.util.*;

public class test {
        static int count0 = 0;
        static int count1 = 0;
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();

            if(str.charAt(0) == '1'){
                count0++;
            }else{
                count1++;
            }

            for(int i = 0; i < str.length()-1; i++){
                if(str.charAt(i) != str.charAt(i+1)){
                    if(str.charAt(i+1) == '1'){
                        count0++;
                    }else{
                        count1++;
                    }
                }
            }
            System.out.println(Math.min(count0,count1));
    }
}
