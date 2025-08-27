import java.util.*;
class MatrixChainMultiplication {
    public static int Matrix(int i,int j,int[] arr){
        if(i==j) return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int steps=arr[i-1]*arr[k]*arr[j] +Matrix(i,k,arr)+Matrix(k+1, j, arr);
            min=Math.min(min,steps);
        }
        return min;
    }

    public static void main(String args[]) {
       Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
       int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println("Minimum number of multiplications is " + Matrix(1,n-1, arr));
    }
}