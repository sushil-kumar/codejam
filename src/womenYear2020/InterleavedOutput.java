package womenYear2020;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InterleavedOutput {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
            	String input = scanner.next();
                int output = 0;
                int i = 0, I = 0;
                for (char c : input.toCharArray()) {
                    if (c == 'I')
                        I++;
                    else if (c == 'i')
                        i++;
                    else {
                        if (c == 'O' && I > 0) {
                            output++;
                            I--;
                        } else {
                            if (i > 0)
                                i--;
                            else
                                I--;
                        }
                    }
                }

            	System.out.println("Case #" + (idx+1) + ": " + output);
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
