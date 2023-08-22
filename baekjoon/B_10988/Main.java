package B_10988;
import java.util.Scanner;

public class Main {
    public static int solve(String arr, int size){
        StringBuffer tmp = new StringBuffer(arr);
        String cmp = tmp.reverse().toString();
        if(cmp.equals(arr)) return 1;
        else return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int size = 0;
        size = str.length();
        int result = solve(str, size);

        System.out.println(result);
    }
}
