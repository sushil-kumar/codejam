package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class LollipopShop {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	int n = scanner.nextInt();
            	HashSet<Integer> lollipops = new HashSet<>();
            	for (int l=0;l<n;++l) {
            		lollipops.add(l);
            	}
            	for (int j=0;j<n;++j) {
            		int d = scanner.nextInt();
            		if (d == 0) {
            			System.out.println(-1);
            		} else if (d == 1) {
            			int t = scanner.nextInt();
            			if (lollipops.contains(t)) {
            				System.out.println(t);
            				lollipops.remove(t);
            			} else {
            				System.out.println(-1);
            			}            			
            		} else {
            			HashSet<Integer> dSet = new HashSet<>();         			
	            		for (int k=0;k<d;++k) {
	            			dSet.add(scanner.nextInt());
	            		}
	            		boolean sold = false;
	            		while (!dSet.isEmpty()) {
	            			int r = new Random().nextInt(dSet.size());
	            			Iterator<Integer> itr = dSet.iterator();
	            			int tIdx = 0;
	            			int rand = -1;
	            			do {
	            				rand = itr.next();
	            			} while (tIdx++ < r);
		            		if (lollipops.contains(rand)) {
		            			System.out.println(rand);
		            			lollipops.remove(rand);
		            			sold = true;
		            			break;
		            		}
		            		if (rand != -1)
		            			dSet.remove(rand);
	            		}
	            		if (!sold) {
	            			System.out.println(-1);
	            		}
            		}
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
