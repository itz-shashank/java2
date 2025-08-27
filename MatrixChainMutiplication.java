import java.util.*;
class MatrixChainMultiplication {
    public static int Matrix(int i,int j,int[] arr,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps=arr[i-1]*arr[k]*arr[j] +Matrix(i,k,arr,dp)+Matrix(k+1, j, arr,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]= min;
    }

    public static void main(String args[]) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] arr=new int[n];
       int dp[][]=new int[n][n];
       for(int i=0;i<n;i++){
        Arrays.fill(dp[i],-1);
       }

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Minimum number of multiplications is " + Matrix(1,n-1, arr,dp));
    }
}