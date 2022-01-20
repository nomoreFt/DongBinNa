package String;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class time{

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] strs = br.readLine().split(" ");
        int T = Integer.parseInt(strs[0]);
        
        for(int i = 0; i < T; i++){
            strs = br.readLine().split(" ");
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            
            bw.write(a+b);
            bw.flush();
        }
        br.close();
        bw.close();
    }
}

