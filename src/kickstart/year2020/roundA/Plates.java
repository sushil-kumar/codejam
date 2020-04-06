package kickstart.year2020.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Plates {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int noOfStacks = scanner.nextInt();
                int platesInEachStack = scanner.nextInt();
                int noOfPlatesToChoose = scanner.nextInt();
                int result = 0;

                int[][] arrayOfPlates = new int[noOfStacks][platesInEachStack];
                int[][] sumOfPlatesInStack = new int[noOfStacks][platesInEachStack];
                for (int i=0;i<noOfStacks;++i) 
                    for (int j=0;j<platesInEachStack;++j) {
                        arrayOfPlates[i][j] = scanner.nextInt();
                        if (j > 0)
                            sumOfPlatesInStack[i][j] = sumOfPlatesInStack[i][j-1] + arrayOfPlates[i][j];
                        else
                            sumOfPlatesInStack[i][j] = arrayOfPlates[i][j];
                    }

                if (noOfStacks == 1) {
                    for (int i=0;i<noOfPlatesToChoose;++i) {
                        result += arrayOfPlates[0][i];
                    }
                } else {
                    int k = 0;
                    int[] indexInStack = new int[noOfStacks];
                    for (int i=0;i<noOfStacks;++i) {
                        indexInStack[i] = -1;
                    }
                    for (int i=0;i<noOfStacks;++i) {
                        for (int j=0;j<platesInEachStack;++j) {
                            if (k < noOfPlatesToChoose) {
                                result += arrayOfPlates[i][j];
                                indexInStack[i] = j;
                                k++;
                            } else {
                                int j2 = i - 1;
                                for (; j2 >= 0; j2--) {
                                    if (indexInStack[j2] != -1)
                                        break;
                                }
                                if (j2 >= 0) {
                                    int temp = result - arrayOfPlates[j2][indexInStack[j2]];
                                    if (temp + arrayOfPlates[i][j] > result) {
                                        result = temp + arrayOfPlates[i][j];
                                        indexInStack[j2]--; 
                                        indexInStack[i] = j;
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                System.out.println("Case #" + (idx+1) + ": " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}