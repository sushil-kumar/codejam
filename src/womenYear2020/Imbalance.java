package womenYear2020;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Imbalance {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
            	int numMarbles = scanner.nextInt();
                char[] putOrder = new char[numMarbles];
                for (int i=0;i<numMarbles;++i) {
                    System.out.println(putOrder[i]);
                    int removalOrder = scanner.nextInt();
                    putOrder[removalOrder - 1] = (i%2 == 0) ? 'L' : 'R';
                }

            	System.out.println("Case #" + (idx+1) + ": " + new String(putOrder));
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
