package 정렬;

import java.util.*;
import java.io.*;

class Student implements Comparable<Student>{
    String name;
    int kor;
    int eng;
    int m;
    public Student(String name, int kr, int eng, int math){
        this.name = name;
        this.kor = kr;
        this.eng = eng;
        this.m = math;
    }
    @Override
    public int compareTo(Student other){
        if (this.kor == other.kor && this.eng == other.eng && this.m == other.m) {
            return this.name.compareTo(other.name);
        }
        if (this.kor == other.kor && this.eng == other.eng) {
            return Integer.compare(other.m, this.m);
        }
        if (this.kor == other.kor) {
            return Integer.compare(this.eng, other.eng);
        }
        return Integer.compare(other.kor, this.kor);
    }
}

class Q23국영수{
    public static ArrayList<Student> students = new ArrayList<>();
    public static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        
        for(int i = 0; i < N; i++){
            strs = br.readLine().split(" ");
            students.add(new Student(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), Integer.parseInt(strs[3])));
        }
        
        Collections.sort(students);
        
        for(int i = 0; i < N; i++){
            System.out.println(students.get(i).name);
        }
    }
}