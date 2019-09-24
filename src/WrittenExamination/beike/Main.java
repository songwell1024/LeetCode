package WrittenExamination.beike;

import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WilsonSong
 * @Date: 2019/8/10 19:04
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        if (n < 2 || n > 50000){
            System.out.println(0);
        }
        long[] A = new long[n];
        for (int i = 0; i< n; i++){
            A[i] =(long)Integer.parseInt(sc.nextLine());
        }
        System.out.println(getUpLongest(A, n));
    }
    public static int getUpLongest(long[] A, int n) {
        long[] B = new long[n+1]; B[1] = A[0];
        int len=1,start=0,end=len,mid;
        for(int i = 1;i<n;i++){
            if(A[i]>B[len]) {len++;B[len] = A[i];}
            else{
                start=1;end=len;
                while(start<=end){
                    mid=(start+end)/2;
                    if(B[mid]<A[i]) start=mid+1;
                    else end=mid-1;
                } B[start] = A[i];
            }
        }
        return len;
    }

}
