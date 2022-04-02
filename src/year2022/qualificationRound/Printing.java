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
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                System.out.println("Case #" + (idx + 1) + ":");

                System.out.print("..+-+");
                for (int j=2;j<cols;++j) {
                    System.out.print("-+");
                }
                System.out.println();
                System.out.print("..|.|");
                for (int j=2;j<cols;++j) {
                    System.out.print(".|");
                }
                System.out.println();

                for (int i=1;i<rows;++i) {
                    for (int j=0;j<cols;++j) {
                        if (j == 0) {
                            System.out.print("+-+");
                        } else {
                            System.out.print("-+");
                        }
                    }
                    System.out.println();
                    for (int j=0;j<cols;++j) {
                        if (j == 0) {
                            System.out.print("|.|");
                        } else {
                            System.out.print(".|");
                        }
                    }
                    System.out.println();
                }
                System.out.print("+-+");
                for (int j=1;j<cols;++j) {
                    System.out.print("-+");
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
