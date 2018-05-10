package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class RoundingError {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	int n = scanner.nextInt();            	
            	int l = scanner.nextInt();
            	if (n % 10 == 0) {
            		for (int j=0;j<l;++j)
            			scanner.nextInt();
            		System.out.println("Case #" + (i+1) + ": 100");
            		continue;
            	}
            	HashMap<Integer, Integer> cache = new HashMap<>();
            	int arr[] = new int[l];
            	int sum = 0;
            	int totalPerson = 0;
            	boolean allEqual = true;
            	for (int j=0;j<l;++j) {
            		arr[j] = scanner.nextInt();
            		totalPerson += arr[j];
            		int temp = (int) Math.round((double) arr[j] / n * 100);
            		sum += temp;
            		cache.put(arr[j], temp);
            		if (j > 0 && arr[j-1] != arr[j])
            			allEqual = false;
            	}
            	
            	Arrays.sort(arr);
            	
            	int personsRemaining = n - totalPerson;
            	
        		int sum1 = sum + (int) Math.round((double)personsRemaining / n * 100);
        		            		
        		int sum3 = sum;
        		for (int k=0;k<personsRemaining;++k) {
        			 sum3 += (int) Math.round((double)1 / n * 100);
        		}
        		
        		int sum2 = sum;
        		if (allEqual) {
            		sum2 -= cache.get(arr[0]);
            		personsRemaining += arr[0];
            		sum2 += (int) Math.round((double)personsRemaining / n * 100);
        		} else {
        			for (int k=arr.length-1;k>0;++k) {
        				int t = arr[k] - arr[k-1];
        				if (t > 0) {
        					int val = arr[k];
        					sum2 -= cache.get(val);
        					val += (personsRemaining > t) ? t : personsRemaining;
        					sum2 += (int) Math.round((double)val / n * 100);
        					personsRemaining -= t;
        					if (personsRemaining <= 0)
        						break;
        				}
        			}
        			if (personsRemaining > 0) {
        				int val = arr[0];
    					sum2 -= cache.get(val);
    					val += personsRemaining;
    					sum2 += (int) Math.round((double)val / n * 100);
        			}
        			/*int val = arr[arr.length - 1];
        			if (personsRemaining > val) {
        				sum2 += (int) Math.round((double)personsRemaining / n * 100);
        			} else {
        				sum2 -= cache.get(val);
        				val += personsRemaining;
        				sum2 += (int) Math.round((double)val / n * 100);
        			}*/
        		}
        		            		
        		if (sum1 > sum2 && sum1 > sum3) {
        			System.out.println("Case #" + (i+1) + ": " + sum1);
        		} else if (sum2 > sum3) {
        			System.out.println("Case #" + (i+1) + ": " + sum2);
        		} else {
        			System.out.println("Case #" + (i+1) + ": " + sum3);
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
}
