package year2020.round1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int noOfSlices = scanner.nextInt();
                int dinners = scanner.nextInt();
                long[] sliceAngles = new long[noOfSlices];
                Map<Long, Integer> commonSlices = new HashMap<>();
                boolean resultFound = false;
                for (int i = 0; i < noOfSlices; i++) {
                    sliceAngles[i] = scanner.nextLong();
                    int currentCount = commonSlices.getOrDefault(sliceAngles[i], 0) + 1;
                    commonSlices.put(sliceAngles[i], currentCount);
                    if (!resultFound && currentCount == dinners) {
                        resultFound = true;
                    }
                }
                int result = 0;
                if (!resultFound) {
                    if (dinners == 2) {
                        result = 1;
                    } else {
                        boolean twoCommonFound = false;
                        for (Map.Entry<Long, Integer> entry: commonSlices.entrySet()) {
                            if (entry.getValue() == 2) {
                                twoCommonFound = true;
                                break;
                            }
                        }
                        if (twoCommonFound) {
                            if (noOfSlices > 2)
                                result = 1;
                            else
                                result = 2;
                        } else {
                            result = 2;
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