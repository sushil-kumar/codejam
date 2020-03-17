package kickstart.year2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            int n, p;
            for (int idx=0;idx<numCases;++idx) {
                n = scanner.nextInt();
                p = scanner.nextInt();
                int coaching = 0;
                Integer[] numPlayers = new Integer[n];
                int maxScore = 0;
                for (int i=0;i<n;++i) {
                    numPlayers[i] = scanner.nextInt();
                    if (numPlayers[i] > maxScore)
                        maxScore = numPlayers[i];
                }
                if (n == 2) {
                    coaching = Math.abs(numPlayers[0] - numPlayers[1]);
                } else if (n == p) {
                    for (int i=0;i<n;++i) {
                        coaching += (maxScore - numPlayers[i]);
                    }
                } else {
                    coaching = Integer.MAX_VALUE;
                    Arrays.sort(numPlayers, Collections.reverseOrder());
                    /* int[] prefixSum = new int[numPlayers.length];
                    prefixSum[0] = numPlayers[0];
                    for (int i=1;i<numPlayers.length;++i) {
                        prefixSum[i] = prefixSum[i-1] + numPlayers[i]; 
                    } */

                    for (int i=0;i<numPlayers.length - p + 1;++i) {
                        int currentCoaching = 0;
                        //currentCoaching = p * numPlayers[i] - prefixSum[i + p - 1];
                        for (int j=i+1;j<i+p;++j) {
                            currentCoaching += (numPlayers[i] - numPlayers[j]);
                        }
                        if (currentCoaching < coaching) {
                            coaching = currentCoaching;
                        }
                    }
                }

                System.out.println("Case #" + (idx+1) + ": " + coaching);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}