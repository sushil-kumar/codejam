package global;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Template {

	public static void mainTemplate () {
		BufferedWriter writer = null;
        FileWriter fileToWrite = null;
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new File("files/year2010/A-small-practice.in"));
            fileToWrite = new FileWriter("files/year2010/A-small-practice.out");
            writer = new BufferedWriter(fileToWrite);            
            int numCases = scanner.nextInt();
            System.out.println("No of Cases = " + numCases);
            for (int i=0;i<numCases;++i) {
                System.out.println("Case No " + (i+1));                
                int n = scanner.nextInt();
                int k = scanner.nextInt();
                System.out.println(n + " = " + k);
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
	
	@SuppressWarnings("unused")
	private static void writeResult(BufferedWriter writer, int caseNo, long result) 
            throws IOException {
        writer.write("Case #" + caseNo + ": " + result + "\n");
        System.out.print(result);
        System.out.println();
    }
	
	public static void main(String[] args) {
	}
	
}
