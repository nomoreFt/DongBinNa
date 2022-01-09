package 이진탐색;

import java.util.*;

class Q30 {
    public static ArrayList<ArrayList<String>> arr = new ArrayList<>();
    public static ArrayList<ArrayList<String>> revArr = new ArrayList<>();
    public static int countByRange(ArrayList<String> arr, String leftValue, String rightValue){
        int rightIndex = upperBound(arr,rightValue, 0, arr.size());
        int leftIndex = lowerBound(arr,leftValue, 0, arr.size());
        return rightIndex - leftIndex;
    }
    public static int lowerBound(ArrayList<String> arr, String target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) >= 0) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public static int upperBound(ArrayList<String> arr, String target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr.get(mid).compareTo(target) > 0 ) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    public int[] solution(String[] words, String[] queries) {
       
        
        for(int i = 0; i< 10001; i++){
            arr.add(new ArrayList<String>());
            revArr.add(new ArrayList<String>());
        }
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int len = word.length();
            arr.get(len).add(word);
            word = (new StringBuffer(word)).reverse().toString();
            revArr.get(len).add(word);
        }
        for(int i = 0; i < 10001; i++){
            Collections.sort(arr.get(i));
            Collections.sort(revArr.get(i));
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            String q = queries[i];
            int res = 0;
            if(q.charAt(0) != '?'){//접미사
                res = countByRange(arr.get(q.length()), q.replaceAll("\\?","a"), q.replaceAll("\\?","z"));
            }else{//접두사
                q = (new StringBuffer(q)).reverse().toString();
                res = countByRange(revArr.get(q.length()), q.replaceAll("\\?","a"),q.replaceAll("\\?","z"));
            }
            result.add(res);
        }
         int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
