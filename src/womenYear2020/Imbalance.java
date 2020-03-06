package womenYear2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Imbalance {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            List<String>  allPermutations = allPossiblePermutations(4);
            for (int idx=0;idx<numCases;++idx) {
            	int numMarbles = scanner.nextInt();
                int[] removalOrder = new int[numMarbles];
                for (int i=0;i<numMarbles;++i) {
                    removalOrder[i] = scanner.nextInt();            
                }

                // Create all possible Permutations
                /*String[] allPermutations = new String[20];
                allPermutations[0] = "L";
                allPermutations[1] = "R";
                int startIndex = 0, endIndex = 2;
                for (int i=1;i<numMarbles;++i) {
                    int len = endIndex;
                    for (int j=startIndex;j<len;++j) {
                        if (isWeightBalanced((allPermutations[j] + "L").toCharArray())) {
                            allPermutations[endIndex] = (allPermutations[j] + "L");
                            endIndex++;
                        }
                        if (isWeightBalanced((allPermutations[j] + "R").toCharArray())) {
                            allPermutations[endIndex] = allPermutations[j] + "R";
                            endIndex++;
                        }
                    }
                    startIndex = len;
                } */

                for (int i=0;i<allPermutations.size();++i) {
                    if (allPermutations.get(i).length() < numMarbles)
                        continue;
                    char temp[] = allPermutations.get(i).toCharArray();
                    int j=0;
                    for (;j<numMarbles;++j) {
                        temp[removalOrder[j] - 1] = '-';
                        if (!isWeightBalanced(temp)) {
                            break;
                        }
                    }
                    if (j == numMarbles) {
                        System.out.println("Case #" + (idx+1) + ": " + allPermutations.get(i));
                        break;
                    }
                }
        	}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null)
                    scanner.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> allPossiblePermutations(int n) {
        // Create all possible Permutations
        List<String> allPermutations = new ArrayList<>();
        allPermutations.add("L");
        allPermutations.add("R");
        int startIndex = 0, endIndex = 2;
        for (int i=1;i<n;++i) {
            int len = endIndex;
            for (int j=startIndex;j<len;++j) {
                if (isWeightBalanced((allPermutations.get(j) + "L").toCharArray())) {
                    allPermutations.add((allPermutations.get(j) + "L"));
                    endIndex++;
                }
                if (isWeightBalanced((allPermutations.get(j) + "R").toCharArray())) {
                    allPermutations.add((allPermutations.get(j) + "R"));
                    endIndex++;
                }
            }
            startIndex = len;
        }
        return allPermutations;
    }
    
    private static boolean isWeightBalanced(char []order) {
        int l = 0, r = 0;
        for (int i=0;i<order.length;++i) {
            if (order[i] == 'L')
                l++;
            else if (order[i] == 'R')
                r++;
            if (Math.abs(l - r) > 1)
                return false;
        }
        return true;
    }
}
