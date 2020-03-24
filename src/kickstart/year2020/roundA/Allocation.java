package kickstart.year2020.roundA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Allocation {
    public static void main(String[] args) {
        Scanner scanner = null;        
        try {
        	scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));        	
            int numCases = scanner.nextInt();
            for (int idx=0;idx<numCases;++idx) {
                int totalHouseOnSale = scanner.nextInt();
                int totalAmountToSpend = scanner.nextInt();
                int halfAmount = (int) Math.ceil(totalAmountToSpend/2.0);
                int halfAmountAdded = Integer.MAX_VALUE;
                int totalHouseToBuy = 0;
                List<Integer> listOfHouses = new ArrayList<>();
                for (int i=0;i<totalHouseOnSale;++i) {
                    int temp = scanner.nextInt();
                    if (temp <= totalAmountToSpend) {
                        if (temp > halfAmount) {
                            if (temp < halfAmountAdded)
                                halfAmountAdded = temp;
                        } else
                            listOfHouses.add(temp);
                    }
                }
                Collections.sort(listOfHouses);
                for (int i=0;i<listOfHouses.size();++i) {
                    totalAmountToSpend -= listOfHouses.get(i);
                    if (totalAmountToSpend >= 0)
                        totalHouseToBuy++;
                    else {
                        totalAmountToSpend += listOfHouses.get(i);
                        break;
                    }
                }
                if (totalAmountToSpend >= halfAmountAdded) {
                    totalHouseToBuy++;
                }
                System.out.println("Case #" + (idx+1) + ": " + totalHouseToBuy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}