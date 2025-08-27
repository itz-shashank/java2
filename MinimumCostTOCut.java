

// Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
// Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
// You should perform the cuts in order, you can change the order of the cuts as you wish.
// The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
// Return the minimum total cost of the cuts.



import java.util.*;
public class MinimumCostTOCut {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
       ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<c;i++){
            a.add(sc.nextInt());

        }
        a.addFirst(0);
        a.addLast(n);
        int dp[][]=new int[c+2][c+2];
        for(int i=c;i>0;i--){
            for(int j=i;j<=c;j++){
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost=a.get(j+1)-a.get(i-1)+dp[i][k-1]+dp[k+1][j];
                    min=Math.min(min,cost);
                }
                dp[i][j]=min;
            }
        }
        System.out.print("Minimumm cost to cut the rod is : "+dp[1][c]);
    }
}
