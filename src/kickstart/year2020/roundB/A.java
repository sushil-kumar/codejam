package kickstart.year2020.roundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                int numPeaks = 0;
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                    if (i > 1) {
                        if (arr[i-1] > arr[i-2] && arr[i-1] > arr[i])
                            numPeaks++;
                    }
                }
                System.out.println("Case #" + (idx+1) + ": " + numPeaks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}