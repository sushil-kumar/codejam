package kickstart.year2020.roundB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                String path = expandPath(scanner.next());
                int row = 1, col = 1;
                int total = 1000000000; 
                for (char c : path.toCharArray()) {
                    if (c == 'E') {
                        if (row == total)
                            row = 1;
                        else 
                            row++;
                    } else if (c == 'W') {
                        if (row == 1)
                            row = total;
                        else
                            row--;
                    } else if (c == 'S') {
                        if (col == total)
                            col = 1;
                        else 
                            col++;
                    } else  if (c == 'N') {
                        if (col == 1)
                            col = total;
                        else 
                            col--;
                    }
                }
                System.out.println("Case #" + (idx+1) + ": " + row + " " + col);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static String expandPath(String p) {
        String result = p;
        
        int lastIndex = p.lastIndexOf("(");
        while (lastIndex != -1) {
            int multiplier = p.charAt(lastIndex-1) - '0';
            String prefix = p.substring(0, lastIndex-1);
            String sufix = p.substring(lastIndex+1);
            int firstIndex = sufix.indexOf(")");
            String sub = sufix.substring(0, firstIndex);
            result = prefix;
            for (int i = 0; i < multiplier; i++) {
                result += sub;
            }
            result += sufix.substring(firstIndex + 1);
            p = new String(result);
            lastIndex = p.lastIndexOf("(");;
        }
        return result;
    }
}