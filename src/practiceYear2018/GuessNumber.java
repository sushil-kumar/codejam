package practiceYear2018;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GuessNumber {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int n = scanner.nextInt();
                a = a+1;
                b = b+1;
                int j=0;
                for (;j<n;++j) {
                	int guess = (b+a)/2;
	                System.out.println(guess);
	                String result = scanner.next();
	                if (result.equals("TOO_SMALL")) {
	                	// Guess a larger number
	                	a = guess;
	                } else if (result.equals("TOO_BIG")) {
	                	// Guess a smaller number
	                	b = guess;
	                } else if (result.equals("CORRECT")) {
	                	// Guessed the number
	                	break;
	                } else if (result.equals("WRONG_ANSWER")) {
	                	return;
	                }
                }
                if (j == n) {
                	scanner.next();
                	return;
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
