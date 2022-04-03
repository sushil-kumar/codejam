package year2022.qualificationRound;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChainReaction {

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int numCases = scanner.nextInt();
            for (int idx = 0; idx < numCases; ++idx) {
                System.out.print("Case #" + (idx + 1) + ": ");
                int numNodes = scanner.nextInt();
                long[] funFactor = new long[numNodes];
                int[] parents = new int[numNodes];
                Set<Integer> leafNodes = new HashSet<>();
                Set<Integer> rootNodes = new HashSet<>();
                for (int i=0;i<numNodes;++i)
                    funFactor[i] = scanner.nextLong();

                for (int i=0;i<numNodes;++i) {
                    parents[i] = scanner.nextInt();
                    if (parents[i] == 0) 
                        rootNodes.add(i);
                    leafNodes.add(i);
                    if (leafNodes.contains(parents[i] - 1)) {
                        leafNodes.remove(parents[i] - 1);
                    }
                }
                long totalFun = 0;
                // Traverse all the paths
                // 3 2 1 4 5
                // 0 1 1 1 0
                Set<Integer> visited = new HashSet<>();
                System.out.println(leafNodes);
                for (int i : leafNodes) {
                    int currentIndex = i;
                    long tempFun = 0;
                    long localMax = 0;
                    while(true) {
                        tempFun = funFactor[currentIndex];
                        if (localMax < tempFun)
                            localMax = tempFun;
                        visited.add(currentIndex);
                        currentIndex = parents[i] - 1;
                        if (currentIndex < 0 || visited.contains(currentIndex)) {
                            break;
                        }
                    }
                    if (localMax > totalFun)
                        totalFun += localMax;
                }
                System.out.println(totalFun);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
