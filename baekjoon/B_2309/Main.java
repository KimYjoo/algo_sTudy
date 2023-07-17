package B_2309;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main{
    public static void solve(int[] arr , int num, int pro){
        ArrayList<Integer> tmp = new ArrayList<>();
        sol(arr, pro, 0, 0, tmp);
        for(int a : tmp){
            System.out.println(a);
        }
    }
    static boolean chkans(int[]arr, ArrayList<Integer> tmp){
        if(tmp.stream().mapToInt(Integer::intValue).sum()== 100) return true;
        return false;
    }
    public static boolean sol(int[]arr, int pro, int sum, int iter, ArrayList<Integer> tmp){
        if(tmp.size() == 7 && chkans(arr, tmp)) return true;
        if(iter < arr.length){
            for(int i = iter; i < arr.length; i++){
                tmp.add(arr[i]);
                if(sol(arr,pro,sum, i+1, tmp)) return true;
                tmp.remove(tmp.size()-1);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 9;
        int pro = 7;
        int[] x = new int[9];
        for(int i = 0; i < num; i++){
            x[i] = sc.nextInt();
        }
        Arrays.sort(x);
        solve(x,num, pro);
    }
}