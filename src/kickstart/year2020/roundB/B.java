package kickstart.year2020.roundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int n = scanner.nextInt();
                long day = scanner.nextLong();
                long[] x = new long[n];
                long[] temp = new long[n];
                for (int i = 0; i < n; ++i) {
                    x[i] = scanner.nextLong();
                    temp[i] = (day / x[i]) * x[i];
                }

                long result = temp[0];
                long resultValue = x[0];
                for (int i = 1; i < n; i++) {
                    if (result > temp[i]) {
                        long curr = result;
                        while (curr > 0) {
                            curr -= resultValue;
                            if (curr < temp[i]) {
                                result = curr;
                                break;
                            }
                        }
                        if (curr < 0) {
                            result = temp[i];
                            resultValue = temp[i];
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