package greedy;

import java.util.*;

public class Q3문자열뒤집기 {
	public static String str;
    public static int count0 = 0; // ���� 0���� �ٲٴ� ���
    public static int count1 = 0; // ���� 1�� �ٲٴ� ���

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        str = sc.next();

	        // ù ��° ���ҿ� ���ؼ� ó��
	        if (str.charAt(0) == '1') {
	            count0 += 1;
	        }
	        else {
	            count1 += 1;
	        }

	        // �� ��° ���Һ��� ��� ���Ҹ� Ȯ���ϸ�
	        for (int i = 0; i < str.length() - 1; i++) {
	            if (str.charAt(i) != str.charAt(i + 1)) {
	                // ���� ������ 1�� �ٲ�� ���
	                if (str.charAt(i + 1) == '1') count0 += 1;
	                // ���� ������ 0���� �ٲ�� ���
	                else count1 += 1;
	            }
	        }

	        System.out.println(Math.min(count0, count1));
		
	}
}
