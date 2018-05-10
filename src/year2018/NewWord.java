package year2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class NewWord {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	int n = scanner.nextInt();
            	int l = scanner.nextInt();
            	if (n == 1 || l == 1) {
            		System.out.println("Case #" + (i+1) + ": -");
            		for (int j=0;j<n;++j)
            			scanner.next();
            		continue;
            	}
            	HashSet<String> words = new HashSet<>();
            	String[] wordArray = new String[n];
            	HashSet<Character> charCount = new HashSet<>();
            	int distinctChars = 0;
            	for (int j=0;j<n;++j) {
            		String temp = scanner.next();
            		for (int k=0;k<temp.length();++k)
            			if (!charCount.contains(temp.charAt(k))) {
            				charCount.add(temp.charAt(k));
            				distinctChars++;
            			}
            		words.add(temp);
            		wordArray[j] = temp;
            	}
            	if (distinctChars < n) {
	            	if ((long)Math.pow(distinctChars, l) == n) {
	            		System.out.println("Case #" + (i+1) + ": -");
	            		continue;
	            	}
            	}
            	String result = "-";
            	label:
            	for (int idx=0;idx<wordArray.length;++idx) {
            		String temp = wordArray[idx];
            		int start = 0;
                	while (true) {
                		start++;
    	            	if (start == l)
    	            		break;
    	            	String t = temp.substring(0, l - start);
                		for (int sidx=0;sidx<wordArray.length;++sidx) {
                			result = t + wordArray[sidx].substring(l - start);
                			if (!words.contains(result))
    	            			break label;
                		}
                	}
            	}
            	            	
            	if (!words.contains(result))
            		System.out.println("Case #" + (i+1) + ": " + result);
            	else
            		System.out.println("Case #" + (i+1) + ": -");
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
