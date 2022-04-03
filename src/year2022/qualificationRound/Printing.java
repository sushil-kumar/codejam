package year2022.qualificationRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Printing {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int idx = 0; idx < numCases; ++idx) {
                System.out.print("Case #" + (idx + 1) + ": ");
                int minM = 0;
                int minY = 0;
                int minC = 0;
                int minK = 0;
                // Printer 1
                for (int i=0;i<4;++i) {
                    int temp = scanner.nextInt();
                    if (i == 0) {
                        minC = temp;
                    } else if (i == 1) {
                        minM = temp;
                    } else if (i == 2) {
                        minY = temp;
                    } else if (i == 3) {
                        minK = temp;
                    }
                }
                // Printer 2
                for (int i=0;i<4;++i) {
                    int temp = scanner.nextInt();
                    if (i == 0) {
                        if (temp < minC)
                            minC = temp;
                    } else if (i == 1) {
                        if (temp < minM)
                            minM = temp;
                    } else if (i == 2) {
                        if (temp < minY)
                            minY = temp;
                    } else if (i == 3) {
                        if (temp < minK)
                            minK = temp;
                    }
                }
                // Printer 3
                for (int i=0;i<4;++i) {
                    int temp = scanner.nextInt();
                    if (i == 0) {
                        if (temp < minC)
                            minC = temp;
                    } else if (i == 1) {
                        if (temp < minM)
                            minM = temp;
                    } else if (i == 2) {
                        if (temp < minY)
                            minY = temp;
                    } else if (i == 3) {
                        if (temp < minK)
                            minK = temp;
                    }
                }
                int sum = minC + minM + minK + minY;
                int total = 1000000;
                if (sum < total)
                    System.out.print("IMPOSSIBLE");
                else {
                    System.out.print(minC + " ");
                    total -= minC;
                    total = printValue(minM, total);
                    total = printValue(minY, total);
                    total = printValue(minK, total);
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static int printValue(int color, int total) {
        int temp = 0;
        if (total > 0) {
            temp = total - color;
            if (temp >= 0) 
                temp = color;
            else {
                if (total > 0)
                    temp = total;
                else
                    temp = 0;
            }
        }
        System.out.print(temp + " ");
        return total - temp;
    }
}

