package year2020.round1A;

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
             
                System.out.println("Case #" + (idx+1) + ": ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}