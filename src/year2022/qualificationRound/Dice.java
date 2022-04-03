package year2022.qualificationRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Dice {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int idx = 0; idx < numCases; ++idx) {
                System.out.print("Case #" + (idx + 1) + ": ");
                int numDices = scanner.nextInt();
                if (numDices == 1) {
                    scanner.nextInt();
                    System.out.println("1");
                    continue;
                }
                boolean isAllEqual = true;
                int[] diceValues = new int[numDices];
                for (int i=0;i<numDices;++i) {
                    diceValues[i] = scanner.nextInt();
                    if (i > 0)
                        isAllEqual = isAllEqual && (diceValues[i-1] == diceValues[i]); 
                }
                if (isAllEqual) {
                    if (numDices > diceValues[0]) {
                        System.out.print(diceValues[0]);
                    } else {
                        System.out.print(numDices);
                    }
                } else {
                    Arrays.sort(diceValues);
                    // 4 4 4 5 6 7 7 7 10 10
                    int numOfSame = 1;
                    int j=1;
                    for (;j<numDices;++j) {
                        if (diceValues[j-1] == diceValues[j]) 
                            numOfSame++;
                        else
                            break;
                    }
                    int currentSequence;
                    if (numOfSame > diceValues[0]) {
                        currentSequence = diceValues[0];
                    } else {
                        currentSequence = numOfSame;
                    }
                    int startIndex = j - currentSequence;
                    int result = startIndex;
                    int len = currentSequence;
                    for (int i=j; i<numDices; i++) {
                        if (diceValues[i] > currentSequence) {
                            currentSequence++;
                            len++;
                        } else {
                            if (result < len) {
                                result = len;
                                currentSequence--;
                                i--;
                            }
                            len--; 
                        }   
                    }
                    if (result < len)
                        result = len;
                    
                    System.out.print(result);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
