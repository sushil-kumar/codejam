package year2022.round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EqualSum {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                System.out.print("Case #" + (idx+1) + ": ");
                int num = scanner.nextInt();
                long[] data = new long[num*2];
                for (int i=0;i<num;++i) {
                    System.out.println(i + 1);
                    data[i] = i+1;
                }
                for (int i=num;i<num*2;++i) {
                    data[i] = scanner.nextLong();
                    if (data[i] == -1)
                        return;
                }
                printTwoParts(data, num);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    static int findSplitPoint(long arr[], int n)
    {
     
    // traverse array element and compute sum
    // of whole array
    long leftSum = 0;
     
    for (int i = 0 ; i < n ; i++)
        leftSum += arr[i];
 
    // again traverse array and compute right
    // sum and also check left_sum equal to
    // right sum or not
    long rightSum = 0;
     
    for (int i = n-1; i >= 0; i--)
    {
        // add current element to right_sum
        rightSum += arr[i];
 
        // exclude current element to the left_sum
        leftSum -= arr[i] ;
 
        if (rightSum == leftSum)
            return i ;
    }
 
    // if it is not possible to split array
    // into two parts.
    return -1;
    }
 
    // Prints two parts after finding split
    // point using findSplitPoint()
    static void printTwoParts(long arr[], int n)
    {
        int splitPoint = findSplitPoint(arr, n);
     
        if (splitPoint == -1 || splitPoint == n )
        {
            System.out.println("Not Possible" );
            return;
        }
        for (int i = 0; i < n; i++)
        {
            if(splitPoint == i)
                return;
                 
            System.out.print(arr[i] + " ");
        }
    }
}