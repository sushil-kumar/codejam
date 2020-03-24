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
            List<String>  allPermutations = allPossiblePermutations(16);
            //allPermutations.stream().filter(p -> p.length() == 3).forEach(System.out::println);
            boolean isPermutationCalculatedFor1000 = false;
            for (int idx=0;idx<numCases;++idx) {
            	int numMarbles = scanner.nextInt();
                int[] removalOrder = new int[numMarbles];
                for (int i=0;i<numMarbles;++i) {
                    removalOrder[i] = scanner.nextInt();   
                }

                /* if (!isPermutationCalculatedFor1000 && numMarbles > 16) {
                    allPermutations = allPossiblePermutations(1000);
                    isPermutationCalculatedFor1000 = true;
                } */

                int startIndex = 0;
                for (int i=0;i<allPermutations.size();++i) {
                    if (allPermutations.get(i).length() == numMarbles) {
                        startIndex = i;
                        break;
                    }
                }

                for (int i=startIndex;i<allPermutations.size();++i) {
                    char temp[] = allPermutations.get(i).toCharArray();
                    boolean isFound = true;
                    for (int j=0;j<numMarbles;++j) {
                        temp[removalOrder[j] - 1] = '-';
                        if (!isWeightBalanced(temp)) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
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
        int startIndex = 0;
        for (int i=1;i<n;++i) {
            int len = allPermutations.size();
            for (int j=startIndex;j<len;++j) {
                if (isWeightBalanced((allPermutations.get(j) + "L").toCharArray())) {
                    allPermutations.add((allPermutations.get(j) + "L"));
                }
                if (isWeightBalanced((allPermutations.get(j) + "R").toCharArray())) {
                    allPermutations.add((allPermutations.get(j) + "R"));
                }
            }
            startIndex = len;
        }
        return allPermutations;
    }
    
    private static boolean isWeightBalanced(char[] order) {
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
