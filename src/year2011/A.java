package year2011;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) {
		BufferedWriter writer = null;
        FileWriter fileToWrite = null;
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new File("files/year2011/A-large-practice.in"));
            fileToWrite = new FileWriter("files/year2011/A-large-practice.out");
            writer = new BufferedWriter(fileToWrite);            
            int numCases = scanner.nextInt();
            System.out.println("No of Cases = " + numCases);
            for (int i=0;i<numCases;++i) {
                System.out.print("Case #" + (i+1) + ": ");
                int n = scanner.nextInt();
                int total = 0;
                List<Integer> oList = new ArrayList<>();
                List<Integer> bList = new ArrayList<>();
                Queue<String> botQueue = new LinkedList<>();
                int prevO = 1, prevB = 1, nextO, nextB;
                for (int j=0;j<n;++j) {
                	String bot = scanner.next();
                	botQueue.add(bot);
                	if (bot.equals("O")) {
                		nextO = scanner.nextInt();
                		oList.add(Math.abs(prevO - nextO));
                		prevO = nextO;
                	} else {
                		nextB = scanner.nextInt();
                		bList.add(Math.abs(prevB - nextB));
                		prevB = nextB;
                	}
                }
                Integer[] o = oList.toArray(new Integer[oList.size()]);
                Integer[] b = bList.toArray(new Integer[bList.size()]);
                int idxO = 0, idxB = 0;
                String bot = botQueue.element();
                while (true) {
                	boolean isMoved = false, isClicked = false;                	
                	if (bot.equals("O") && o[idxO] == 0) {
                		isClicked = true;
            			idxO++;
            			if (idxB < b.length && b[idxB] > 0) {
                    		b[idxB]--;
            			}
                	} else if (bot.equals("B") && b[idxB] == 0) {
                		isClicked = true;
            			idxB++;
            			if (idxO < o.length && o[idxO] > 0) {
                    		o[idxO]--;
            			}
                	}
                	if (isClicked) {
                		total++;
                		botQueue.remove();
            			bot = botQueue.peek();
            			if (bot == null)
            				break;
                	}
                	
                	if (!isClicked) {
	                	if (idxO < o.length && o[idxO] > 0) { 
	                		o[idxO]--;
	                		isMoved = true;
	                	}
	                	if (idxB < b.length && b[idxB] > 0) {
	                		b[idxB]--;
	                		isMoved = true;
	                	}
	                	if (isMoved)
	                		total++;
                	}
                }
                
                System.out.println(total);
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
	}
	
	private static void writeResult(BufferedWriter writer, int caseNo, int result) 
            throws IOException {
        writer.write("Case #" + caseNo + ": " + result + "\n");
    }
}
