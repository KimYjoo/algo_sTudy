package B_2979;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int time;
        boolean status;
        public Node (int time, boolean status){
            this.time = time;
            this.status = status;
        }

        public int compareTo(Node o){
            return time - o.time;
        }
    }
    public static int solve(int[] fee, Node[] test){
        int nowTime = 0;
        int nowTruck = 0;
        int tot = 0;
        for(int i = 0 ; i < test.length; i++){
            if(nowTruck > 0) tot += (test[i].time - nowTime) * fee[nowTruck-1]*nowTruck;
            if(test[i].status){
                nowTruck--;
            }
            else{
                nowTruck++;
            }
            nowTime = test[i].time;
        }
        return tot;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int truckNum = 3;
        int[] fee = new int[3];
        StringTokenizer str = new StringTokenizer(sc.nextLine(), " ");
        int idx = 0;
        while(str.hasMoreTokens()){
            fee[idx++] = Integer.parseInt(str.nextToken());
        }
        Node[] test = new Node[6];
        for(int i = 0; i < test.length; i+=2){
            test[i] = new Node(sc.nextInt(), false);            
            test[i+1] = new Node(sc.nextInt(), true);
            sc.nextLine();
        }
        Arrays.sort(test);
        System.out.println(solve(fee, test));
    }
}

