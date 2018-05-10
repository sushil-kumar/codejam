package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ant {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	int n = scanner.nextInt();
            	int[] arr = new int[n];
            	for (int j=0;j<arr.length;++j) {
            		arr[j] = scanner.nextInt();            		
            	}
            	int max = -1;            	
            	for (int k=arr.length-1;k>0;--k) {
            		int nAnts = 1;
            		for (int l=k;l>0;--l) {
            			if (arr[l-1]  <= arr[l] * 6) {
            				nAnts++;
            				if (nAnts > max)
            					max = nAnts;
            			} else {            				
            				break;
            			}
            		}
            	}
            	if (max == -1)
            		max = 1;
            	System.out.println("Case #" + (i+1) + ": " + max);
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
