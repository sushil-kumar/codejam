package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TroubleSort {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	int n = scanner.nextInt();
            	int v[] = new int[n];
            	ArrayList<Integer> evenList = new ArrayList<>();
            	ArrayList<Integer> oddList = new ArrayList<>();
            	int temp;
            	for (int j=0;j<n;++j) {
            		temp = scanner.nextInt();
            		if (j % 2 == 0)
            			evenList.add(temp);
            		else
            			oddList.add(temp);
            	}
            	Collections.sort(evenList);
            	Collections.sort(oddList);
            	
            	for (int j=0, evenIdx = 0, oddIdx = 0;j<n;++j) {
            		v[j] = j % 2 == 0 ? evenList.get(evenIdx++) : oddList.get(oddIdx++);
            	}
            	
            	int j=0;
            	for (;j<v.length-1;++j) {
            		if (v[j] > v[j+1]) {
            			System.out.println("Case #" + (i+1) + ": " + j);
            			break;
            		}
            	}
            	if (j == v.length-1)
            		System.out.println("Case #" + (i+1) + ": OK");
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
