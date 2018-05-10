package year2010;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LargeA {

	public static void main(String[] args) {
		BufferedWriter writer = null;
        FileWriter fileToWrite = null;
        Scanner scanner = null;
        Map<Integer, Map<Integer, String>> savedData = new HashMap<Integer, Map<Integer, String>>();
        long startTime = System.currentTimeMillis();
        try {
            scanner = new Scanner(new File("files/year2010/A-large-practice.in"));
            fileToWrite = new FileWriter("files/year2010/A-large-practice.out");
            writer = new BufferedWriter(fileToWrite);
            int numCases = scanner.nextInt();
            StringBuilder builder = new StringBuilder();
            for (int i=0;i<numCases;++i) {
                System.out.print("Case No " + (i+1) + ": ");    
            	builder.append("Case #" + (i+1) + ": ");
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                if (k == 0) {
                	builder.append("OFF\n");
                	System.out.println("OFF\n");
                	System.out.println();
                	continue;
                }
                if (n == 1) {
                	//writeResult(writer, i+1, k%2 == 0 ? "OFF" : "ON");
                	System.out.print(k%2 == 0 ? "OFF" : "ON");
                    System.out.println();
                	builder.append((k%2 == 0 ? "OFF" : "ON") + "\n");
                	continue;
                }
                byte[] stateBits = new byte[n];
                byte[] powerBits = new byte[n];
                powerBits[0] = 1;
                int j = 0;
                if (savedData.containsKey(n)) {
                	int temp = -1;
                	String data = "";
                	for (Map.Entry<Integer, String> entry : savedData.get(n).entrySet()) {
                		if (entry.getKey() < k) {
                			temp = entry.getKey();
                			data = entry.getValue();
                		} else {
                			break;
                		}
                	}
                	if (temp != -1) {
                		stateBits = data.split("#")[0].getBytes();
                		powerBits = data.split("#")[1].getBytes();
                		j = temp;
                	}
                } else {
                	savedData.put(n, new TreeMap<Integer, String>());
                }
                for (;j<k;++j) {
                	stateBits = xor(stateBits, powerBits);
                	powerBits = calculatePower(stateBits);
                }
                boolean result = areAllBitsSet(stateBits); // && areAllBitsSet(power);
                //writeResult(writer, i+1, result ? "ON" : "OFF");
                savedData.get(n).put(k, new String(stateBits) + "#" + new String(powerBits));
                System.out.print(result ? "ON" : "OFF");
                System.out.println();
                builder.append((result ? "ON" : "OFF") + "\n");
            }
            writer.write(builder.toString());
            writer.flush();
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
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken = " + ((endTime - startTime) / 1000) + " sec(s)");
	}
	
	private static byte[] xor (byte[] state, byte[] power) {
		for (int i=0;i<state.length;++i) {
			state[i] = (byte) (state[i] ^ power[i]);
		}
		return state;
	}
	
	private static byte[] calculatePower(byte[] stateBits) {
		byte[] powerBits = new byte[stateBits.length];		
		for (int i=0;i<stateBits.length-1;++i) {
			if (stateBits[i] == 1) {
				powerBits[i+1] = 1;
			} else {
				break;
			}
		}
		powerBits[0] = 1;
		return powerBits;
	}
	
	private static boolean areAllBitsSet(byte[] stateBits) {
		for (int i=0;i<stateBits.length;++i) {
			if (stateBits[i] == 0)
				return false;
		}
        return true;
    }
}
