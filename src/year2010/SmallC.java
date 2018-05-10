package year2010;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SmallC {

	public static void main(String[] args) {
		BufferedWriter writer = null;
        FileWriter fileToWrite = null;
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new File("files/year2010/C-small-practice.in"));
            fileToWrite = new FileWriter("files/year2010/C-small-practice.out");
            writer = new BufferedWriter(fileToWrite);            
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
                System.out.print("Case #" + (i+1) + ": ");
                int R = scanner.nextInt();
                int capacity = scanner.nextInt();
                int N = scanner.nextInt();
                int[] persons = new int[N];
                for (int j=0;j<N;++j)
                	persons[j] = scanner.nextInt();
                if (N == 1) {
                	writeResult(writer, i+1, R * persons[0]);
                	System.out.print(R);
                    System.out.println();
                	continue;
                }
                if (persons[0] > capacity) {
                	writeResult(writer, i+1, 0);
                	System.out.print(0);
                    System.out.println();
                	continue;
                }
                
                int total = 0;
                for (int k=0,l=0;k<R;++k) {
                	int temp = 0;
                	int brk=0;
            		for (;l<N;l=(l+1)%N) {
            			if ((temp + persons[l]) <= capacity && brk < N) {
            				temp += persons[l];
            				brk++;
            			} else {
            				total += temp;
            				break;
            			}
            		}
                }
                writeResult(writer, i+1, total);
            	System.out.print(total);
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
			
	private static void writeResult(BufferedWriter writer, int caseNo, int result) 
            throws IOException {
        writer.write("Case #" + caseNo + ": " + result + "\n");
    }
}
