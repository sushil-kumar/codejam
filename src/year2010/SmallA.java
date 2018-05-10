package year2010;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SmallA {

	public static void main(String[] args) {
		BufferedWriter writer = null;
        FileWriter fileToWrite = null;
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new File("files/year2010/A-small-practice.in"));
            fileToWrite = new FileWriter("files/year2010/A-small-practice.out");
            writer = new BufferedWriter(fileToWrite);            
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
                System.out.print("Case No " + (i+1) + ": ");                
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                if (n == 1) {
                	writeResult(writer, i+1, k%2 == 0 ? "OFF" : "ON");
                	System.out.print(k%2 == 0 ? "OFF" : "ON");
                    System.out.println();
                	continue;
                }
                char[] stateBits = new char[n];
                char[] powerBits = new char[n];                
                for (int m=0;m<n;++m) {
                	stateBits[m] = '0';
                	powerBits[m] = '0';
        		}
                powerBits[0] = '1';
                for (int j=0;j<k;++j) {
                	stateBits = xor(stateBits, powerBits);
                	powerBits = calculatePower(stateBits);
                }
                boolean result = areAllBitsSet(stateBits); // && areAllBitsSet(power);
                writeResult(writer, i+1, result ? "ON" : "OFF");
                System.out.print(result ? "ON" : "OFF");
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (scanner != null)
                    scanner.close();
                if (writer != null)
                    writer.close();
                if (fileToWrite != null)
                    fileToWrite.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	private static char[] xor (char[] state, char[] power) {
		for (int i=0;i<state.length;++i) {
			state[i] = state[i] == power[i] ? '0' : '1';
		}
		return state;
	}
	
	private static char[] calculatePower(char[] stateBits) {
		char[] powerBits = new char[stateBits.length];		
		for (int i=0;i<stateBits.length-1;++i) {
			if (stateBits[i] == '1') {
				powerBits[i+1] = '1';
			} else {
				powerBits[i+1] = '0';
				for (++i;i<stateBits.length;++i)
					powerBits[i] = '0';
			}
		}
		powerBits[0] = '1';
		return powerBits;
	}
	
	private static boolean areAllBitsSet(char[] stateBits) {
		for (int i=0;i<stateBits.length;++i) {
			if (stateBits[i] == '0')
				return false;
		}
        return true;
    }
		
	private static void writeResult(BufferedWriter writer, int caseNo, String result) 
            throws IOException {
        writer.write("Case #" + caseNo + ": " + result + "\n");
    }
}
