package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gopher {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	int A = scanner.nextInt();
            	int limit = 5;
            	List<String> cellsToChoose = new ArrayList<>();
            	if (A == 200) {
            		limit = 15;
            	}
            	int[][] cellsPrepared = new int[limit][limit];
            	
            	for (int j=2;j<limit;++j) {
        			for (int k=2;k<limit;++k) {
        				cellsToChoose.add(j + "," + k);
        			}
        		}
            	while (true) {
            		int idx = new Random().nextInt(cellsToChoose.size());
            		String[] temp = cellsToChoose.get(idx).split(",");
            		int xp = Integer.parseInt(temp[0]);
            		int yp = Integer.parseInt(temp[1]);
            		System.out.println(xp + " " + yp);
            		
	            	int x = scanner.nextInt();
	            	int y = scanner.nextInt();
	            	if (x == -1 && y == -1)
	            		return;
	            	if (x == 0 && y == 0)
	            		break;
	            	// Mark cell as prepared
	            	cellsPrepared[x-1][y-1] = 1;
	            	// remove cells to choose if all adjacent are prepared
	            	boolean allAdjacentPrepared = true; 
	            	outer:
	            	for (int k=-1;k<=1;++k) {
	            		for (int l=-1;l<=1;++l) {
		            		if (cellsPrepared[xp+k-1][yp+l-1] == 0) {
		            			allAdjacentPrepared = false;
		            			break outer;
		            		}
	            		}
	            	}
	            	if (allAdjacentPrepared)
	            		cellsToChoose.remove(idx);
            	}
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
