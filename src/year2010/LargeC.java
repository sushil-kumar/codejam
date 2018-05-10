package year2010;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LargeC {

	public static void main(String[] args) {
		BufferedWriter writer = null;
        FileWriter fileToWrite = null;
        Scanner scanner = null;
        long startTime = System.currentTimeMillis();
        try {        	
            scanner = new Scanner(new File("files/year2010/C-large-practice.in"));
            fileToWrite = new FileWriter("files/year2010/C-large-practice.out");
            writer = new BufferedWriter(fileToWrite);            
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
                System.out.print("Case #" + (i+1) + ": ");
                int R = scanner.nextInt();
                int capacity = scanner.nextInt();
                int N = scanner.nextInt();
                int[] persons = new int[N];
                long totalPersons = 0;
                boolean	allSame = true;
                for (int j=0;j<N;++j) {
                	persons[j] = scanner.nextInt();
                	totalPersons += persons[j];
                	if (allSame && j > 0)
                		allSame = persons[j-1] == persons[j];
                }
                if (N == 1) {
                	writeResult(writer, i+1, R * persons[0]);
                	continue;
                }
                if (persons[0] > capacity) {
                	writeResult(writer, i+1, 0);
                	continue;
                }
                if (totalPersons <= capacity) {
                	writeResult(writer, i+1, R * totalPersons);
                	continue;
                }
                long total = 0;
                for (int k=0,l=0;k<R;++k) {
                	long temp = 0;
            		for (;l<N;l=(l+1)%N) {
            			if ((temp + persons[l]) <= capacity) {
            				temp += persons[l];
            			} else {
            				total += temp;
            				break;
            			}
            		}
            		if (allSame) {
            			total = total * R;
            			break;
            		}
                }
                writeResult(writer, i+1, total);            	
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
        long endTime = System.currentTimeMillis();
        System.out.println("Total Time Taken = " + ((endTime - startTime) / 1000) + " sec(s).");
	}
			
	private static void writeResult(BufferedWriter writer, int caseNo, long result) 
            throws IOException {
        writer.write("Case #" + caseNo + ": " + result + "\n");
        System.out.print(result);
        System.out.println();
    }
}
