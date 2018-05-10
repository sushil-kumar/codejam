package practiceYear2018;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Senator {
	public static void main(String[] args) {
        Scanner scanner = null;        
        try {
            //scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        	scanner = new Scanner(new File("files/A-small-practice.in"));
            int numCases = scanner.nextInt();
            for (int i=0;i<numCases;++i) {
            	System.out.print("Case #" + (i+1) + ": ");
                int nParty = scanner.nextInt();
                List<String> senatorName = new ArrayList<>();
                List<Integer> nSenator = new ArrayList<>();
                char temp = 'A';
                for (int j=0;j<nParty;++j) {
                	senatorName.add(String.valueOf(temp));
                	nSenator.add(scanner.nextInt());                	
                	temp++;
                }
                
                concurrentSort(nSenator, nSenator, senatorName);
                nParty--;		// Starting from Last Element
                while (nParty > 0) {
                	if (nParty == 1) {
                		if (nSenator.get(0) == nSenator.get(1)) {
                			System.out.print(senatorName.get(0) + senatorName.get(1) + " ");
                			if (nSenator.get(0) == 2)
                				System.out.print(senatorName.get(0) + senatorName.get(1) + " ");
                			nParty = 0;
                		}
                	} else {
                		int t = nSenator.get(nParty);
                		System.out.print(senatorName.get(nParty) + " ");
                		nSenator.remove(nParty);
                		if (t == 1) {
                			senatorName.remove(nParty);
                			nParty--;
                		} else {
                			nSenator.add(nParty, t - 1);
                		}
                	}
                	concurrentSort(nSenator, nSenator, senatorName);
                }
                System.out.println();
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
	
	public static <T extends Comparable<T>> void concurrentSort(final List<T> key, List<?>... lists) {
		// Create a List of indices
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < key.size(); i++)
			indices.add(i);

		// Sort the indices list based on the key
		Collections.sort(indices, new Comparator<Integer>() {
			@Override
			public int compare(Integer i, Integer j) {
				return key.get(i).compareTo(key.get(j));
			}
		});
		//Collections.sort(indices, Collections.reverseOrder());

		// Create a mapping that allows sorting of the List by N swaps.
		// Only swaps can be used since we do not know the type of the lists
		Map<Integer, Integer> swapMap = new HashMap<Integer, Integer>(indices.size());
		List<Integer> swapFrom = new ArrayList<Integer>(indices.size()),
				swapTo = new ArrayList<Integer>(indices.size());
		for (int i = 0; i < key.size(); i++) {
			int k = indices.get(i);
			while (i != k && swapMap.containsKey(k))
				k = swapMap.get(k);

			swapFrom.add(i);
			swapTo.add(k);
			swapMap.put(i, k);
		}

		// use the swap order to sort each list by swapping elements
		for (List<?> list : lists) {
			for (int i = 0; i < list.size(); i++)
				Collections.swap(list, swapFrom.get(i), swapTo.get(i));
			//Collections.reverse(list);
		}
	}
}
