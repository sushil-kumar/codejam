package year2022.round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DoubleOrOne {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int idx = 0; idx < numCases; ++idx) {
                System.out.print("Case #" + (idx + 1) + ": ");
                String str = scanner.next();
                char[] characters = str.toCharArray();
                char previousCharacter = characters[0];
                StringBuilder sb = new StringBuilder();
                int i = 0;
                StringBuilder same = new StringBuilder();
                for (;i<characters.length;++i) {
                    if (previousCharacter == characters[i]) {
                        same.append(characters[i]);
                    } else {
                        if (previousCharacter <= characters[i]) {
                            sb.append(same);
                            sb.append(same);
                        } else {
                            sb.append(same);
                        }
                        previousCharacter = characters[i];
                        same = new StringBuilder();
                        same.append(characters[i]);
                    }
                }
                sb.append(same);
                System.out.println(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
