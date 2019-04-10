package WrittenExamination.NumberByte;

import java.util.Scanner;

public class Main1
{

    public static int maxSubSum(int[] a) {
        int maxSum = 0;
        int tempSum = 0;

        for (int i = 0; i < a.length; i++) {
            if (tempSum > 0)
                tempSum += a[i];
            else
                tempSum = a[i];

            if (tempSum > maxSum)
                maxSum = tempSum;
        }
        return maxSum * -1;
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i<n; i++)
            array[i] = scanner.nextInt() * -1;
        System.out.print(maxSubSum(array));
    }
}